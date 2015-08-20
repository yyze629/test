<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加商品</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body bgcolor="FCD9C4">
  <h1>添加商品</h1>
   <center>
   	 <form action="${pageContext.request.contextPath}/login.do?flag=addPro" method="post">
   <table>
   			<tr><td>产品名称: </td><td><input type="text" name="productname"></td></tr><br>
   			<tr><td>商品价格: </td><td><input type="text" name="price"></td></tr><br> 
   			<tr><td>商品说明: </td><td><input type="text" name="remark"></td></tr><br>
   		 	<tr><td>商品类别: </td><td><select name="categoryid">
   				<option value="1">内衣产品</option>
   				 <option value="2">电子产品</option>
   				  <option value="3">体育产品</option>
   				   <option value="4">虚拟产品</option>
   				   <option value="5">生活产品</option>
   				   <option value="6">学习产品</option>
   			</select> </td></tr>
   			<br>
   			<tr align="center"><td>&nbsp;&nbsp;&nbsp;<input type="submit" value="添加">&nbsp;&nbsp;&nbsp;</td><td><input type="reset" value="重置"></td><tr>
 
     </table>     </form>
   </center>
  </body>
</html>
