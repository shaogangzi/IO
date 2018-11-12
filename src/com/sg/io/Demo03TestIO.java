package com.sg.io;

import java.io.File;

/**
 * 按数据单位，分为字节流(8bit) 字符流(16bit)
 * InputStream OutputStream
 * Reader      Writer
 * @author sg
 *
 */
public class Demo03TestIO {
    public static void main(String[] args) {
		MyFileUtils.copyFileTo("D:/计算机常见编码.pdf", "D:/计算机.doc");
	}
}
