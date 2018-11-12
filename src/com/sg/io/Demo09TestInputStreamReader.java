package com.sg.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * ×ª»»Á÷
 * @author sg
 *
 */
public class Demo09TestInputStreamReader {
    public static void main(String[] args) {
		File f=new File("hello2.txt");
		FileInputStream fis=null;
		BufferedReader bis=null;
		try {
			 fis=new FileInputStream(f);
			 InputStreamReader isr=new InputStreamReader(fis);
			 bis=new BufferedReader(isr);
			char[] b=new char[1024];
			int len;
			while((len=bis.read(b))!=-1){
				String str=new String(b,0,len);
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				bis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
