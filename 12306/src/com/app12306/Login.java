package com.app12306;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");

		if (account == null)
			account = "";
		if (passwd == null)
			passwd = "";

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("status", "success");
		jsonObject.put("description", "成功");
		if (!(account.equals("sa") && passwd.equals("123"))) {
			jsonObject.put("status", "failed");
			jsonObject.put("description", "失败");
		}
		response.getWriter().append(jsonObject.toString());
	}
}
