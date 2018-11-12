package com.sg.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/***
 * BufferInPutStream BufferOutPutStream
 * �ֱ��Ƕ���FileInputStream��BufferOutPutStream�İ�װ
 *
 * 
 * @author sg
 *
 */
public class Demo07TestBufferInAndOutPutStream {
	public static void main(String[] args) {
		test1();
	}

	private static void test1() {
		File src = new File("hello2.txt");
		File des = new File("testBuffer.txt");
		BufferedOutputStream bos;
		BufferedInputStream bis;
		// �ڵ���
		try {
			FileInputStream fis = new FileInputStream(src);
			FileOutputStream fos = new FileOutputStream(des);

			// ������(��������
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);

			byte[] b = new byte[1024];
			int len;
			while ((len = bis.read(b)) != -1) {
				bos.write(b);
			}

			bos.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

	}
}
