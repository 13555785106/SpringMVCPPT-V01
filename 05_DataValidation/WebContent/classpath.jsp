<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>classpath</title>
</head>
<body>
<%=this.getClass().getClassLoader()%><br/><br/><br/><br/><br/>
	<%
		String paths = System.getProperty("java.class.path");
		for (String path : paths.split(":")) {
			out.println(path + "<br/>");
		}
	%>
</body>
</html>