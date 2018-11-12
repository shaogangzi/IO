package com.sg.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * �ļ��������
 * 
 * @author sg
 *
 */
public class Demo05TestOutPutStream {
	public static void main(String[] args) {
		File f = new File("hello2.txt");
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(f);
			//���ֽ��������ʽ�������
			fos.write(new String("This is a good job").getBytes());
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
