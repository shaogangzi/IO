package com.sg.nio;

import java.nio.ByteBuffer;

/**
 * 
 * @author sg
 * �ĸ�Buffer����Ҫ����
 * ֱ�ӻ��������ֱ�ӻ��������
 * Bufferһ�����ڱ����ض������������͵�������
 */

public class Demo02_TestBuffer {
	public static void main(String[] args) {

		testBuffer();
		testBuffer2();
		//����ֱ�ӻ�������ֱ�ӽ����������ڴ��ϵ�
		testBuffer3();

	}
	
	
    private static void testBuffer3() {
		ByteBuffer allocateDirect = ByteBuffer.allocateDirect(1024);
		//�ж��ǲ��ǽ�����֮�仺������
		//���ǲ���ֱ���������ڴ��ϵģ���������JVM�ϵ�
		System.out.println(allocateDirect.isDirect());
	}


	/**
     * ��Mark�ķ���
     * mark�Ǳ�ǣ�����position���б���ܹ���¼�µ�ǰ��λ��
     * ֻ��ͨ������reset�ܹ��ָ���֮ǰ��λ��
     */
	private static void testBuffer2() {
		String str="this is a good day";
		ByteBuffer buff2=ByteBuffer.allocate(1024);
		buff2.put(str.getBytes());
		System.out.println(buff2.position()); //��ǵ�18��Ԫ��
		buff2.mark();
		buff2.put("yes".getBytes());
		System.out.println(buff2.position()); //ָ���21��Ԫ��
		buff2.reset();  //����Ϊ֮ǰ��λ��
		System.out.println(buff2.position()); //������ָ���18��Ԫ��λ��	
	}

	/**
	 * ��buffer�ӿڵĹؼ��֣� 
	 * position �൱��һ��ָ�룬ָ��ǰ���ڲ������±�
	 * limit    ��д��ʱ��limitΪ����Ĵ�С���ڽ��ж���ʱ��limitΪʵ�ʴ�ŵĴ�С
	 * capacity ���������������
	 * 
	 */
	private static void testBuffer() {
		
		String str = "test";
		//ʹ���ֽڻ��������������СΪ10
		ByteBuffer buf = ByteBuffer.allocate(10);
	    //�����ݴ�ŵ���������
		buf.put(str.getBytes());
		
		System.out.println(buf.position());
		System.out.println(buf.limit());
		System.out.println(buf.capacity());

		/**
		 * �д�����ݵ�״̬��Ϊ����״̬
		 */
		System.out.println("--------filp--------");
		buf.flip();
		System.out.println(buf.position());
		System.out.println(buf.limit());
		System.out.println(buf.capacity());

		/**
		 * ��ȡ������������
		 */
		System.out.println("--------get--------");
		byte[] dst = new byte[buf.limit()];
		buf.get(dst);
		System.out.println(new String(dst, 0, dst.length));

		/**
		 * ������ݣ�����ֻ��ʹ���ݴ��ڱ�������״̬ �����������İ����ݽ������
		 */
		buf.clear();
		System.out.println(buf.position());
		System.out.println(buf.limit());
		System.out.println(buf.capacity());
	}
}
