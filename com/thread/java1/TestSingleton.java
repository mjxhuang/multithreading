package com.thread.java1;
//��������ʽ���̰߳�ȫ���⣺ʹ��ͬ������
//����һ��ķ����� ʹ��ͬ������� ���Կ���ʹ��this
//���ھ�̬�������� ʹ�õ�ǰ�౾��䵱��
class Singleton{
	private Singleton() {
		
	}
	private static Singleton instance = null;
	
	public static Singleton getInstance() {
		//Ϊ�����Ч�� ��������дһ���ж�
		
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;		
	}
}

public class TestSingleton {

	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
	}
	
}
