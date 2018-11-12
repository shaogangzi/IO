package com.sg.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Demo08TestBufferReadAndWriterStream {
	public static void main(String[] args) {
		test01();
		test02();
	}

	private static void test02() {
		File src = new File("hook.txt");
		File des = new File("buffRW.txt");
		BufferedWriter bw = null;
		BufferedReader br = null;
		try {
			FileReader fr = new FileReader(src);
			FileWriter fw = new FileWriter(des);

			//包装流(处理流）
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);

			//
			String str;
			while ((str = br.readLine()) != null) {
				bw.write(str);
				bw.newLine();
			}
			bw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static void test01() {

	}
}
