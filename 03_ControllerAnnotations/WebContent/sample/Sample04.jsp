<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:url var="baseUrl" value="/" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="styleSheet" href="${baseUrl}css/main.css" />
<title>Sample04</title>
</head>
<body>
	<div id="global">
		<h4>@ModelAttribute</h4>

		<form action="Sample04.action" method="POST">
			<table>
				<tr>
					<td>ID</td>
					<td><input name="id" value="100"></td>
				</tr>
				<tr>
					<td>名称</td>
					<td><input name="name" value="可口可乐"></td>
				</tr>
				<tr>
					<td>详细信息</td>
					<td><input name="description" value="非常好喝的饮料！"></td>
				</tr>
				<tr>
					<td>价格</td>
					<td><input name="price" value="3"></td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="确定"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>