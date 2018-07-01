<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String username = "";
String password = "";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登陆页面</title>
    
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
            <h1>IBUY购物网站</h1>
        </div>

        <!--  登录面板    -->
        <div class="panel">
          <form action="./WebRoot/login_action.jsp" method="post">  
            
            <!--  账号和密码组    -->
            <div class="group">
                <label>账号</label>
                <input  type="text" placeholder="请输入账号" name="username" value="<%=username%>">
            </div>
            <div class="group">
                <label>密码</label>
                <input type="password" placeholder="请输入密码" name="password" value="<%=password%>">
            </div>
            <div>
             <input type="checkbox" value="save" name="save_password"> 
             <label>记住密码</label> 
            </div>
            <div class="group">
            <label></label>
            </div>
            <!--  登录按钮    -->
            <div class="login">
                <button type="submit" name="login">登陆</button>
               <button type="reset" name="reset">重置</button>
            </div>
           </form>
        </div>
  
        <!--  注册按钮    -->
        <div class="register">
            <button onclick="window.location.href='./WebRoot/register.jsp'">创建新账号</button>
        </div>
        <div class="register">
                    <button onclick="window.location.href='./WebRoot/admin.jsp'">管理员登录</button>
                </div>

    </div>
  </body>
</html>
