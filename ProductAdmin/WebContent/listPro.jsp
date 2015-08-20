<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理主页</title> 
	 <script type="text/javascript" language="javascript"> 
	 	   
  function confirm_delete(){
		 if (confirm("确认要删除本条信息！")){
		  return true;
		 }else {
		  return window.location.href="listPro.jsp";
		  }
		}
	 	  
	 	  
	 </script> 
  </head>   
  <body bgcolor="FEEBD0">
  <div>
<a href="${pageContext.request.contextPath}/login.do?flag=logout">退出</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<font size="+2" color="red">欢迎你 !${user.username}</font> 
&nbsp;<a href="${pageContext.request.contextPath}/login.do?flag=addProUi">添加商品</a><br>
产品名称:&nbsp;
			  <form action="/ProductAdmin/SelectByName.do" method="post">
			     <input type="text" style="width:127px;" name="productname"> <input type="submit" value="查询">
			  </form>
	        	<font color="red">
	        	<!--  <html:errors property="productname"/></font>-->
	           </div>
	   
 商品列表: <br>
 <table cellspacing="0" cellpadding="4" border="0"  style="color:#333333;border-collapse:collapse;"> 
       <tr><td>产品编号</td><td>产品名称</td><td>商品类别</td><td>商品价格</td><td>商品说明</td><td>登记日期</td><td width="100px">删除数据</td><td width="100px">修改数据</td></tr>
       <c:forEach items="${productlist}" var="product">
      <tr>  
       <td><font color="red">${product.productid } </font></td>
       <td><font color="red">${product.productname } </font></td>
       <td><font color="red">${product.category.categoryname } </font></td>
       <td><font color="red">${product.price } </font></td>
       <td><font color="red">${product.remark } </font></td>
       <td><font color="red">${product.registerdate } </font></td> 
       <td>
     <a class="delempid" href="${pageContext.request.contextPath}/login.do?flag=delPro&id=${product.productid }" onClick="confirm_delete()">删除商品</a>  
      &nbsp;&nbsp;
      </td><td>
       <a href="${pageContext.request.contextPath}/login.do?flag=goUpdProUi&id=${product.productid }">修改商品</a> 
       </td>
      </tr> 
       </c:forEach>
    </table><!-- ${pageCount} -->
    <c:forEach var="i" begin="1" end="${pageCount}">
    	<a href="${pageContext.request.contextPath}/login.do?flag=goListPro&pageNow=${i}">${i}</a>
    </c:forEach>
  </body>
</html>
