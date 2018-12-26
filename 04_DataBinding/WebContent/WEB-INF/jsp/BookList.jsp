<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:url var="baseUrl" value="/" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="styleSheet" href="${baseUrl}css/main.css" />
<title>图书列表</title>
</head>
<body>
<div id="global">
<h1>图书列表</h1>
<a href="${baseUrl}/book_input">添加图书</a>
<table>
<tr>
    <th>种类</th>
    <th>标题</th>
    <th>ISBN</th>
    <th>作者</th>
    <th>&nbsp;</th>
</tr>
<c:forEach items="${books}" var="book">
    <tr>
        <td>${book.category.name}</td>
        <td>${book.title}</td>
        <td>${book.isbn}</td>
        <td>${book.author}</td>
        <td><a href="book_edit/${book.id}">Edit</a></td>
    </tr>
</c:forEach>
</table>
</div>
</body>
</html>