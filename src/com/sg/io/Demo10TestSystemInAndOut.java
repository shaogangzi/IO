package com.sg.io;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/***
 * ��׼����������� System.in System.out
 * 
 * @author sg
 *
 */
public class Demo10TestSystemInAndOut {
	public static void main(String[] args) throws IOException {
		InputStream in = System.in;
		/**
		 * ���ַ����鵽�ַ���
		 */
		InputStreamReader isr=new InputStreamReader(in);
		BufferedReader bis=new BufferedReader(isr);
		while(true){
			String str=bis.readLine();
			if("exit".equalsIgnoreCase(str)){
				System.exit(0);
			}
			String string = str.toUpperCase();
			System.out.println(string);
		}
 	}
}
