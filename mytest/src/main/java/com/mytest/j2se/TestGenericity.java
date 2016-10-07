package com.mytest.j2se;

public class TestGenericity<E> {
	public E[] element;
	public TestGenericity(){
		element = (E[]) new Object[10];
	}
	
}

