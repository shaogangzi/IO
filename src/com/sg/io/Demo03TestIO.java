package com.sg.io;

import java.io.File;

/**
 * �����ݵ�λ����Ϊ�ֽ���(8bit) �ַ���(16bit)
 * InputStream OutputStream
 * Reader      Writer
 * @author sg
 *
 */
public class Demo03TestIO {
    public static void main(String[] args) {
		MyFileUtils.copyFileTo("D:/�������������.pdf", "D:/�����.doc");
	}
}
