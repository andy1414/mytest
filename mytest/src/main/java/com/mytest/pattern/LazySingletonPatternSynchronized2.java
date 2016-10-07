package com.mytest.pattern;
/**
 * �̰߳�ȫ������ʽ����2,˫�ؼ������
 * */
public class LazySingletonPatternSynchronized2 {
	private LazySingletonPatternSynchronized2(){
		
	}
	
	public static LazySingletonPatternSynchronized2 INSTANCE = null;
	
	public static synchronized LazySingletonPatternSynchronized2 getInstance(){
		if(INSTANCE == null){
			synchronized (LazySingletonPatternSynchronized2.class) {
				if(INSTANCE == null){
					INSTANCE = new LazySingletonPatternSynchronized2();
				}
			}
		}
		return INSTANCE;
	}
}
