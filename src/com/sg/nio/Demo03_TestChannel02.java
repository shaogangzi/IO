package com.sg.nio;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
/**
 * 直接写在内存上
 * @author sg
 *
 */
public class Demo03_TestChannel02 {
	public static void main(String[] args) throws IOException  {
		  //两种方式实现
		  test01();
		  test02();  
	}

	
	/**
	 * 通道间的数据传输
	 * @throws IOException
	 */
	private static void test02() throws IOException {
		FileChannel inChannel = FileChannel.open(Paths.get("src"),StandardOpenOption.READ);
	    FileChannel outChannel = FileChannel.open(Paths.get("des"), StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE_NEW);
		//通道间的数据传输
	    inChannel.transferTo(0, inChannel.size(), outChannel);
	    outChannel.close();
	    inChannel.close();
	}

	private static void test01() throws IOException{
		  //打开通道
		  FileChannel inChannel = FileChannel.open(Paths.get("src"),StandardOpenOption.READ);
	      FileChannel outChannel = FileChannel.open(Paths.get("des"), StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE_NEW);
	      //映射到map上
	      MappedByteBuffer inMapBuffer = inChannel.map(MapMode.READ_ONLY, 0, inChannel.size());
	      MappedByteBuffer outMapBuffer = outChannel.map(MapMode.READ_WRITE, 0, inChannel.size());
	     
	      byte[] b=new byte[inMapBuffer.limit()];
	      inMapBuffer.get(b);
	      outMapBuffer.put(b);
	      outChannel.close();
	      inChannel.close();	
	}
}
