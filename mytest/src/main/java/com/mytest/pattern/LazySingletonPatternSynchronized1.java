package com.mytest.pattern;
/**
 * 线程安全的懒汉式单例1
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
