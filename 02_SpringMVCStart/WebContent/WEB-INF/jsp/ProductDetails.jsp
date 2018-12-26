<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>保存产品</title>
<style type="text/css">
@import url(css/main.css);
</style>
</head>
<body>
	<div id="global">
		<h4>产品已经被保存.</h4>

		<h5>详细信息:</h5>
		<p>
			产品名称: ${product.name}<br /> 描述:${product.description}<br /> 价格:
			$${product.price}
		</p>
	</div>
</body>
</html>