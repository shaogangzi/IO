package com.sg.io;

import java.io.File;

/**
 * �����ļ�Ŀ¼�µ����ҵ��ļ�
 * @author sg
 *
 */
public class Demo02TestFile {
	static int x=0;
	public static void main(String[] args) {
		File f = new File("D:/�ز�");
		System.out.println(getFiles(f));
	}

	public static int getFiles( File f){
		 File[] listFiles = f.listFiles();
         for (File file : listFiles) {
			 if(file.isDirectory()){
				 getFiles(file);
			 }
			 else{
				 x++;
				 System.out.println(file.getName());
			 }
		}
         return x;
	}
}
