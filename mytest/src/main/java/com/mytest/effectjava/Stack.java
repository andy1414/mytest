package com.mytest.effectjava;

import java.util.EmptyStackException;

public class Stack<E> {
	private E[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	@SuppressWarnings("unchecked")
	public Stack(){
		elements = (E[])new Object[DEFAULT_INITIAL_CAPACITY];
	}
	
	public void push(E e){
		ensureCapacity();
		elements[size++] =e;
	}
	
	public E pop(){
		if(size == 0)
			throw new EmptyStackException();
		E result = (E)elements[--size];
		elements[size]=null;
		return result;
	}
	
	

	private void ensureCapacity() {
		// TODO Auto-generated method stub
		
	}
	
	
}
