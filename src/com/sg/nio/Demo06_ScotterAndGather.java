package com.sg.nio;


import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/***
 * Scatter 分散读取 将通道中的数据分散到缓冲区中，依次的写入
 * Gather 聚集读取 将缓冲区中的内容依次的写入到通道中
 * @author sg
 *
 */
public class Demo06_ScotterAndGather {
      public static void main(String[] args) throws IOException {
		RandomAccessFile raf1=new RandomAccessFile("hello2.txt", "rw");
		//获取通道
		FileChannel channel1 = raf1.getChannel();
		//设置缓冲区
		ByteBuffer buf1=ByteBuffer.allocate(50);
		ByteBuffer buf2=ByteBuffer.allocate(1024);
		//分散读取的时候缓存区应该事有序的，所以把几个缓冲区加入数组中
		ByteBuffer[] bufs={buf1,buf2};
		//通道进行传输
		channel1.read(bufs);
		
		//查看缓冲区中的内容
		for (int i = 0; i < bufs.length; i++) {
			//切换为读模式
			bufs[i].flip();
		}
		
		System.out.println(new String(bufs[0].array(),0,bufs[0].limit()));
		System.out.println();
		System.out.println(new String(bufs[1].array(),0,bufs[1].limit()));
	
        //聚集写入
		RandomAccessFile  raf2=new RandomAccessFile("ScoAndGat.txt", "rw");
		FileChannel channel2 = raf2.getChannel();
		//只能通过通道来进行写入
		channel2.write(bufs);
      }
}
