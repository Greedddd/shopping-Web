<%@ page language="java" import="java.util.*,com.mongodb.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'admin_action.jsp' starting page</title>

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
    <%
        // Class.forName("com.mongodb.MongoClient");

         response.setContentType("text/html;charset=utf-8");  //确保显示的汉字信息以正确编码方式显示
		 request.setCharacterEncoding("utf-8");            //确保获取的汉字信息以正确编码方法获取
         String userName=(String)request.getParameter("username1");  //获取登录页面用户名
         String passWord=(String)request.getParameter("password1");//获取登陆页面密码
         String checkBox = request.getParameter("save_password");//获取登陆页面记住密码选择框属性值
         boolean login_test = false;               //设定登陆布尔值，若用户名和密码成功匹配，则为true

        	if("001".equals(userName) && "001".equals(passWord)){
        	 response.sendRedirect("backstage.jsp");
        }
        else{
        	 response.sendRedirect("admin_Fail.jsp");
          	// request.getRequestDispatcher("adminFail.jsp").forward(request, response);
        }
     %>
  </body>
</html>
