package com.sample;

import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONTest {

	public static void main(String[] args) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "龙哥");
		jsonObject.put("age", 32);
		JSONArray jsonHobbies = new JSONArray();
		jsonHobbies.put("篮球");
		jsonHobbies.put("足球");
		jsonObject.put("hobbies", jsonHobbies);
		String str = jsonObject.toString();
		System.out.println(str);
		

	}

}
