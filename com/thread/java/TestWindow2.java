package com.thread.java;

//ʹ��ʵ��Runnable�ӿڵķ�ʽ����Ʊ
/*
 * ���̴߳����̰߳�ȫ���⣺��ӡ��Ʊʱ���������Ʊ����Ʊ
 * 1.�̰߳�ȫ������ڵ�ԭ��
 * 		����һ���߳��ٲ����������ݹ����У�δִ����ϵ�����£�������̲߳�����������¹������ݴ����˰�ȫ���⡣
 * 2.��ν���̰߳�ȫ���⣿
 * 		������һ���̲߳���������������Ժ������̲߳��л�����빲�����ݵĲ١���
 * 3.Java���ʵ���̵߳İ�ȫ���̵߳�ͬ������
 * 		��ʽһ��ͬ�������
 * 		synchronized(ͬ��������){
 * 			//��Ҫ��ͬ���Ĵ���飨��Ϊ�����������ݵĴ��룩
 * 		}
 * 		1.�������ݣ�����̹߳�ͬ������ͬһ�����ݣ�������
 * 		2.ͬ������������һ����Ķ������䵱���ĸ��̻߳�ȡ�˼�������˭��ִ�д��������汻ͬ���Ĵ��롣�׳ƣ���
 * 		Ҫ�����е��̱߳��빲��ͬһ������
 * 		ע����ʵ�ֵķ�ʽ�У�����ͬ���Ļ� ����ʹ��this ���䵱��
 * 			�����ڼ̳еķ�ʽ������this
 * 		��ʽ����ͬ������
 * 		�������������ݵķ�������Ϊsynchronized ���˷���Ϊͬ������ �ܹ���֤������һ���߳�ִ�д˷���ʱ �����߳�����ȴ�ֱ�����߳�ִ����˷���
 * 			ͬ������������this
 * 4.�߳�ͬ���ı׶ˣ�����ͬһ��ʱ��ֻ����һ���̷߳������ݣ�Ч�ʾͱ����
 */

class Window2 implements Runnable{
    int ticket = 100;//��������
    //Object obj = new Object();
    
	public void run() {
		while(true){
			synchronized (this) {//this��ʾ��ǰ���󣬱�����Ϊw
				if (ticket > 0) {
					try {
						Thread.currentThread().sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "��Ʊ��Ʊ��Ϊ"+ ticket-- );
				}
			}
		}
	}
	
}
public class TestWindow2 {
	public static void main(String[] args) {
		Window2 w = new Window2();
		Thread t1 = new Thread(w);
		Thread t2 = new Thread(w);
		Thread t3 = new Thread(w);
		
		t1.setName("����1");
		t2.setName("����2");
		t3.setName("����3");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
