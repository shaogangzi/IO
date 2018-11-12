package com.sg.nio;

import java.nio.ByteBuffer;

/**
 * 
 * @author sg
 * 四个Buffer的重要属性
 * 直接缓冲区域非直接缓冲的区别
 * Buffer一个用于保存特定基本数据类型的容器，
 */

public class Demo02_TestBuffer {
	public static void main(String[] args) {

		testBuffer();
		testBuffer2();
		//测试直接缓冲区，直接建立在物理内存上的
		testBuffer3();

	}
	
	
    private static void testBuffer3() {
		ByteBuffer allocateDirect = ByteBuffer.allocateDirect(1024);
		//判断是不是建立在之间缓存区上
		//即是不是直接在物理内存上的，而不是在JVM上的
		System.out.println(allocateDirect.isDirect());
	}


	/**
     * 对Mark的分析
     * mark是标记，对于position进行标记能够记录下当前的位置
     * 只是通过调用reset能够恢复到之前的位置
     */
	private static void testBuffer2() {
		String str="this is a good day";
		ByteBuffer buff2=ByteBuffer.allocate(1024);
		buff2.put(str.getBytes());
		System.out.println(buff2.position()); //标记第18个元素
		buff2.mark();
		buff2.put("yes".getBytes());
		System.out.println(buff2.position()); //指向第21个元素
		buff2.reset();  //重置为之前的位置
		System.out.println(buff2.position()); //又重新指向第18个元素位置	
	}

	/**
	 * 对buffer接口的关键字： 
	 * position 相当于一个指针，指向当前正在操作的下标
	 * limit    在写的时候，limit为数组的大小，在进行读的时候，limit为实际存放的大小
	 * capacity 缓冲区数组的容量
	 * 
	 */
	private static void testBuffer() {
		
		String str = "test";
		//使用字节缓冲区，设置其大小为10
		ByteBuffer buf = ByteBuffer.allocate(10);
	    //把数据存放到缓冲区中
		buf.put(str.getBytes());
		
		System.out.println(buf.position());
		System.out.println(buf.limit());
		System.out.println(buf.capacity());

		/**
		 * 有存放数据的状态变为读的状态
		 */
		System.out.println("--------filp--------");
		buf.flip();
		System.out.println(buf.position());
		System.out.println(buf.limit());
		System.out.println(buf.capacity());

		/**
		 * 获取缓冲区的数据
		 */
		System.out.println("--------get--------");
		byte[] dst = new byte[buf.limit()];
		buf.get(dst);
		System.out.println(new String(dst, 0, dst.length));

		/**
		 * 清空数据，这里只是使数据处于被遗忘的状态 而不是真正的把数据进行清空
		 */
		buf.clear();
		System.out.println(buf.position());
		System.out.println(buf.limit());
		System.out.println(buf.capacity());
	}
}
