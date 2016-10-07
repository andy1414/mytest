package com.mytest.pattern;

import java.io.Serializable;

/**
 * 线程安全的懒汉式单例3,静态内部类，既实现了线程安全，又避免了同步带来的性能影响。
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
