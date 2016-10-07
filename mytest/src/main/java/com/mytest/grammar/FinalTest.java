package com.mytest.grammar;

import java.util.HashMap;
import java.util.Map;

public class FinalTest {
	
	 public final String str ="1";
	  final HashMap<Integer, Integer> hm= new HashMap<Integer,Integer>();
	  FinalTest(){
		  hm.put(1, 1);
		  hm.put(2, 1);
		  hm.put(3, 1);
	  }
	public static void main(String[] args) {
		FinalTest f = new FinalTest() ;
		f.hm.put(2,1);
		f.hm.put(5, 1);
		
	}
}
