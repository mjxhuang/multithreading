package com.thread.java;
/*
 * ����һ�����̣߳����1-100֮����Ȼ���������ͬ���أ����߳�ִ��ͬ���Ĳ���
 * �������̵߳ĵ�һ�ַ�ʽ���̳�java.lang.Thread
 */
//1.����һ���̳���Thread������
class SubThread extends Thread{
	//2.��дThread���run()������������ʵ�ִ����߳�Ҫ��ɵĹ���
	public void run(){
		for(int i = 1;i <= 100;i++){
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}
	public SubThread(String name) {
		super(name);
	}
}

public class TestThread {
	public static void main(String[] args) {
		//3.����һ������Ķ���
		SubThread st1 = new SubThread("�߳�1");
		SubThread st2 = new SubThread("�߳�2");
		//4.�����̵߳�start()���������̣߳�������Ӧ��run()����
		//5.һ���߳�ֻ�ܹ�ִ��һ��start()
		st1.start();
		st2.start();
		
		for(int i = 1;i <= 100;i++){
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}
}
