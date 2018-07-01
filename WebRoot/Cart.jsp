<%@ page language="java" import="java.util.*"   import="com.liuzhen.shop.MongodbBean"
contentType="text/html;charset=utf-8"  pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:useBean id="cart" scope="session" class="com.liuzhen.shop.ShopCartBean"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

    <title>购物车</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <link rel="stylesheet" type="text/css" href="./WebRoot/css/login.css">



  </head>

  <body style="overflow-x:hidden;overflow-y:hidden;background-image:url(./WebRoot/背景.jpg)">
   <div class="content">
   <div class="panel1">
    <%
 if(cart.isEmpty())
 {
 %>
  <font color="red" size="20">购物车中没有任何商品！！！</Font>
 <%
 }
 else
 {
 %>
 <h2>购物车</h2>
     <table border="1">
    <tr>
      <td width="27%" align="center">物品编号</td>
      <td width="27%" align="center">物品名</td>
      <td width="27%" align="center">定价</td>
      <td width="27%" align="center">数量</td>
      <td width="27%" align="center">求购</td>
    </tr>
 <%
    String[][] ssa=cart.getCart();
    for(int i=0;i<ssa.length;i++)
    {
 %>
    <tr>
      <td height="30%" align="center"><%= ssa[i][0] %></td>
      <td height="30%" align="center"><%= ssa[i][1] %></td>
      <td height="30%" align="center"><%= ssa[i][2] %></td>
      <td>
       <form action="Buy.jsp" method="post">
         <input type="text" name="count" value="<%= ssa[i][3] %>">
         <input type="hidden" name="sid" value="<%= ssa[i][0] %>">
         <input type="hidden" name="action" value="gc">
       </form>
      </td>
      <td><a href="./WebRoot/Buy.jsp?sid=<%= ssa[i][0] %>&action=del">删除</a></td>
    </tr>
 <%
    }
 %>
     </table>
     <br>
     <br>
     本订单总价为：<%= Math.round(cart.getTotal()*100)/100.0%>
 <%
 }
 %>


      <br>
    <div class="register">
     <button onclick="window.location.href='./WebRoot/main_shop.jsp'">继续购物</button>
    </div>
 </div>
 </div>
  </body>
</html>