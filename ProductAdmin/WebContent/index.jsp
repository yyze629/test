<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	    <title>超九八网站商品---后台管理中心</title>
	</head>
	<FRAMESET id="top" border="0px" frameSpacing=0 rows="60,81%" frameBorder="0px">
        <FRAME name="Top" src="TopMenu.htm" noResize scrolling=no>
        <FRAMESET id="frame" cols="200,100%" />
            <FRAME name="Left" src="LeftMenu.htm" />
            <FRAME src="ProductList.jsp" name="main" />
        </FRAMESET>
    </FRAMESET>
</html>
