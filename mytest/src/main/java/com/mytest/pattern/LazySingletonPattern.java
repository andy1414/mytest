package com.mytest.pattern;

import java.io.Serializable;

/**
 *����ʽ���� ���̰߳�ȫ 
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
	//��ֹ���л��ƻ�����ģʽ
	private Object readResolve() {
        return INSTANCE;
    }

}
