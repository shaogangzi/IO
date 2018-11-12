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
 * nio与传统的io不同之处在于nio是基于通道和非阻塞的 其中非阻塞是基于网络通讯而言的
 * @author sg
 *
 */

public class TestDemo {
	@Test
	public void Client() throws IOException {
		// 设置Socket
		SocketChannel clientChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
		// 读取本地文件
		FileChannel inChannel = FileChannel.open(Paths.get("hello2.txt"), StandardOpenOption.READ);

		ByteBuffer buf = ByteBuffer.allocate(1024);
		while ((inChannel.read(buf) != -1)) {
			buf.flip();
			clientChannel.write(buf);
			buf.clear();
		}
		// 关闭通道
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
