package com.mytest.jvmtest;

public class TestPretenureSizeThreshold {
	private static final int _1MB = 1024*1024;
	
	public static void testPretenureSizeThreshold(){
		@SuppressWarnings("unused")  
		byte[] allocation;
		allocation = new byte[6 * _1MB];
	}
	
	public static void main(String args[]){
		TestPretenureSizeThreshold t = new TestPretenureSizeThreshold();
		t.testPretenureSizeThreshold();
	}
}
	