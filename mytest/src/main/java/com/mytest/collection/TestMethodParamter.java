package com.mytest.collection;

public class TestMethodParamter {
	public void changeri(int j){
		j = 2;
	}
	
	public void changerPerson(Person p){
		p.jj = 2;
	}
	public static void main(String[] args) {
		int i = 11;
		Integer x = 11;
		TestMethodParamter ts = new TestMethodParamter();
		ts.changeri(i);
		ts.changeri(x);
		System.out.println(x);
		Person p = new Person();
		ts.changerPerson(p);
		System.out.println(p.jj);
	}

}

class Person{
	public int jj = 1;
}