<%@ page language="java" import="java.util.*"  contentType="text/html;charset=utf-8" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:useBean id="cart" scope="session" class="com.liuzhen.shop.ShopCartBean"/>
<% 
  String action=request.getParameter("action");
  if(action==null)
  {
  %>
   <jsp:forward page="main_shop.jsp"/>
  <%  
  }
  else if(action.trim().equals("buy"))
  {
     String sid=request.getParameter("sid");
     cart.add(sid.trim());   
 %>
  <jsp:forward page="main_shop.jsp"/>
 <%
  }
  else if(action.trim().equals("gc"))
  {
     String sid=request.getParameter("sid");
     String count=request.getParameter("count");
     cart.setCount(Integer.parseInt(count),sid);
  %>
    <jsp:forward page="Cart.jsp"/>
  <%      
  }
  else if(action.trim().equals("del"))
  {
     String sid=request.getParameter("sid");
     cart.deleteFromCart(sid);
  %>
    <jsp:forward page="Cart.jsp"/>
  <%
  }
  %>
 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    
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
    
  </body>
</html>
