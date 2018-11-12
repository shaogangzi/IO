package com.sg.nio;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class Demo07_CharSet {
   //�鿴���е�֧�ֵ��ַ���
	public static void main(String[] args) {
		 Map<String, Charset> charsets = Charset.availableCharsets();
		 Set<Entry<String, Charset>> entrySet = charsets.entrySet();
	    for (Entry<String, Charset> entry : entrySet) {
			System.out.println(entry.getKey()+"----->"+entry.getValue());
		}
	}
 
}
