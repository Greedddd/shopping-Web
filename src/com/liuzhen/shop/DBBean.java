package com.liuzhen.shop;

import java.sql.*;
import java.util.*;

public class DBBean
{
	static Connection con;     //����һ�����ݿ�����
	//PreparedStatement ʵ�������ѱ���� SQL ���,����ʹ��䡰׼���á�
	static PreparedStatement psGoodList;  //�������ȫ����Ϣ����SQL��� ����
	static PreparedStatement psGoodFromIdToPrice;  //����������۸����SQL������
	static PreparedStatement psGoodFromIdToDetail; //�������������Ƽ��۸����SQL��� ����
	static PreparedStatement psCountRecords;  //�������ݿ������л����¼������Ŀ����SQL��������
	static int span=5;    //�趨JSPҳ�����ҳ��ʾ��Ʒ��Ϣ����Ϊ5��
	
	static
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String userName="root";
			String userPwd="root";
			String dbName="test_system";
			String url="jdbc:mysql://localhost/"+dbName+"?user="+userName+"&password="+userPwd; 
			con=DriverManager.getConnection(url);    //���ӵ�ָ��url�е����ݿ�
			//�����ݿ��л�ȡ����ȫ����Ϣ
			psGoodList=
			con.prepareStatement(
				"select * from good",
				ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
			//���ݻ���ı�ţ���ȡ����ļ۸�
			psGoodFromIdToPrice=con.prepareStatement("select sprice from good where sid=?");
			//���ݻ���ı�ţ���ȡ��������ƺͼ۸�
			psGoodFromIdToDetail=con.prepareStatement("select sname,sprice from good where sid=?");
			//�����ݿ��в�ѯ���л����������Ŀ
		    psCountRecords=con.prepareStatement(
		     "select count(sid) from good"	
		    );
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//��ȡ���ݿ��л�������ľ�����Ϣ�����Զ�ά���ݷ��ؾ�����Ϣ
	public static String[][] getGoodList(int cp)
	{
	    String[][] result=null;
	    Vector<String[]> v=new Vector<String[]>();
	    try
	    {
	    	//�����ݿ��л�ȡ����ȫ����Ϣ,ͨ��ResultSet�õ������������������rs��
	    	ResultSet rs=psGoodList.executeQuery();
	    	if(cp!=1)
	    	{
	    		//���� absolute(1) ��Ч�ڵ��� first(),���� absolute(-1) ��Ч�ڵ��� last()��
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
	        result=new String[size][];   //����Vercotr��С����resultָ��������С
	        for(int i=0;i<size;i++)
	        {
               //����Vector��һ��ֵ(���м���ʾһ����Ʒ��sid,���ƺͼ۸�)������ֵ��result[i],��result��ά����һ�б�ʾһ����Ʒ������Ϣ
	        	result[i]=(String[])v.elementAt(i); 
	        }
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	//����һ����ά�����������С
	public static int getlength(String[][] a){
		return a.length;
	}
	
    //���ݻ���sid,������۸���Ϣ
	public static double getPrice(String sid)
	{
		double dd=0;
		try			
		{
			//���ݻ���ı�ţ���ȡ����ļ۸�,Ϊ����SQL����� �ı�����ֵ
			psGoodFromIdToPrice.setString(1,sid);
			//ͨ������ResultSet����ִ��SQL��䣬���ؾ������ļ۸�
			ResultSet rs=psGoodFromIdToPrice.executeQuery();
			//������ѯ��һ��
			rs.next();
			//����ȡ�ļ۸���Ϣ���ַ���ת��Ϊdouble����
			dd=Double.parseDouble(rs.getString(1));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return dd;
	}
	
	//���ݻ���sid,���ػ�������ƺͼ۸�,һһ������Ϊ2�����鷵��
	public static String[] getDetail(String sid)
	{
		String[] ss=null;
		try			
		{
			//���ݻ���ı�ţ���ȡ��������ƺͼ۸�,Ϊ����SQL��������ֵ
			psGoodFromIdToDetail.setString(1,sid);
			//ͨ������ResultSet����ִ��SQL��䣬���ؾ����������ƺͼ۸�
			ResultSet rs=psGoodFromIdToDetail.executeQuery();
			rs.next();    //�����ָ����һ����¼��Ϣ
			ss=new String[2];
			ss[0]=rs.getString(1);  //��ȡ��������
			ss[1]=rs.getString(2);  //��ȡ����۸�
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ss;
	}
	
	//ͨ����ѯ���ݿ��л���������Ŀ����5��Ϊһҳ���������л���ҳ��
	public static int getTotalPage()
	{
		int tp=0;
		try
		{
			//ͨ������ResultSet����ִ��SQL��䣬�������л����������Ŀ
			ResultSet rs=psCountRecords.executeQuery();
			rs.next();
			int count=rs.getInt(1);   //��ȡ���л����������Ŀ
			tp=count/span+((count%span==0)?0:1);   //��span��Ϊһҳ�����������е�ҳ��tp
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return tp;
	}
	
	public static void main(String args[])
	{
		System.out.println("��ҳ��Ŀ(����)��"+DBBean.getTotalPage());
		String[][] ss=DBBean.getGoodList(DBBean.getTotalPage());
		for(int i=0;i<ss.length;i++)
		{
			System.out.println(ss[i][0]);
			System.out.println(ss[i][1]);
			System.out.println(ss[i][2]);
			System.out.println("*****************");
		}
		int n = ss.length;
		System.out.println("���鳤��Ϊ��"+n);
		System.out.println("mysql���ӳɹ�");
	}
	
}