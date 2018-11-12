package com.sg.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * �ʼ�����������������
 * 
 * @author sg
 *
 */
public class MyFileUtils {
	/**
	 * 
	 * @param src
	 *            Դ�ļ��ľ���·��
	 * @param des
	 *            Ŀ���ļ��ľ���·��,�ļ�·���������ڣ������Զ����� ����������һ��Ŀ¼,���Զ����ڸ�Ŀ¼�´�����Դ�ļ���ͬ���Ƶ��ļ�
	 */
	public static void copyFileTo(String src, String des) {
		copyFileTo(new File(src), new File(des));
		
	}

	/**
	 * 
	 * @param src
	 *            Դ�ļ��ľ���·��
	 * @param des
	 *            Ŀ���ļ��ľ���·��,�ļ�·���������ڣ������Զ����� ����������һ��Ŀ¼,���Զ����ڸ�Ŀ¼�´�����Դ�ļ���ͬ���Ƶ��ļ�
	 */
	public static void copyFileTo(File src, File des) {
		// �ļ���С������λС��
		DecimalFormat df1 = new DecimalFormat(".00");
		long startTime = 0;
		long endTime = 0;
		FileInputStream fis = null;
		FileOutputStream fos = null;

		// �ļ�����
		if (des.exists()) {
			if (des.isDirectory()) {
				if (des.getAbsolutePath().endsWith("\\")) {
					des = new File(des.getAbsolutePath() + src.getName());
				} else {
					des = new File(des.getAbsolutePath() + "\\" + src.getName());
				}
			}
		} else {
			// ������·����ָ����һ���ļ�,����������.��
			if (!des.getName().contains(".")) {
				des.mkdirs();
				if (des.isDirectory())
					des = new File(des.getAbsolutePath() + "\\" + src.getName());
			} else {
				// ���ļ�
				des.getParentFile().mkdirs();
			}
		}
		try {
			System.out.println(des);
			long length = src.length();
			if (length / 1024 > 1024)
				System.out.println("�ļ���СΪ:" + df1.format(length / (1024.0000 * 1024)) + "M");
			else
				System.out.println("�ļ���СΪ:" + df1.format(length / (1024.0000)) + "�ֽ�");
			fis = new FileInputStream(src);
			fos = new FileOutputStream(des);
			byte[] b = new byte[1024];
			int len;
			startTime = System.currentTimeMillis();
			while ((len = fis.read(b)) != -1) {
				fos.write(b, 0, len);
			}
			endTime = System.currentTimeMillis();
			System.out.println("����ʱ��:" + (endTime - startTime) / 1000.0 + "(S)");
			System.out.println("�������!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
