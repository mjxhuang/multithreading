package com.thread.java1;
//线程通信：如下三个关键字使用的话 都得在同步代码块或同步方法中
//wait():一旦一个线程执行到wait() 就释放当前的锁
//notify() notifyAll()：唤醒wait的一个或所有线程
//使用两个线程打印1-100 线程1，线程2 交替打印
class PrintNum implements Runnable {
	int num = 1;

	public void run() {
		while (true) {
			synchronized (this) {
				//唤醒
				notify();
				if (num <= 100) {
					System.out.println(Thread.currentThread().getName() + ":"
							+ num++);
				} else {
					break;
				}
				//释放
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
		
		t1.setName("甲");
		t2.setName("乙");
		
		t1.start();
		t2.start();
	}
}
