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
    
    <title>������ҳ</title> 
	 <script type="text/javascript" language="javascript"> 
	 	   
  function confirm_delete(){
		 if (confirm("ȷ��Ҫɾ��������Ϣ��")){
		  return true;
		 }else {
		  return window.location.href="listPro.jsp";
		  }
		}
	 	  
	 	  
	 </script> 
  </head>   
  <body bgcolor="FEEBD0">
  <div>
<a href="${pageContext.request.contextPath}/login.do?flag=logout">�˳�</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<font size="+2" color="red">��ӭ�� !${user.username}</font> 
&nbsp;<a href="${pageContext.request.contextPath}/login.do?flag=addProUi">�����Ʒ</a><br>
��Ʒ����:&nbsp;
			  <form action="/ProductAdmin/SelectByName.do" method="post">
			     <input type="text" style="width:127px;" name="productname"> <input type="submit" value="��ѯ">
			  </form>
	        	<font color="red">
	        	<!--  <html:errors property="productname"/></font>-->
	           </div>
	   
 ��Ʒ�б�: <br>
 <table cellspacing="0" cellpadding="4" border="0"  style="color:#333333;border-collapse:collapse;"> 
       <tr><td>��Ʒ���</td><td>��Ʒ����</td><td>��Ʒ���</td><td>��Ʒ�۸�</td><td>��Ʒ˵��</td><td>�Ǽ�����</td><td width="100px">ɾ������</td><td width="100px">�޸�����</td></tr>
       <c:forEach items="${productlist}" var="product">
      <tr>  
       <td><font color="red">${product.productid } </font></td>
       <td><font color="red">${product.productname } </font></td>
       <td><font color="red">${product.category.categoryname } </font></td>
       <td><font color="red">${product.price } </font></td>
       <td><font color="red">${product.remark } </font></td>
       <td><font color="red">${product.registerdate } </font></td> 
       <td>
     <a class="delempid" href="${pageContext.request.contextPath}/login.do?flag=delPro&id=${product.productid }" onClick="confirm_delete()">ɾ����Ʒ</a>  
      &nbsp;&nbsp;
      </td><td>
       <a href="${pageContext.request.contextPath}/login.do?flag=goUpdProUi&id=${product.productid }">�޸���Ʒ</a> 
       </td>
      </tr> 
       </c:forEach>
    </table><!-- ${pageCount} -->
    <c:forEach var="i" begin="1" end="${pageCount}">
    	<a href="${pageContext.request.contextPath}/login.do?flag=goListPro&pageNow=${i}">${i}</a>
    </c:forEach>
  </body>
</html>
