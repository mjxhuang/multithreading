package com.thread.java1;
//�߳�ͨ�ţ����������ؼ���ʹ�õĻ� ������ͬ��������ͬ��������
//wait():һ��һ���߳�ִ�е�wait() ���ͷŵ�ǰ����
//notify() notifyAll()������wait��һ���������߳�
//ʹ�������̴߳�ӡ1-100 �߳�1���߳�2 �����ӡ
class PrintNum implements Runnable {
	int num = 1;

	public void run() {
		while (true) {
			synchronized (this) {
				//����
				notify();
				if (num <= 100) {
					System.out.println(Thread.currentThread().getName() + ":"
							+ num++);
				} else {
					break;
				}
				//�ͷ�
				try {
					wait();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
		}
	}
	
}


public class TestCommunication {
	public static void main(String[] args) {
		PrintNum p = new PrintNum();
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(p);
		
		t1.setName("��");
		t2.setName("��");
		
		t1.start();
		t2.start();
	}
}
