package com.mytest.collection;

public class StringReverse {
	public static String reverse(String originStr) {  
        if(originStr == null || originStr.length() <= 1)   
            return originStr;  
        return reverse(originStr.substring(1)) + originStr.charAt(0);  
    }  
	public static void main(String[] args) {
		String str = "abcdefg";
		System.out.println(reverse(str));

	}

}
