<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:url var="baseUrl" value="/" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="styleSheet" href="${baseUrl}css/main.css" />
<title>产品详细信息</title>
</head>
<body>
	<div id="global">
		<h4>${message}</h4>
		<h5>详细信息:</h5>
		<p>
			产品名称: ${product.name}<br /> 描述:${product.description}<br /> 价格:
			$${product.price}
		</p>
	</div>
	
	<c:forEach items="${requestScope}" var="s">
	${s.key}=${s.value}<br/>
	</c:forEach>
	
</body>
</html>