 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <title>产品浏览及查询</title>
         <script type="text/javascript" language="javascript">
	 	  function confirmDel(){
	 	  	var result=confirm("确认删除?");
	 	  	window.alert(result);
	 	  }
	 </script> 
    </head>
	<body bgcolor="FCE0A6">
	<% response.setContentType("text/html;charset=UTF-8");
           request.setCharacterEncoding("UTF-8"); %>
	 <a href="${pageContext.request.contextPath}/login.do?flag=logout">退出</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	 <a href="${pageContext.request.contextPath}/login.do?flag=login">登录后进行管理</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	 <span style="font-size: 22pt; color: #cc0000"><strong><a href="http://www.chao98.com" target="_blank">www.chao98.com</a>&nbsp;</strong></span> 
	    <h2>产品浏览及查询</h2>
	  
	    <div>
			产品名称:&nbsp;
			  <form action="/ProductAdmin/SelectByName.do" method="post">
			     <input type="text" style="width:127px;" name="productname"> <input type="submit" value="查询">
			  </form>
	        	<font color="red">
	        	<!--  <html:errors property="productname"/></font>-->
	           </div> 
	    <p>
	  </p>
	    <div>
	        <div> 
 商品列表: <br>
 <table cellspacing="0" cellpadding="4" border="0"  style="color:#333333;border-collapse:collapse;"> 
       <tr style="color:White;background-color:#990000;font-weight:bold;"><td>产品编号</td><td>产品名称</td><td>商品类别</td><td>商品价格</td><td>商品说明</td><td>登记日期</td></tr>
       <c:forEach items="${productlist}" var="product">
      <tr style="color:#333333">  
       <td><font color="red">${product.productid } </font></td>
       <td><font color="red">${product.productname } </font></td>
       <td><font color="red">${product.category.categoryname  } </font></td>
       <td><font color="red">${product.price } </font></td>
       <td><font color="red">${product.remark } </font></td>
       <td><font color="red">${product.registerdate } </font></td>  
      </tr> 
       </c:forEach>
    </table>
    
			</div>
		</div>
	</body>
</html>
