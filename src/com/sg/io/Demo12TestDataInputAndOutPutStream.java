package com.sg.io;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 数据流 对基本数据的操作
 * 
 * @author sg
 *
 */
public class Demo12TestDataInputAndOutPutStream {
	public static void main(String[] args) {
		testDataOutputStream();
		testDataInputStream();
	}

	private static void testDataInputStream() {
		File f=new File("data.txt");
		DataInputStream dis=null;
		try {
			FileInputStream fis=new FileInputStream(f);
			dis=new DataInputStream(fis);
			int readInt = dis.readInt();
			short readShort = dis.readShort();
			double readDouble = dis.readDouble();
			String readUTF = dis.readUTF();
			System.out.println(readInt+" "+" "+readShort+" "+readDouble+" "+readUTF);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(dis!=null){
				try {
					dis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}

	private static void testDataOutputStream() {
		File f=new File("data.txt");
		DataOutputStream dos=null;
		try {
			FileOutputStream fos=new FileOutputStream(f);
			dos=new DataOutputStream(fos);
			dos.writeInt(1);
			dos.writeShort(25);
			dos.writeDouble(12.75);
			dos.writeUTF("this is a good day");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(dos!=null){
				try {
					dos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
