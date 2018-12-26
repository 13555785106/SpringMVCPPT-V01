package com.hr.test.misc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegTest02 {

	public static void main(String[] args) {
		test04();
	}

	public static void test01() {
		Pattern p = Pattern.compile("(\\d+)([￥$])$");//
		String str = "8899￥";
		Matcher m = p.matcher(str);
		if (m.matches()) {
			System.out.println("货币金额: " + m.group(1));
			System.out.println("货币种类: " + m.group(2));
		}
	}

	public static void test02() {
		Pattern p = Pattern.compile("(\\d+)(?:\\.?)(?:\\d+)([￥$])$");//
		String str = "8899.56￥";
		Matcher m = p.matcher(str);
		if (m.matches()) {
			System.out.println("货币金额: " + m.group(1));
			System.out.println("货币种类: " + m.group(2));
		}
	}

	public static void test03() {
		Pattern p = Pattern.compile("(?<money>\\d+)(\\.?)(\\d+)(?<type>[￥$])$");//
		String str = "8899.56￥";
		Matcher m = p.matcher(str);
		if (m.matches()) {
			System.out.println("货币金额: " + m.group("money"));
			System.out.println("货币种类: " + m.group("type"));
		}
	}

	public static void test04() {
		
		String str01 = "abbb";
		String str02 = "avvvvzvzvzvzvzv";
		String str03 = "bbba";
		String str04 = "crta";
		// ?=右侧匹配
		Pattern p01 = Pattern.compile("a(?=bbb)");// a后面紧跟bbb
		Matcher matcher01 = p01.matcher(str01);
		System.out.println(matcher01.find());// 返回true
		// ?!右侧不匹配
		Pattern p02 = Pattern.compile("a(?!bbb)");// a后面不紧跟bbb
		Matcher matcher02 = p02.matcher(str02);
		System.out.println(matcher02.find());// 返回false
		
		Pattern p03 = Pattern.compile("(?<=bbb)a");// a后面紧跟bbb
		Matcher matcher03 = p03.matcher(str03);
		System.out.println(matcher03.find());// 返回true		
		
		Pattern p04 = Pattern.compile("(?<!bbb)a");// a后面紧跟bbb
		Matcher matcher04 = p04.matcher(str04);
		System.out.println(matcher04.find());// 返回true			
	}
}
