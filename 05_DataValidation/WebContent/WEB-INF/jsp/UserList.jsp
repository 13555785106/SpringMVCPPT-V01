<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:url var="baseUrl" value="/" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="styleSheet" href="${baseUrl}css/main.css" />
<title>用户列表</title>
</head>
<body>
	<form method="POST">
		<input type="hidden" name="pageNo" value="${paging.pageNo}" /> <input
			type="hidden" name="pageSize" value="${paging.pageSize}" />
		<table align="center">
			<tr>
				<td align="center">账号:<input type="text" name="account"
					value="${account}" /><input type="submit" value="搜索" name="find" /></td>
			</tr>
		</table>
		<table align="center">
			<caption>用户列表</caption>
			<tr>
				<th>账号</th>
				<th>密码</th>
				<th>确认密码</th>
				<th>性别</th>
				<th>生日</th>
				<th>工资</th>
				<th>爱好</th>
				<th><a href="${baseUrl}user_input/0">添加</a></th>
			</tr>
			<c:forEach items="${paging.datas}" var="user">
				<tr>
					<td>${user.account}</td>
					<td>${user.passwd}</td>
					<td>${user.confirmPasswd}</td>
					<td>${user.sex}</td>
					<td>${user.birthday}</td>
					<td>${user.salary}</td>
					<td>${user.hobbies}</td>
					<td><a href="${baseUrl}user_input/${user.id}">编辑</a></td>
				</tr>
			</c:forEach>
		</table>
		<table align="center">
			<tr>
				<c:if test="${paging.pageCount>1 && paging.pageNo>0}">
					<td><input type="submit" value="首页" name="firstPage" /></td>
				</c:if>
				<c:if test="${paging.pageNo>0 && paging.pageNo<=paging.pageCount-1}">
					<td><input type="submit" value="前页" name="previousPage" /></td>
				</c:if>
				<td><c:if test="${paging.pageCount>0 }">第${paging.pageNo+1}页 /</c:if>
					共${paging.pageCount}页</td>
				<c:if test="${paging.pageNo>=0 && paging.pageNo<paging.pageCount-1}">
					<td><input type="submit" value="后页" name="nextPage" /></td>
				</c:if>
				<c:if
					test="${paging.pageCount>1 && paging.pageNo<paging.pageCount-1}">
					<td><input type="submit" value="尾页" name="lastPage" /></td>
				</c:if>
			</tr>
		</table>
	</form>
	<br/><br/><br/><br/><br/>
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