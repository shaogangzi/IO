package com.sg.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/***
 * 节点流
 * 
 * 字节流 FileInputStream FileOutPutStream 字符流 FileReader FileWriter 处理文本文件
 * 
 * @author sg
 *
 */

public class Demo04TestInPutStream {
	public static void main(String[] args) {
		// 文件的输入流
		File file = new File("hello.txt");
		TestInputStream01(file);
		TestInputStream02(file);
	    
		
	}

	// 包装为String进行输出
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
					// 流一定要进行关闭
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 直接采用数组进行输出
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
					// 流一定要记得关闭
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
