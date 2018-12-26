<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加产品表单</title>
<style type="text/css">
@import url(css/main.css);
</style>
</head>
<body>
	<div id="global">
		<form action="product_save.action" method="post">
			<fieldset>
				<legend>添加产品</legend>
				<p>
					<label for="name">产品名称: </label> <input type="text"
						id="name" name="name" tabindex="1">
				</p>
				<p>
					<label for="description">描述: </label> <input type="text"
						id="description" name="description" tabindex="2">
				</p>
				<p>
					<label for="price">价格: </label> <input type="text" id="price"
						name="price" tabindex="3">
				</p>
				<p id="buttons">
					<input id="reset" type="reset" tabindex="4" value="重置"> <input
						id="submit" type="submit" tabindex="5" value="添加">
				</p>
			</fieldset>
		</form>
	</div>
</body>
</html>