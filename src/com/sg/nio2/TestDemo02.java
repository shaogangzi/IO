package com.sg.nio2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import org.junit.Test;
import java.nio.ByteBuffer;

public class TestDemo02 {

	@Test
	public void client() throws IOException {
		SocketChannel clientChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
		FileChannel inFileChannel = FileChannel.open(Paths.get("hook.txt"), StandardOpenOption.READ);

		// ���û�����
		ByteBuffer buff = ByteBuffer.allocate(1024);
		while ((inFileChannel.read(buff)) != -1) {
			buff.flip();
			clientChannel.write(buff);
			buff.clear();
		}

		clientChannel.shutdownOutput();

		int len;
		while ((len = clientChannel.read(buff)) != -1) {
			buff.flip();
			System.out.println(new String(buff.array(), 0, len));
			buff.clear();
		}
		inFileChannel.close();
		clientChannel.close();

	}

	@Test
	public void server() throws IOException {

		ServerSocketChannel serverChannel = ServerSocketChannel.open();
		FileChannel fileChannel = FileChannel.open(Paths.get("BlokingDemo2.txt"), StandardOpenOption.WRITE,
				StandardOpenOption.CREATE);
		serverChannel.bind(new InetSocketAddress(9898));
		SocketChannel accept = serverChannel.accept();

		ByteBuffer buff = ByteBuffer.allocate(1024);
		while (accept.read(buff) != -1) {
			buff.flip();
			fileChannel.write(buff);
			buff.clear();
		}

		buff.put("jjjj".getBytes());
		buff.flip();
		accept.write(buff);
		accept.close();
		fileChannel.close();
		serverChannel.close();

	}

	// �ͻ���
	@Test
	public void client1() throws IOException {
		SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));

		FileChannel inChannel = FileChannel.open(Paths.get("hook.txt"), StandardOpenOption.READ);

		ByteBuffer buf = ByteBuffer.allocate(1024);

		while (inChannel.read(buf) != -1) {
			buf.flip();
			sChannel.write(buf);
			buf.clear();
		}

		// ֪ͨ���������ݷ������
		sChannel.shutdownOutput();

		// ���շ���˵ķ���
		int len = 0;
		while ((len = sChannel.read(buf)) != -1) {
			buf.flip();
			System.out.println(new String(buf.array(), 0, len));
			buf.clear();
		}

		inChannel.close();
		sChannel.close();
	}

	// �����
	@Test
	public void server1() throws IOException {
		ServerSocketChannel ssChannel = ServerSocketChannel.open();

		FileChannel outChannel = FileChannel.open(Paths.get("hook2.txt"), StandardOpenOption.WRITE,
				StandardOpenOption.CREATE);

		ssChannel.bind(new InetSocketAddress(9898));

		SocketChannel sChannel = ssChannel.accept();

		ByteBuffer buf = ByteBuffer.allocate(1024);

		while (sChannel.read(buf) != -1) {
			buf.flip();
			outChannel.write(buf);
			buf.clear();
		}

		// ���ͷ������ͻ���
		buf.put("����˽������ݳɹ�".getBytes());
		buf.flip();
		sChannel.write(buf);

		sChannel.close();
		outChannel.close();
		ssChannel.close();

	}
}
