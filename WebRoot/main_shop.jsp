<%@ page contentType="text/html;charset=GBK"  import="java.util.*,com.liuzhen.shop.MongodbBean" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String cp=request.getParameter("cp");//cpΪ��ҳ��
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
			    
			    <title>����ҳ��</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="./WebRoot/css/login.css">
	

  </head>
  
  <body style="overflow-x:hidden;overflow-y:hidden;background-image:url(./WebRoot/����.jpg)">
  <div class="content">
  <div class="panel1">
    <table border="1" align="center">
   <tr>
    <th width="30%" align="center">��Ʒ���</th>
    <th width="30%" align="center">��Ʒ��</th>
    <th width="30%" align="center">����</th>    
    <th width="50%" align="center">��</th>  
  </tr>   
 <% 
		
		for(int i=0;i<n;i++)
		{
%>
  <tr>
    <td height="30%" align="center"><%= ss[i][0] %></td>
    <td height="30%" align="center"><%= ss[i][1] %></td>
    <td height="30%" align="center"><%= ss[i][2] %></td>
    <td height="30%" align="center"><a href="./WebRoot/Buy.jsp?sid=<%= ss[i][0] %>&action=buy">����</a></td>
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
  
     <a href="./WebRoot/main_shop.jsp?cp=<%=currpage-1%>">��һҳ</a>
  
  <%
   
   }
   
   if(currpage!=tp)
   {   
%>
  <a href="./WebRoot/main_shop.jsp?cp=<%=currpage+1%>">��һҳ</a>
<%      
   } 
  %>   
    
   <form action="main_shop.jsp" name="myform">
     <select name="cp" onchange="document.myform.submit()">
<% 
    for(int i=1;i<=tp;i++)
    {
%>
    <option value="<%=i%>" <%= (i==currpage)?"selected":"" %>>��<%=i%>ҳ</option>
<%    
    }
 %>
     </select>
   </form>
</div>
    <div class="register">
     
     <button onclick="window.location.href='./WebRoot/Cart.jsp'">�鿴���ﳵ</button>
    </div>
    
    </div>
  </body>
  
</html>