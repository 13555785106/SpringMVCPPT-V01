package com.sample;

import java.util.Calendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Sample01 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		/*
		 * 创建Spring应用程序上下文(环境)，这里使用的是ClassPathXmlApplicationContext,
		 * 它加载的配置文件必须放在classpath路径中。
		 */
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Calendar cal = ac.getBean(Calendar.class);// 此种方式要求配置文件中只能有一个Calendar的实例
		System.out.println(cal);
		User user01 = (User) ac.getBean("user01");
		System.out.println(user01);
		User user02 = ac.getBean("user02", User.class);
		System.out.println(user02);
	}

}
