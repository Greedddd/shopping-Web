package com.liuzhen.shop;

import java.sql.*;
import java.util.*;

public class DBBean
{
	static Connection con;     //建立一个数据库连接
	//PreparedStatement 实例包含已编译的 SQL 语句,就是使语句“准备好”
	static PreparedStatement psGoodList;  //定义货物全部信息编译SQL语句 变量
	static PreparedStatement psGoodFromIdToPrice;  //定义具体货物价格编译SQL语句变量
	static PreparedStatement psGoodFromIdToDetail; //定义具体货物名称及价格编译SQL语句 变量
	static PreparedStatement psCountRecords;  //定义数据库中现有货物记录种类数目编译SQL语句比那里
	static int span=5;    //设定JSP页面表单单页显示物品信息行数为5行
	
	static
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String userName="root";
			String userPwd="root";
			String dbName="test_system";
			String url="jdbc:mysql://localhost/"+dbName+"?user="+userName+"&password="+userPwd; 
			con=DriverManager.getConnection(url);    //连接到指定url中的数据库
			//从数据库中获取货物全部信息
			psGoodList=
			con.prepareStatement(
				"select * from good",
				ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
			//根据货物的编号，获取货物的价格
			psGoodFromIdToPrice=con.prepareStatement("select sprice from good where sid=?");
			//根据货物的编号，获取货物的名称和价格
			psGoodFromIdToDetail=con.prepareStatement("select sname,sprice from good where sid=?");
			//从数据库中查询现有货物种类的数目
		    psCountRecords=con.prepareStatement(
		     "select count(sid) from good"	
		    );
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//获取数据库中货物种类的具体信息，并以二维数据返回具体信息
	public static String[][] getGoodList(int cp)
	{
	    String[][] result=null;
	    Vector<String[]> v=new Vector<String[]>();
	    try
	    {
	    	//从数据库中获取货物全部信息,通过ResultSet得到具体结果，并存入变量rs中
	    	ResultSet rs=psGoodList.executeQuery();
	    	if(cp!=1)
	    	{
	    		//调用 absolute(1) 等效于调用 first(),调用 absolute(-1) 等效于调用 last()。
	    		rs.absolute((cp-1)*span);
	    	}
	    	
	    	int count=1;
	    	
	    	while(rs.next()&&count<=span)
	    	{
	    		count++;
	    		String[] tempsa=new String[3];
	    		tempsa[0]=rs.getString(1);
	    		tempsa[1]=rs.getString(2);
	    		tempsa[2]=rs.getString(3);
	    		v.add(tempsa);
	    	}
	        int size=v.size();
	        result=new String[size][];   //更具Vercotr大小，给result指定行数大小
	        for(int i=0;i<size;i++)
	        {
               //返回Vector中一个值(其中即表示一个物品的sid,名称和价格)，并赋值给result[i],即result二维数组一行表示一个物品具体信息
	        	result[i]=(String[])v.elementAt(i); 
	        }
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	//返回一个二维数组的行数大小
	public static int getlength(String[][] a){
		return a.length;
	}
	
    //根据货物sid,返回其价格信息
	public static double getPrice(String sid)
	{
		double dd=0;
		try			
		{
			//根据货物的编号，获取货物的价格,为其中SQL语句中 的变量赋值
			psGoodFromIdToPrice.setString(1,sid);
			//通过调用ResultSet具体执行SQL语句，返回具体货物的价格
			ResultSet rs=psGoodFromIdToPrice.executeQuery();
			//继续查询下一个
			rs.next();
			//将获取的价格信息由字符串转换为double类型
			dd=Double.parseDouble(rs.getString(1));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return dd;
	}
	
	//根据货物sid,返回货物的名称和价格,一一个长度为2的数组返回
	public static String[] getDetail(String sid)
	{
		String[] ss=null;
		try			
		{
			//根据货物的编号，获取货物的名称和价格,为其中SQL语句变量赋值
			psGoodFromIdToDetail.setString(1,sid);
			//通过调用ResultSet具体执行SQL语句，返回具体货物的名称和价格
			ResultSet rs=psGoodFromIdToDetail.executeQuery();
			rs.next();    //结果集指向下一条记录信息
			ss=new String[2];
			ss[0]=rs.getString(1);  //获取货物名称
			ss[1]=rs.getString(2);  //获取货物价格
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ss;
	}
	
	//通过查询数据库中货物种类数目，以5行为一页，返回现有货物页数
	public static int getTotalPage()
	{
		int tp=0;
		try
		{
			//通过调用ResultSet具体执行SQL语句，返回现有货物种类的数目
			ResultSet rs=psCountRecords.executeQuery();
			rs.next();
			int count=rs.getInt(1);   //获取享有货物种类的数目
			tp=count/span+((count%span==0)?0:1);   //以span行为一页，计算货物具有的页数tp
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return tp;
	}
	
	public static void main(String args[])
	{
		System.out.println("分页数目(测试)："+DBBean.getTotalPage());
		String[][] ss=DBBean.getGoodList(DBBean.getTotalPage());
		for(int i=0;i<ss.length;i++)
		{
			System.out.println(ss[i][0]);
			System.out.println(ss[i][1]);
			System.out.println(ss[i][2]);
			System.out.println("*****************");
		}
		int n = ss.length;
		System.out.println("数组长度为："+n);
		System.out.println("mysql连接成功");
	}
	
}