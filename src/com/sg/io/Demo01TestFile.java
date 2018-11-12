package com.sg.io;

import java.io.File;
import java.io.IOException;
/***
 * java.io.File 表示一个文件或者目录
 * File仅能涉及到文件的修改删除等，无法涉及到文件内容
 * 文件的内容需要用到I/O流
 * mkdir 创建文件目录的时候，文件目录的上一层目录应该存在
 * mkdirs 创建文件目录的时候，文件目录的上一层目录如果不存在，则一起创建了
 * createNewFile 创建文件
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
		//对于文件的创建
		boolean createNewFile = f.createNewFile();	
		System.out.println(createNewFile);
		
     }
}
