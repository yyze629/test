<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>�û���¼</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body bgcolor="FFFBD1">
  <h1>����Ա��½</h1>
   <center> <form action="${pageContext.request.contextPath}/login.do?flag=login" method="post">
   <table>
   	
   			<tr>
   			<td>�� �� I D:</td>
   			<td><input type="text" name="userid"></td>
   			</tr>
   			<br>
   			<tr>
   			<td>��   &nbsp;&nbsp;  ��:</td><td><input type="password" name="password"></td>
   			</tr>
   			<br>
   			<tr align="center">
   			<td><input type="submit" value="��½"></td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   			<td><input type="reset" value="����"></td></tr>
     
     </table> </form>
   </center>
  </body>
</html>
