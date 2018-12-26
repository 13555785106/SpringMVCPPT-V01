<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		<h4>产品详细信息</h4>
		<p>
			${product.id}<br /> ${product.name}<br /> ${product.description}<br />
			${product.price}<br />
		</p>
	</div>
	<c:forEach items="${requestScope}" var="v">
	${v.key}=${v.value}<br />
		<br />
	</c:forEach>
</body>
</html>