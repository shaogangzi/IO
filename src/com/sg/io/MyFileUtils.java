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
 * 问价你的输入流与输出流
 * 
 * @author sg
 *
 */
public class MyFileUtils {
	/**
	 * 
	 * @param src
	 *            源文件的绝对路径
	 * @param des
	 *            目的文件的绝对路径,文件路径若不存在，将会自动创建 若给出的是一个目录,则将自动将在该目录下创建与源文件相同名称的文件
	 */
	public static void copyFileTo(String src, String des) {
		copyFileTo(new File(src), new File(des));
		
	}

	/**
	 * 
	 * @param src
	 *            源文件的绝对路径
	 * @param des
	 *            目的文件的绝对路径,文件路径若不存在，将会自动创建 若给出的是一个目录,则将自动将在该目录下创建与源文件相同名称的文件
	 */
	public static void copyFileTo(File src, File des) {
		// 文件大小保留两位小数
		DecimalFormat df1 = new DecimalFormat(".00");
		long startTime = 0;
		long endTime = 0;
		FileInputStream fis = null;
		FileOutputStream fos = null;

		// 文件存在
		if (des.exists()) {
			if (des.isDirectory()) {
				if (des.getAbsolutePath().endsWith("\\")) {
					des = new File(des.getAbsolutePath() + src.getName());
				} else {
					des = new File(des.getAbsolutePath() + "\\" + src.getName());
				}
			}
		} else {
			// 给定的路径是指向不是一个文件,即不包含‘.’
			if (!des.getName().contains(".")) {
				des.mkdirs();
				if (des.isDirectory())
					des = new File(des.getAbsolutePath() + "\\" + src.getName());
			} else {
				// 是文件
				des.getParentFile().mkdirs();
			}
		}
		try {
			System.out.println(des);
			long length = src.length();
			if (length / 1024 > 1024)
				System.out.println("文件大小为:" + df1.format(length / (1024.0000 * 1024)) + "M");
			else
				System.out.println("文件大小为:" + df1.format(length / (1024.0000)) + "字节");
			fis = new FileInputStream(src);
			fos = new FileOutputStream(des);
			byte[] b = new byte[1024];
			int len;
			startTime = System.currentTimeMillis();
			while ((len = fis.read(b)) != -1) {
				fos.write(b, 0, len);
			}
			endTime = System.currentTimeMillis();
			System.out.println("传输时长:" + (endTime - startTime) / 1000.0 + "(S)");
			System.out.println("传输完成!");
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
