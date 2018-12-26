package com.sample;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class BeanInfoSample {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// 查看bean的属性信息
		BeanInfo userBeanInfo = null;
		try {
			userBeanInfo = Introspector.getBeanInfo(User.class);
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}

		if (userBeanInfo != null) {
			for (PropertyDescriptor pd : userBeanInfo.getPropertyDescriptors()) {
				String propName = pd.getName();
				Class<?> propType = pd.getPropertyType();
				System.out.println(propName + "=" + propType);
			}
		}
		User user = new User();
		user.setAccount("aaaaa");
		user.setSalary(8000.0);
		System.out.println(func01(user));
	}
	
	public static Map<String,Object> func01(Object obj){
		Map<String,Object> map = new HashMap<String,Object>();
		BeanInfo beanInfo = null;
		try {
			beanInfo = Introspector.getBeanInfo(obj.getClass());
			for (PropertyDescriptor pd : beanInfo.getPropertyDescriptors()) {
				String propName = pd.getName();
				Object propValue;
				propValue = pd.getReadMethod().invoke(obj);
				map.put(propName, propValue);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
