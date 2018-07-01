package com.liuzhen.shop;

import java.util.Map;
import java.util.Vector;

import com.mongodb.*;

public class MongodbBean {
	
	static int span=5;    //�趨JSPҳ��?��ҳ��ʾ��Ʒ��Ϣ����Ϊ5��
	
	//������ݿ���ȫ��������sid
	public static String[] getGood_sid(){
		String[] good_sid_temporary = new String[100];    //����һ������Ϊ100����ʱ��Ż����ŵ�һά����	
		 // ���ӵ� mongodb ����
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
        //�˴��������û����������֤��ʽ��½
        @SuppressWarnings("deprecation")
		DB db = mongoClient.getDB( "test" );  //���ӵ���ݿ�library
        DBCollection coll = db.getCollection("good");  //��ȡlibrary��ݿ��м���good
//        System.out.println("Collection userInfo selected successfully");
        DBCursor cursor = coll.find();  //��ѯ����good���ĵ���Ϣ
       if(!cursor.hasNext()){
		   System.out.println("-------------------no-----------");
	   }
        int i=0; 
        while (cursor.hasNext()) {     //��������good�������ĵ���Ϣ
			System.out.println("---------------------------test-----------");

			DBObject show = cursor.next();
                 
           @SuppressWarnings("rawtypes")
           Map show1 = show.toMap();  //���������show(Bson����)ת��ΪMap����
           String tosid = (String)show1.get("sid");  //��ȡMap���ֶ���Ϊsid������ֵ                      
           good_sid_temporary[i] = tosid;         //����ݿ��в�ѯ�Ļ����Ŵ洢������good_sid                              
           i++;
         }
		String[] good_sid = new String[i];   //��ݲ�ѯ��ݱ�������ĵ���Ϣiֵ��ȷ�����շ������鳤��
		for(int j=0;j<i;j++){
			good_sid[j] = good_sid_temporary[j];
		}
        
		return good_sid;
	}
	
	//������ݿ���ȫ���������sname
	public static String[] getGood_sname(){
		String[] good_sname_temporary = new String[100];  //����һ������Ϊ100����ʱ��Ż�����Ƶ�һά����
		 // ���ӵ� mongodb ����
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
        //�˴��������û����������֤��ʽ��½
        @SuppressWarnings("deprecation")
		DB db = mongoClient.getDB( "test" );  //���ӵ���ݿ�library
        DBCollection coll = db.getCollection("good");  //��ȡlibrary��ݿ��м���good
        System.out.println("Collection userInfo selected successfully");
        DBCursor cursor = coll.find();  //��ѯ����good���ĵ���Ϣ
       
        int i=0; 
        while (cursor.hasNext()) {     //��������good�������ĵ���Ϣ
           DBObject show = cursor.next();                
           @SuppressWarnings("rawtypes")
           Map show1 = show.toMap();  //���������show(Bson����)ת��ΪMap����         
           String tosname = (String)show1.get("sname"); //��ȡMap���ֶ���Ϊsname������ֵ                           
           good_sname_temporary[i] = tosname;     //����ݿ��в�ѯ�Ļ�����ƴ洢������good_sname                         
           i++;
        }
		String[] good_sname = new String[i];   //��ݲ�ѯ��ݱ�������ĵ���Ϣiֵ��ȷ�����շ������鳤��
		for(int j=0;j<i;j++){
			good_sname[j] = good_sname_temporary[j];
		}
		return good_sname;
	}
	
	//������ݿ���ȫ������۸�sprice
	public static String[] getGood_sprice(){
		String[] good_sprice_temporary = new String[100]; //����һ������Ϊ100����ʱ��Ż���۸��һά����
		 // ���ӵ� mongodb ����
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
        //�˴��������û����������֤��ʽ��½
        @SuppressWarnings("deprecation")
		DB db = mongoClient.getDB( "test" );  //���ӵ���ݿ�library
        DBCollection coll = db.getCollection("good");  //��ȡlibrary��ݿ��м���good
        System.out.println("Collection userInfo selected successfully");
        DBCursor cursor = coll.find();  //��ѯ����good���ĵ���Ϣ
       
        int i=0; 
        while (cursor.hasNext()) {     //��������good�������ĵ���Ϣ
           DBObject show = cursor.next();               
           @SuppressWarnings("rawtypes")
           Map show1 = show.toMap();  //���������show(Bson����)ת��ΪMap����         
           String tosprice = (String)show1.get("sprice"); //��ȡMap���ֶ���Ϊsname������ֵ                    
           good_sprice_temporary[i] = tosprice;   //��������в�ѯ�Ļ���۸�洢������good_sprice                     
           i++;
        }
		String[] good_sprice = new String[i];   //��ݲ�ѯ��ݱ�������ĵ���Ϣiֵ��ȷ�����շ������鳤��
		for(int j=0;j<i;j++){
			good_sprice[j] = good_sprice_temporary[j];
		}
		return good_sprice;
	}

	//��ݷ�ҳ��ǰpage��,����ݿ��л�ȡ��ǰ����ҳ���������ľ�����Ϣ�����Զ�ά��ݷ��ؾ�����Ϣ
	public static String[][] getGoodList(int page)
	{
		String[][] result=null;
	    Vector<String[]> v=new Vector<String[]>();  //����һ��Vector���ϣ�һ����¼���һ������ľ�����Ϣ
	    String[] good_sid = getGood_sid();        //��ȡ������
	    String[] good_sname = getGood_sname();    //��ȡ�������
	    String[] good_sprice = getGood_sprice();  //��ȡ����۸�	   
	    int len = good_sid.length;
	    for(int i=0;i<span;i++){
	    	int t = (page-1)*span+i;   //��ȡ������
    		if(t >= len){ 
    			//���ǰ�����Ŵ�����ݿ������б�ţ������ѭ��
    			break;
    		}
	    	
	    	String[] good_temp=new String[3];   //����һ������Ϊ3�����飬���ڴ��һ����Ʒ�ı�š���ơ��۸���Ϣ
    		good_temp[0]=good_sid[t];
    		good_temp[1]=good_sname[t];
    		good_temp[2]=good_sprice[t];
    		v.add(good_temp);      //��1����Ʒ����Ϣ����Vector������
    		
    		
	    }
	    
	    int size = v.size();
	    result=new String[size][];   //���Vercotr��С����resultָ�������С
	    for(int j=0;j<size;j++)
        {
           //����Vector��һ��ֵ(���м���ʾһ����Ʒ��sid,��ƺͼ۸�)������ֵ��result[j],��result��ά����һ�б�ʾһ����Ʒ������Ϣ
        	result[j]=(String[])v.elementAt(j); 
        }
	    
	    return result;
	}
	
	  //��ݻ���sid,������۸���Ϣ
	public static double getPrice(String sid)
	{
		double price = 0;  //���巵����Ʒ�ļ۸�
		String[] good_sprice = getGood_sprice();  //��ȡȫ����Ʒ�ļ۸�
		
		int i =  Integer.parseInt(sid);        //��String���͵���Ʒ���sidת��Ϊint��
	    String sprice = good_sprice[i];        //���sid��ȡ��Ʒ�ļ۸�
	    price = Double.parseDouble(sprice);    //��String���͵ļ۸���Ϣת��Ϊdouble�ͣ�����ֵ��price
		
		return price;
	}
	
	//��ݻ���sid,���ػ������ƺͼ۸�,һһ������Ϊ2�����鷵��
	public static String[] getDetail(String sid)
	{
		String[] good_detail=null;
		good_detail = new String[2];
		String[] good_sname = getGood_sname();     //��ȡȫ����Ʒ���
		String[] good_sprice = getGood_sprice();   //��ȡȫ����Ʒ�۸�
		int i =  Integer.parseInt(sid);        //��String���͵���Ʒ���sidת��Ϊint��
		good_detail[0] = good_sname[i];        //�����Ʒ���sid���õ���ƴ�������good_detail��
		good_detail[1] = good_sprice[i];       //�����Ʒ���sid���õ���Ʒ�۸��������good_detail��		
		
		return good_detail;
	}
	
	//ͨ���ѯ��ݿ��л���������Ŀ����5��Ϊһҳ���������л���ҳ��
	public static int getTotalPage()
	{
		int page = 0;
		String[] good_sid = getGood_sid();
		int len = good_sid.length;
		page = len/span+((len%span==0)?0:1);   //��span(spanֵΪ5)��Ϊһҳ�����������е�ҳ��page
		
		return page;			
	}
			
		
	
	//����һ����ά����������С
	public static int getlength(String[][] a){
		return a.length;
	}
	
	
	public static void main(String args[]){
//		String[] good_sid = getGood_sid();    //����һ����Ż����ŵ�һά����
//		String[] good_sname = getGood_sname();  //����һ����Ż�����Ƶ�һά����
//		String[] good_sprice = getGood_sprice(); //����һ����Ż���۸��һά����
//				       	   		
//		for(int j=0;j<10;j++){
//			System.out.println("����sid:"+good_sid[j]);
//			System.out.println("����sname:"+good_sname[j]);
//			System.out.println("������price��"+good_sprice[j]);
//			System.out.println("**************************");
//			System.out.println();
//		}
		
		System.out.println("��ҳ��Ŀ(����)��"+MongodbBean.getTotalPage());
		String[][] ss=MongodbBean.getGoodList(MongodbBean.getTotalPage());
		for(int i=0;i<ss.length;i++)
		{
			System.out.println(ss[i][0]);
			System.out.println(ss[i][1]);
			System.out.println(ss[i][2]);
			System.out.println("***********");
		}
		int n = ss.length;
		System.out.println("���鳤��Ϊ��"+n);
		
		
	}
	

}
