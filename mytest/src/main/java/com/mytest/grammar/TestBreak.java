package com.mytest.grammar;

public class TestBreak {
	public static int foo(int i){
		if(i<2)return i;
		return foo(i-1)+foo(i-2);
	}
	public static void main(String[] args) {
		System.out.println(foo(5));
	}

}
