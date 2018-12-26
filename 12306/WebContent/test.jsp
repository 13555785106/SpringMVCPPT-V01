<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.app12306.db.model.*" %>
<%@ page import="com.app12306.db.dac.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test</title>
</head>
<body>
<%
	String str = "北京 唐山北 锦州南 辽中 沈阳 北戴河 山海关 盘锦北 沈阳北 开原西 四平东 长春 吉林 蛟河西 敦化 安图西 延吉西 图们北 珲春 秦皇岛 铁岭西 长春西 扶余北 哈尔滨西 哈尔滨 肇东 安达 大庆西 齐齐哈尔南 滦县 盘锦 海城西 鞍山西 辽阳";
	for(String s : str.split(" ")){
		System.out.println("[" + s + "]");
		Station station = new Station();
		station.setName(s);
		System.out.println(StationDac.getInstance().addStation(station));
	}

%>
</body>
</html>