package com.mytest.pattern;

import java.io.Serializable;

/**
 * �̰߳�ȫ������ʽ����3,��̬�ڲ��࣬��ʵ�����̰߳�ȫ���ֱ�����ͬ������������Ӱ�졣
 * */
public class LazySingletonPatternSynchronized3 {

	private LazySingletonPatternSynchronized3() {

	}

	private static class LazyHolder {
		private static final LazySingletonPatternSynchronized3 INSTANCE = new LazySingletonPatternSynchronized3();
	}

	public static final LazySingletonPatternSynchronized3 getInstance() {
		return LazyHolder.INSTANCE;
	}
	
	
	
}
