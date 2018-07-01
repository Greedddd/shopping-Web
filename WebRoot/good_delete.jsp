<%@ page language="java" import="java.util.*,com.mongodb.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String text_change = "等待添加";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

    <title>My JSP 'good_action.jsp' starting page</title>

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

         String sid1=(String)request.getParameter("sid1");//获取商品编号1


         try{
			 // 连接到 mongodb 服务
	         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
	         //此处采用无用户名和密码验证方式登陆
	         @SuppressWarnings("deprecation")
			 DB db = mongoClient.getDB( "library" );  //连接到数据库library
             DBCollection coll = db.getCollection("good");  //获取library数据库中集合good
	         System.out.println("Collection good selected successfully");


	         coll.remove({"sid":sid1});    //向集合good中删除信息
	         response.sendRedirect("backstage.jsp");  //成功后，自动跳转到后台页面

	      }catch(Exception e){
		     System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		 }
     %>


  </body>
</html>
