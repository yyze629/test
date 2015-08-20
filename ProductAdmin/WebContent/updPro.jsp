<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改商品</title> 
      <script type="text/javascript" language="javascript">
	 	  function confirmModify(){ 
		 if (confirm("确认要删除本条信息！")){
		  return true;
		 }else {
		  return window.location.href="listPro.jsp"; 
	 	  } 
	 </script> 
  </head>
  
  <body bgcolor="E6F1D8">
  <h1>修改商品</h1>
   <!-- onClick="return confirmModify()"-->
   <center>
   	 <form action="${pageContext.request.contextPath}/login.do?flag=UpdPro" method="post"> 
   <table>
   		<tr>
   		<td>商品编号  </td> <td><input type="text" readonly="readonly" value="${product.productid}" name="productid"></td></tr><br>
   		         <tr>
   		<td>   商品名称</td> <td> <input type="text" name="productname" value="${product.productname }"></td></tr><br> 
   		<tr>
   		<td> 商品价格</td> <td> <input type="text" name="price" value="${product.price }"></td></tr><br> 
   			<tr>
   		<td>登记时间</td> <td> <input type="text" name="registerdate" value="${product.registerdate }"></td></tr><br>
   			<tr>
   		<td>商品说明</td> <td> <input type="text" name="remark" value="${product.remark }"></td></tr><br> 
   			<tr>
   		<td>商品类别:</td> <td align="center">  <select name="categoryid">
   				<option value="1">内衣产品</option>
   				 <option value="2">电子产品</option>
   				 <option value="3">体育产品</option>
   				 <option value="4">虚拟产品</option>
   				 <option value="5">生活产品</option> 
   			</select> </td></tr>
   			<br>
   			<tr align="center">
   		<td>&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="修改" onClick="return confirmModify()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </td><td><input type="reset" value="重置"></td></tr>
  
    </table>  </form> 
   </center>
  </body>
</html>
