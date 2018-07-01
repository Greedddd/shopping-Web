<%@ page language="java" import="java.util.*,com.mongodb.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String text_change = "等待注册";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register_action.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>   
    <%
         response.setContentType("text/html;charset=utf-8");  //确保显示的汉字信息以正确编码方式显示
		 request.setCharacterEncoding("utf-8");            //确保获取的汉字信息以正确编码方法获取
         String userName1=(String)request.getParameter("username1");  //获取页面用户名
         String calling1=(String)request.getParameter("calling1");  //获取页面电话号码
         String passWord1=(String)request.getParameter("password1");//获取注册页面密码1
         String passWord2=(String)request.getParameter("password2");//获取注册页面密码2
         if(!passWord1.equals(passWord2)){ 
          //如果用户两次输入密码不一致，则跳转到注册原页面register.jsp,即实现未跳转效果
               response.sendRedirect("./WebRoot/register.jsp"); 
         }
    
         try{   
			 // 连接到 mongodb 服务
	         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
	         //此处采用无用户名和密码验证方式登陆
	         @SuppressWarnings("deprecation")
			 DB db = mongoClient.getDB( "test" );  //连接到数据库library
             DBCollection coll = db.getCollection("userInfo");  //获取library数据库中集合userInfo
	         System.out.println("Collection userInfo selected successfully");
	        
	         DBObject user = new BasicDBObject();//定义一个Bson变量，用于存储注册的用户名和密码
	         user.put("username", userName1);
	         user.put("calling", calling1);
             user.put("password", passWord1);	        
	         coll.insert(user);    //向集合userInfo中插入注册用户信息       	             	 
	         response.sendRedirect("register_success.jsp");  //注册成功后，自动跳转到注册成功提示页面
	         	         	                    
	      }catch(Exception e){
		     System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		 }    
     %>
     
   
  </body>
</html>
