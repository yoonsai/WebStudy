package com.sist.main;

import java.util.Arrays;
import java.io.UnsupportedEncodingException;
import java.net.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name="홍길동";
		//System.out.println(Arrays.toString(name.getBytes()));
		try {
			System.out.println(URLEncoder.encode(name,"UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
