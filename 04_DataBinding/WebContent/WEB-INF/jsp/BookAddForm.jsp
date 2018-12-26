<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:url var="baseUrl" value="/" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="styleSheet" href="${baseUrl}css/main.css" />
<title>添加图书</title>
</head>
<body>
<div id="global">
<form:form commandName="book" action="book_save" method="post">
    <fieldset>
        <legend>添加图书</legend>
        <p>
            <label for="category">种类: </label>
             <form:select id="category" path="category.id" 
                items="${categories}" itemLabel="name" 
                itemValue="id"/>
        </p>
        <p>
            <label for="title">标题: </label>
            <form:input id="title" path="title"/>
        </p>
        <p>
            <label for="author">作者: </label>
            <form:input id="author" path="author"/>
        </p>
        <p>
            <label for="isbn">ISBN: </label>
            <form:input id="isbn" path="isbn"/>
        </p>
        
        <p id="buttons">
            <input id="reset" type="reset" value="重置" tabindex="4">
            <input id="submit" type="submit" tabindex="5" 
                value="添加">
        </p>
    </fieldset>
</form:form>
</div>
<c:forEach items="${requestScope}" var="v">
${v.key}=${v.value}<br/><br/>
</c:forEach>
</body>
</html>