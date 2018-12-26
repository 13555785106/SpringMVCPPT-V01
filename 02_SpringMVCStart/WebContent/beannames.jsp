<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试</title>
</head>
<body>
<h2>当前Spring下的bean名称</h2>
	<c:forEach items='${applicationScope["org.springframework.web.servlet.FrameworkServlet.CONTEXT.springmvc"].beanDefinitionNames}' var="beanName">
	${beanName}<br/>
	</c:forEach>

</body>
</html>