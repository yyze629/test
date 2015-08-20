<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>电子商务购物网站产品管理 </title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
   <h1>电子商务购物网站产品管理</h1><br>
     欢迎您!<font color="red"> ${user.username }   <a href="${pageContext.request.contextPath}/login.do?flag=logout">退出</a> 
  

   <center>
     <a href="${pageContext.request.contextPath}/login.do?flag=addProUi">添加商品</a><br>
     <a href="${pageContext.request.contextPath}/login.do?flag=goListPro">显示所有商品</a><br>
   </center>
    
  </body>
</html>
