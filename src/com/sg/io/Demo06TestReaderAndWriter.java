package com.sg.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Demo06TestReaderAndWriter {
	public static void main(String[] args) throws IOException {
		// TestReaderAndWrite();
		TestReaderAndWrite02();

	}

	private static void TestReaderAndWrite02() throws IOException {
		File f = new File("hook.txt");
		FileWriter fw = new FileWriter(f);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 100; i++) {
			double random = Math.random();
			Double r = random;
			String string = r.toString();
			sb.append(string);
			sb.append("\r\n");
		}
		System.out.println(sb.toString());
		fw.write(sb.toString());
		fw.close();

	}

	public static void TestReaderAndWrite() {

		File f = new File("hello2.txt");
		FileReader fr;
		try {
			fr = new FileReader(f);
			char[] b = new char[1024];
			int len;
			while ((len = fr.read(b)) != -1) {
				String str = new String(b, 0, len);
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
