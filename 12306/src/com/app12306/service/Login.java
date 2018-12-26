package com.app12306.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import org.json.JSONObject;

import com.app12306.db.dac.UserDac;
import com.app12306.db.model.User;
import com.easyweb.core.EasyHttpServlet;
import com.easyweb.core.HttpReqResp;
@WebServlet(name="com.app12306.service.Login",urlPatterns="/service/Login")
public class Login extends EasyHttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpReqResp hrr) throws ServletException, IOException {
		doPost(hrr);
	}

	@Override
	public void doPost(HttpReqResp hrr) throws ServletException, IOException {
		JSONObject jsonObject = new JSONObject();
		User user = hrr.convertAndValidate(User.class);
		if (user != null && !hrr.hasErrors()) {
			user = UserDac.getInstance().login(user.getAccount(), user.getPasswd());
			if (user != null) {
				hrr.getRequest().getSession().setAttribute("curUser", user);
				jsonObject.put("status", "success");
			} else {
				hrr.addExeError("登录失败");
			}
		}
		
		if (hrr.hasErrors()) {
			jsonObject.put("status", "failure");
			jsonObject.put("exeErrors", hrr.getExeErrors());
			jsonObject.put("paramErrors", hrr.getParamErrors());
		}
		hrr.getResponse().getWriter().append(jsonObject.toString());
	}
}
