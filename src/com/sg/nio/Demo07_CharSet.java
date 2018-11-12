package com.sg.nio;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class Demo07_CharSet {
   //查看所有的支持的字符集
	public static void main(String[] args) {
		 Map<String, Charset> charsets = Charset.availableCharsets();
		 Set<Entry<String, Charset>> entrySet = charsets.entrySet();
	    for (Entry<String, Charset> entry : entrySet) {
			System.out.println(entry.getKey()+"----->"+entry.getValue());
		}
	}
 
}
