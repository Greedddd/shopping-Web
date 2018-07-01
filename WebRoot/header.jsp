<%@ page language="java" import="java.util.*" contentType="text/html;charset=gb2312" pageEncoding="gb2312"%>
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
	<meta http-equiv="Content-Type" content="text/html;charset=gb2312">
	

  </head>
  
  <body  background="./WebRoot/198.jpg" topmargin="0" leftmargin="0" rightmargin="0" style="background-repeat:no-repeat;background-size:cover;overflow-x:hidden;overflow-y:hidden">
  
     <form action="">
             <table  background="./WebRoot/198.jpg" width="100%" height="300" border="0" cellpadding="0"
                     cellspacing="0" align=center>
             <tr>
                <td  valign="top">
                <table width="100%" height="150" border="0" align="center"
                       cellpadding="0" cellspacing="0" >
                 <tr>
                   <td align="center" style="font-size:50px;color: white;">
                     IBUY购物网站
                   </td>
                 </tr> 
                
                </table>
                
                </td>
             </tr>
               <tr>
                 <td bgcolor="F9A859"  valign="top">
                 <table width="100%" height="150" border="0" align="center" cellpadding="0"
                         cellspacing="0" bgcolor="#CC865E">
                  <tr>
                     <td align="center" style="font-size:20px;color: white;">
                     双十一大促正在进行!</td>
                  </tr>       
                 
                 </table>
                 
                 </td>
              </tr>              
             
             </table>
           </form>
     
  </body>
</html>
