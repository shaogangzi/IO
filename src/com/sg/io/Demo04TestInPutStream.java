package com.sg.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/***
 * �ڵ���
 * 
 * �ֽ��� FileInputStream FileOutPutStream �ַ��� FileReader FileWriter �����ı��ļ�
 * 
 * @author sg
 *
 */

public class Demo04TestInPutStream {
	public static void main(String[] args) {
		// �ļ���������
		File file = new File("hello.txt");
		TestInputStream01(file);
		TestInputStream02(file);
	    
		
	}

	// ��װΪString�������
	public static void TestInputStream01(File file) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			byte[] b = new byte[10];
			int len;
			while ((len = fis.read(b)) != -1) {
				String s = new String(b, 0, len);
				System.out.println(s);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					// ��һ��Ҫ���йر�
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// ֱ�Ӳ�������������
	public static void TestInputStream02(File file) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			byte[] b = new byte[10];
			int len;
			while ((len = fis.read(b)) != -1) {
				for (int i = 0; i < len; i++) {
					System.out.print((char) b[i]);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					// ��һ��Ҫ�ǵùر�
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
