<%@ page contentType="text/html;charset=utf-8"  import="java.util.*,com.liuzhen.shop.MongodbBean" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String cp=request.getParameter("cp");//cp为分页数
//int page_number = DBBean.getTotalPage();
//int currpage = page_number;
int currpage=(cp==null||cp=="")?1:Integer.parseInt(cp);
String[][] ss = MongodbBean.getGoodList(currpage);
int n = MongodbBean.getlength(ss);

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

			    <title>商品页面</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="./WebRoot/css/login.css">


  </head>

  <body style="overflow-x:hidden;overflow-y:hidden;background-image:url(./WebRoot/背景.jpg)">
  <div class="content">
  <div class="panel1">
    <table border="1" align="center">
   <tr>
    <th width="30%" align="center">物品编号</th>
    <th width="30%" align="center">物品名</th>
    <th width="30%" align="center">定价</th>
    <th width="50%" align="center">求购</th>
  </tr>
 <%

		for(int i=0;i<n;i++)
		{
%>
  <tr>
    <td height="30%" align="center"><%= ss[i][0] %></td>
    <td height="30%" align="center"><%= ss[i][1] %></td>
    <td height="30%" align="center"><%= ss[i][2] %></td>
    <td height="30%" align="center"><a href="./WebRoot/good_delete.jsp?sid1=<%= ss[i][0] %>">删除商品</a></td>
  </tr>
<%
		}


 %>
    </table>

 <%
   int tp=MongodbBean.getTotalPage();
   System.out.println(tp);
   if(currpage!=1)
   {

  %>

     <a href="./WebRoot/back_shop.jsp?cp=<%=currpage-1%>">上一页</a>

  <%

   }

   if(currpage!=tp)
   {
%>
  <a href="./WebRoot/back_shop.jsp?cp=<%=currpage+1%>">下一页</a>
<%
   }
  %>

   <form action="back_shop.jsp" name="myform">
     <select name="cp" onchange="document.myform.submit()">
<%
    for(int i=1;i<=tp;i++)
    {
%>
    <option value="<%=i%>" <%= (i==currpage)?"selected":"" %>>第<%=i%>页</option>
<%
    }
 %>
     </select>
   </form>
</div>
    <div class="register">

     <button onclick="window.location.href='./WebRoot/good_add.jsp'">增加商品</button>
    </div>

    </div>
  </body>

</html>
