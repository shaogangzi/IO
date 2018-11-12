package com.sg.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 测试通道channel
 * 
 * @author sg
 * 
 *         实现通道的主要的类： FileChannel 本地文件有关的 socket ServerSocket DatagramSocket
 *         UDP相关的
 * 
 * 
 * 
 *         1.针对支持通道的类提供了getChannel的方法 本地： FileInputStream/FileOutPutStream
 *         RandomAccessFile 网络： Socket ServerSocket DatagramSocket
 *         2.在jdk1.7中的NIO针对每种通道提供了open静态方法
 *         3.在jdk1.7中Files工具类中提供了newByteChannel的方法
 * 
 * 
 */

public class Demo03_TestChannel {
	public static void main(String[] args) {
		File src = new File("hook.txt");
		File des = new File("hook2.txt");
		FileInputStream fis = null;
		FileOutputStream fos = null;
		FileChannel channel = null;
		FileChannel channel2 = null;
		try {
			fis = new FileInputStream(src);
			fos = new FileOutputStream(des);

			// 获取通道
			channel = fis.getChannel();
			channel2 = fos.getChannel();

			// 创建缓冲区
			ByteBuffer buf = ByteBuffer.allocate(1024);

			// 向通道中写
			while (channel.read(buf) != -1) {
				// 改变模式
				buf.flip();
				// 写出去
				channel2.write(buf);
				buf.clear();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (channel2 != null) {
			try {
				channel2.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (channel != null) {
			try {
				channel.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (fos != null) {
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (fis != null) {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
