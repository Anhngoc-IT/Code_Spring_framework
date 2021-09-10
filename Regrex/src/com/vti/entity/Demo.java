package com.vti.entity;

import java.util.regex.Pattern;

public class Demo {

	public static void main(String[] args) {
		
		// kiểm tra mô hình regrex , 
		//để kiểm tra 1 chuỗi có định dạng là  ...@gmail.com || ...@vti.com.vn
		// (\w+|\d+)@\w.+

		
		String inString = "3";
		Pattern pattern = Pattern.compile("\\d");
		boolean result = pattern.matcher(inString).matches();
		
		System.out.println(result);
	}
	
	
}
