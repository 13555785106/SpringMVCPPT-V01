<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:url var="baseUrl" value="/" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="styleSheet" href="${baseUrl}css/main.css" />
<title>Sample03</title>
</head>
<body>
	<div id="global">
		<h4>日期数据类型</h4>

		<form action="Sample03.action" method="POST">
			<table>
			<tr><td>年龄</td><td><input name="birthday" value="2018-10-10 18:18:18"></td></tr>
			<tr><td colspan="2"><input type="submit" value="确定"></td></tr>
			</table>
		</form>
	</div>
</body>
</html>