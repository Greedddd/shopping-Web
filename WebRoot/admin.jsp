<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

    <title>管理员登录页面</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="./WebRoot/css/login.css">

  </head>

  <body>
   <div class="content">
     <div class="head">
            <h1>欢迎来到管理员登录页面</h1>
        </div>

        <!--  注册面板    -->
        <div class="panel">
          <form name="myform" action="./WebRoot/admin_action.jsp"  method="post">

            <!--  账号和密码组    -->
            <div class="group">
                <label></label>
                <input  type="text" placeholder="请输入管理员账号" name="username1">
            </div>

            <div class="group">
                <label></label>
                <input type="password" placeholder="请输入密码" name="password1">
            </div>

            <!--  登录按钮    -->
                        <div class="login">
                            <button type="submit" name="login">进入后台</button>
                           <button type="reset" name="reset">重置</button>
                        </div>
                       </form>
           <div class="register">
           <button onclick="window.location.href='./WebRoot/login.jsp'">返回</button>
           </div>
        </div>
      </div>
  </body>
</html>
