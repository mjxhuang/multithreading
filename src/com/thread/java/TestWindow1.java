package com.thread.java;
//模拟火车站售票窗口，开启三个窗口售票，总票数为100张 
//使用实现Runnable接口的方式 售票

class Window1 implements Runnable{
	int ticket = 100;
	public void run() {
		while (true) {
			if(ticket > 0){
				try {
					Thread.currentThread().sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "售票，票号为"+ ticket-- );
			}else {
				break;
			}
		}
	}
}
public class TestWindow1 {
	public static void main(String[] args) {
		Window1 w = new Window1();
		Thread t1 = new Thread(w);
		Thread t2 = new Thread(w);
		Thread t3 = new Thread(w);
		
		t1.setName("窗口1");
		t2.setName("窗口2");
		t3.setName("窗口3");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
