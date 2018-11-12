package com.sg.nio;


import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/***
 * Scatter ��ɢ��ȡ ��ͨ���е����ݷ�ɢ���������У����ε�д��
 * Gather �ۼ���ȡ ���������е��������ε�д�뵽ͨ����
 * @author sg
 *
 */
public class Demo06_ScotterAndGather {
      public static void main(String[] args) throws IOException {
		RandomAccessFile raf1=new RandomAccessFile("hello2.txt", "rw");
		//��ȡͨ��
		FileChannel channel1 = raf1.getChannel();
		//���û�����
		ByteBuffer buf1=ByteBuffer.allocate(50);
		ByteBuffer buf2=ByteBuffer.allocate(1024);
		//��ɢ��ȡ��ʱ�򻺴���Ӧ��������ģ����԰Ѽ�������������������
		ByteBuffer[] bufs={buf1,buf2};
		//ͨ�����д���
		channel1.read(bufs);
		
		//�鿴�������е�����
		for (int i = 0; i < bufs.length; i++) {
			//�л�Ϊ��ģʽ
			bufs[i].flip();
		}
		
		System.out.println(new String(bufs[0].array(),0,bufs[0].limit()));
		System.out.println();
		System.out.println(new String(bufs[1].array(),0,bufs[1].limit()));
	
        //�ۼ�д��
		RandomAccessFile  raf2=new RandomAccessFile("ScoAndGat.txt", "rw");
		FileChannel channel2 = raf2.getChannel();
		//ֻ��ͨ��ͨ��������д��
		channel2.write(bufs);
      }
}
