package com.app12306;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");//注意，此行代码在GET方式下无作用！尽在POST方式下起作用。
		//URL都是以ASCII方式传递的，所以要自己转！
		System.out.println("doGet");
	
		StringBuilder sb = new StringBuilder();
		Enumeration<String> paraNames = request.getParameterNames();
		while(paraNames.hasMoreElements()) {
			String paraName = paraNames.nextElement();
			String paraValue = new String(request.getParameter(paraName).getBytes("ISO8859-1"),"UTF-8");
			sb.append(paraName + "=" + paraValue+"\r\n");
		}
		System.out.println(sb);
		response.getWriter().append(sb);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("doPost");
		System.out.println(request.getContentType());
		StringBuilder sb = new StringBuilder();
		Enumeration<String> paraNames = request.getParameterNames();
		while(paraNames.hasMoreElements()) {
			String paraName = paraNames.nextElement();
			String paraValue = request.getParameter(paraName);
			sb.append(paraName + "=" + paraValue+"\r\n");
		}
		System.out.println(sb);
		response.getWriter().append(sb);
	}
}
