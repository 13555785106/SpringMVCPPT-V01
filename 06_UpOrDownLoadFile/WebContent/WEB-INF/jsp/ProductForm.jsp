<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:url var="baseUrl" value="/" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="styleSheet" href="${baseUrl}css/main.css" />
<title>添加产品</title>
</head>
<body>
	<div id="global">
		<form:form commandName="product" action="product_save" method="post"
			enctype="multipart/form-data">
			<fieldset>
				<legend>添加产品</legend>
				<p>
					<label for="name">名称: </label>
					<form:input id="name" path="name" cssErrorClass="error" />
					<form:errors path="name" cssClass="error" />
				</p>
				<p>
					<label for="description">描述: </label>
					<form:input id="description" path="description" />
				</p>
				<p>
					<label for="price">价格: </label>
					<form:input id="price" path="price" cssErrorClass="error" />
				</p>
				<p>
					<label for="image">图像: </label> <input type="file" name="images" multiple/>
				</p>
				<p id="buttons">
					<input id="reset" type="reset" tabindex="4" value="重置"> <input
						id="submit" type="submit" tabindex="5" value="添加">
				</p>
			</fieldset>
		</form:form>
	</div>
</body>
</html>