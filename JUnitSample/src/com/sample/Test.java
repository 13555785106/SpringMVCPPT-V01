package com.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		String[] strs = new String[] {"aaa","bbb","aaa","ccc","aaa"};
		List<String> strList = new ArrayList<String>(Arrays.asList(strs));
		for(int i=0;i<strList.size();i++) {
			String str = strList.get(i);
			if(str.equals("aaa")) {
				strList.remove(i);
				i--;
			}
		}
		
		System.out.println(strList);
	}

}
