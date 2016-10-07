package com.mytest.pattern;

import java.io.Serializable;

/**
 *懒汉式单例 非线程安全 
 */
public class LazySingletonPattern implements Serializable{
	
	private LazySingletonPattern(){
		
	}
	
	public static LazySingletonPattern INSTANCE =null;
	
	public static LazySingletonPattern getInstance(){
		if(INSTANCE == null){
			INSTANCE  = new LazySingletonPattern();
		}
		return INSTANCE;
	}
	//防止序列化破坏单例模式
	private Object readResolve() {
        return INSTANCE;
    }

}
