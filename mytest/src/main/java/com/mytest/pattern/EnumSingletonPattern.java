package com.mytest.pattern;
//单元素的枚举类型已经成为实现Singleton的最佳方法
//无需再考虑可序列化的情况,无需再考虑通过反射调用私有构造函数的情况,枚举实例创建是线程安全的，无需再考虑Double checked locking
public enum EnumSingletonPattern {
	INSATNCE;
	
}
