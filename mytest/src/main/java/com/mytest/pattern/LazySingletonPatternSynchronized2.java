package com.mytest.pattern;
/**
 * 线程安全的懒汉式单例2,双重检查锁定
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
