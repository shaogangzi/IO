package com.sg.io;

import java.io.File;

/**
 * 遍历文件目录下的左右的文件
 * @author sg
 *
 */
public class Demo02TestFile {
	static int x=0;
	public static void main(String[] args) {
		File f = new File("D:/素材");
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
