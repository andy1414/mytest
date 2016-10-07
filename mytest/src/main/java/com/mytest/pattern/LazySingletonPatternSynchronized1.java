package com.mytest.pattern;
/**
 * �̰߳�ȫ������ʽ����1
 * */
public class LazySingletonPatternSynchronized1 {
	private LazySingletonPatternSynchronized1(){
		
	}
	
	public static LazySingletonPatternSynchronized1 INSTANCE = null;
	
	public static synchronized LazySingletonPatternSynchronized1 getInstance(){
		if(INSTANCE == null){
			INSTANCE = new LazySingletonPatternSynchronized1();
		}
		return INSTANCE;
	}
}
