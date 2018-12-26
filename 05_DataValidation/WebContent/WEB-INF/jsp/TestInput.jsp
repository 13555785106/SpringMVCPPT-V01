<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:url var="baseUrl" value="/" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="styleSheet" href="${baseUrl}css/main.css" />
<title>TestInput</title>
</head>
<body>
		<form action="test_input" method="post">			
			<table align="center">
				<tr>
					<td>账号:</td>
					<td><input name="account" value="${user.account}"/></td>
				</tr>
				<tr>
					<td>密码:</td>
					<td><input name="passwd" value="${user.passwd}"/></td>
				</tr>

				<tr>
					<td>工资:</td>
					<td><input name="salary" value="${user.salary}"/></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="提交"/></td>
				</tr>
			</table>

		</form>
	<table>
		<c:forEach items="${requestScope}" var="v">
			<tr>
				<td>${v.key}</td>
				<td>${v.value}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>