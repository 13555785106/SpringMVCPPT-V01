<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:url var="baseUrl" value="/" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="styleSheet" href="${baseUrl}css/main.css" />
<title>登录</title>
</head>
<body>
	<div id="global">
		<form:form commandName="login" action="${baseUrl}login" method="post">
			<fieldset>
				<legend>登录</legend>
				<p>
					<label for="userName">用户名: </label>
					<form:input id="userName" path="userName" cssErrorClass="error" />
				</p>
				<p>
					<label for="password">口令: </label>
					<form:password id="password" path="password" showPassword="true" cssErrorClass="error" />
				</p>
				<p id="buttons">
					<input id="reset" type="reset" tabindex="4" value="重置"> <input
						id="submit" type="submit" tabindex="5" value="登录">
				</p>
			</fieldset>
		</form:form>
	</div>
</body>
</html>