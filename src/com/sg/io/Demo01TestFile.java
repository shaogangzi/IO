package com.sg.io;

import java.io.File;
import java.io.IOException;
/***
 * java.io.File ��ʾһ���ļ�����Ŀ¼
 * File�����漰���ļ����޸�ɾ���ȣ��޷��漰���ļ�����
 * �ļ���������Ҫ�õ�I/O��
 * mkdir �����ļ�Ŀ¼��ʱ���ļ�Ŀ¼����һ��Ŀ¼Ӧ�ô���
 * mkdirs �����ļ�Ŀ¼��ʱ���ļ�Ŀ¼����һ��Ŀ¼��������ڣ���һ�𴴽���
 * createNewFile �����ļ�
 * 
 * 
 * @author sg
 *
 */
public class Demo01TestFile {
     public static void main(String[] args) throws IOException {
		File f=new File("D:/g/hello/heelo.txt");
		System.out.println(f.exists());
		f.mkdirs();
		System.out.println(f.exists());
		//�����ļ��Ĵ���
		boolean createNewFile = f.createNewFile();	
		System.out.println(createNewFile);
		
     }
}
