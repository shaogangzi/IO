package com.sg.nio2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.junit.Test;

/**
 * nio�봫ͳ��io��֮ͬ������nio�ǻ���ͨ���ͷ������� ���з������ǻ�������ͨѶ���Ե�
 * @author sg
 *
 */

public class TestDemo {
	@Test
	public void Client() throws IOException {
		// ����Socket
		SocketChannel clientChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
		// ��ȡ�����ļ�
		FileChannel inChannel = FileChannel.open(Paths.get("hello2.txt"), StandardOpenOption.READ);

		ByteBuffer buf = ByteBuffer.allocate(1024);
		while ((inChannel.read(buf) != -1)) {
			buf.flip();
			clientChannel.write(buf);
			buf.clear();
		}
		// �ر�ͨ��
		inChannel.close();
		clientChannel.close();
	}

	@Test
	public void server() throws IOException {
      ServerSocketChannel ss=ServerSocketChannel.open();
      ss.bind(new InetSocketAddress(9898));
      FileChannel f=FileChannel.open(Paths.get("nioBloking.txt"),StandardOpenOption.WRITE,StandardOpenOption.CREATE);
      ByteBuffer buff=ByteBuffer.allocate(1024);
      SocketChannel acceptChannel = ss.accept();

      while((acceptChannel.read(buff)!=-1)){
    	  buff.flip();
    	  f.write(buff);
    	  buff.clear();
      }
    	f.close();	
    	ss.close();
	}
}
