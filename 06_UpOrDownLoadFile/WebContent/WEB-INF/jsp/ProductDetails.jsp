<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:url var="baseUrl" value="/" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品信息</title>
</head>
<body>
<div id="global">
    <h4>产品已经被保存.</h4>
        <h5>详细信息:</h5>
        名称: ${product.name}<br/>
        描述: ${product.description}<br/>
        价格: $${product.price}
        <p>产品图片.</p>
        <ol>
        <c:forEach items="${product.images}" var="image">
            <li>${image.originalFilename}
            <img width="100" src="${baseUrl}image/${image.originalFilename}"/>
            </li>
        </c:forEach>
        </ol>

</div>
</body>
</html>