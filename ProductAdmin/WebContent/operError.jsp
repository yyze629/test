<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>��������</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page"> 
  </head>
  
  <body bgcolor="FCE0A6">
                 <font color="red" size="+3">����ʧ��!</font>
                 <!--<a href="javascript.history.go(0);">������һҳ</a>
                  <a href="${pageContext.request.contextPath}/getAll.do" target="_blank">����������</a>
 -->
                 
 3����Զ���ת <%
  response.setHeader("refresh", "3 URL=listPro.jsp");  %>
  
  </body>
</html>
