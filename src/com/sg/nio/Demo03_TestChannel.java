package com.sg.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * ����ͨ��channel
 * 
 * @author sg
 * 
 *         ʵ��ͨ������Ҫ���ࣺ FileChannel �����ļ��йص� socket ServerSocket DatagramSocket
 *         UDP��ص�
 * 
 * 
 * 
 *         1.���֧��ͨ�������ṩ��getChannel�ķ��� ���أ� FileInputStream/FileOutPutStream
 *         RandomAccessFile ���磺 Socket ServerSocket DatagramSocket
 *         2.��jdk1.7�е�NIO���ÿ��ͨ���ṩ��open��̬����
 *         3.��jdk1.7��Files���������ṩ��newByteChannel�ķ���
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

			// ��ȡͨ��
			channel = fis.getChannel();
			channel2 = fos.getChannel();

			// ����������
			ByteBuffer buf = ByteBuffer.allocate(1024);

			// ��ͨ����д
			while (channel.read(buf) != -1) {
				// �ı�ģʽ
				buf.flip();
				// д��ȥ
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
