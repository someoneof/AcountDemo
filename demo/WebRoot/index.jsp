<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>账户管理首页</title>
</head>
<body>
  <br>点击进入账户管理首页<input type="submit" value="进入" onclick="javascript:window.location.href='/demo/acount/list'">
	  
</body>
</html>
