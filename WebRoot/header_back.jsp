<%@ page language="java" import="java.util.*" contentType="text/html;charset=gb2312" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8">


  </head>

  <body topmargin="0" leftmargin="0" rightmargin="0" style="background-color: #555555;overflow-x:hidden;overflow-y:hidden">

     <form action="">
             <table  width="100%" height="79" border="0" cellpadding="0"
                     cellspacing="0" align=center>
             <tr>
                <td bgcolor="F9A859" valign="top">
                <table width="100%" height="100" border="0" align="center"
                       cellpadding="0" cellspacing="0" bgcolor="#555555">
                 <tr>
                   <td align="center" style="font-size:50px;color: white;">
                     管理员后台
                   </td>
                 </tr>

                </table>

                </td>
             </tr>
               <tr>
                 <td bgcolor="F9A859"  valign="top">
                 <table width="100%" height="50" border="0" align="center" cellpadding="0"
                         cellspacing="0" bgcolor="#e7e7e7">
                  <tr>
                     <td align="center" style="font-size:20px;color: black;">

                    </td>
                  </tr>

                 </table>

                 </td>
              </tr>

             </table>
           </form>

  </body>
</html>