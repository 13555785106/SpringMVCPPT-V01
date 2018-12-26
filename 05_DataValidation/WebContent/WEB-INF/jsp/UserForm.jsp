<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:url var="baseUrl" value="/" />
<c:if test="${empty user.id}">
	<c:set var="userAction" value="添加" />
</c:if>
<c:if test="${!empty user.id}">
	<c:set var="userAction" value="修改" />
</c:if>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="styleSheet" href="${baseUrl}css/main.css" />
<title>${userAction}用户</title>
</head>
<body>
	<spring:message code="myname" />
	<div id="global">
		<form:form commandName="user" action="${baseUrl}user_save"
			method="post">
			<form:hidden id="id" path="id" />

			<table align="center">
				<caption>${userAction}用户</caption>
				<tr>
					<td colspan="3" align="center"><form:errors path="" /></td>
				</tr>
				<tr>
					<td>*账号:</td>
					<td><form:input path="account" /></td>
					<td><form:errors path="account" cssClass="error" /></td>
				</tr>
				<tr>
					<td>*密码:</td>
					<td><form:password path="passwd" showPassword="true" /></td>
					<td><form:errors path="passwd" cssClass="error" /></td>
				</tr>
				<tr>
					<td>*确认密码:</td>
					<td><form:password path="confirmPasswd" showPassword="true" /></td>
					<td><form:errors path="confirmPasswd" cssClass="error" /></td>
				</tr>
				<tr>
					<td>性别:</td>
					<td>
						<form:radiobuttons path="sex" items="${fn:split('男,女',',')}" value="" />
						</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>生日:</td>
					<td><form:input path="birthday" /></td>
					<td><form:errors path="birthday" cssClass="error" /></td>
				</tr>
				<tr>
					<td>工资:</td>
					<td><form:input path="salary" /></td>
					<td><form:errors path="salary" cssClass="error" /></td>
				</tr>
				<tr>
					<td>爱好:${hobbies}</td>
					<td><c:forEach var="hobby" items="${fn:split('足球,篮球,排球',',')}">
							<c:set var="hobbyChecked" value="" />
							<c:if test="${fn:contains(user.hobbies,hobby)}">
								<c:set var="hobbyChecked" value="checked" />
							</c:if> 
							${hobby}<form:checkbox path="hobbies" value="${hobby}" checked="${hobbyChecked}" />
						</c:forEach></td>
					<td><form:errors path="hobbies" cssClass="error" /></td>
				</tr>
				<tr>
					<td colspan="3" align="center"><input type="submit"
						value="${userAction}"></td>
				</tr>
			</table>

		</form:form>
	</div>

</body>
</html>