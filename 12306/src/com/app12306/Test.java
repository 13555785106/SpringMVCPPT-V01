package com.app12306;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getSession().getId());
		System.out.println("【"+request.getMethod()+"】");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		StringBuilder sb = new StringBuilder();
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			String headerValue = request.getHeader(headerName);
			sb.append(headerName + "=" + headerValue + "\r\n");
		}
		System.out.println("头部:");
		System.out.println(sb);
		sb = new StringBuilder();
		Enumeration<String> paraNames = request.getParameterNames();
		while (paraNames.hasMoreElements()) {
			String paraName = paraNames.nextElement();
			String paraValue = request.getParameter(paraName);
			sb.append(paraName + "=" + paraValue + "\r\n");
		}
		System.out.println("参数:");
		System.out.println(sb);
		response.getWriter().append(sb);
	}

}
