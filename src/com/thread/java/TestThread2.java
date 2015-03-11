package com.thread.java;
/*
 * �������̵߳ķ�ʽ����ͨ��ʵ�ֵķ�ʽ
 * 
 * �Ա�һ�¼̳еķ�ʽ VS ʵ�ֵķ�ʽ
 * 1.��ϵ�� public class Thread implements Runnable
 * 2.�ĸ���ʽ�ã�ʵ�ֵķ�ʽ���ڼ̳еķ�ʽ
 * 		why? �� ������Java���̳еľ�����
 * 			 �� �������߳�Ҫ����ͬһ����Դ�������ݣ����ʺ�ʹ��ʵ�ֵķ�ʽ
 */
//1.����һ��ʵ����Runnable�ӿڵ���
class PrintNum1 implements Runnable{
	//2.ʵ�ֽӿڵĳ��󷽷�
	public void run(){
		//���߳�ִ�еĴ���
		for(int i = 1;i <= 100;i++){
			if(i % 2 == 0){
				System.out.println(Thread.currentThread().getName() + ":" + i);
			}
		}
	}
}

public class TestThread2 {
	public static void main(String[] args) {
		//3.����һ��Runnable�ӿ�ʵ����Ķ���
		PrintNum1 p = new PrintNum1();
		//Ҫ������һ�����߳� �������start()
		//4.���˶�����Ϊ�βδ��ݸ�Thread��Ĺ������У�����Thread��Ķ��󣬴˶������һ���߳�
		Thread t1 = new Thread(p);
		//5.����start()�����������̲߳�ִ��run()
		t1.start();//�����̣߳�ִ��Thread��������ʱ�������βζ����run()����
		
		//�ٴ���һ���߳�
		Thread t2 = new Thread(p);
		t2.start();
	}
}
