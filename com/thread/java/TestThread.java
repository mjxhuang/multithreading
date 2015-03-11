package com.thread.java;
/*
 * 创建一个子线程，完成1-100之间自然数的输出；同样地，主线程执行同样的操作
 * 创建多线程的第一种方式：继承java.lang.Thread
 */
//1.创建一个继承于Thread的子类
class SubThread extends Thread{
	//2.重写Thread类的run()方法，方法内实现此子线程要完成的功能
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
		//3.创建一个子类的对象
		SubThread st1 = new SubThread("线程1");
		SubThread st2 = new SubThread("线程2");
		//4.调用线程的start()：启动此线程：调用相应的run()方法
		//5.一个线程只能够执行一次start()
		st1.start();
		st2.start();
		
		for(int i = 1;i <= 100;i++){
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}
}
