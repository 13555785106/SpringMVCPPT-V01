<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
</head>
<body>
	你好，世界！Hello World!
<%
	Enumeration<String> headerNames = request.getHeaderNames();
	while (headerNames.hasMoreElements()) {
		String headerName = headerNames.nextElement();
		System.out.println(headerName);
		Enumeration<String> headerValues = request.getHeaders(headerName);
		System.out.print("\t\t");
		while (headerValues.hasMoreElements()) {
			String value = headerValues.nextElement();
			System.out.print(value + " ");
		}
		System.out.println();
	}
%>
</body>
</html>