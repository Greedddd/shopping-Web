package com.liuzhen.shop;

import java.util.Map;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;


public class MongodbTest {
	public static void main( String args[] ){
	      try{   
			 // ���ӵ� mongodb ����
	         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
	         // ���ӵ���ݿ�
	         @SuppressWarnings("deprecation")
			DB db = mongoClient.getDB( "test" );
//			 System.out.println("Connect to database successfully");
//			 DBCollection coll = db.createCollection("mycol", null);
//	         System.out.println("Collection created successfully");
	         DBCollection coll = db.getCollection("userInfo");
	         System.out.println("Collection mycol1 selected successfully");
	         
	         
//	         BasicDBObject doc = new BasicDBObject("title", "MongoDB").
//	                 append("description", "database").
//	                 append("likes", 100).
//	                 append("url", "http://www.shouce.ren/mongodb/").
//	                 append("by", "shouce.ren");
//	              coll.insert(doc);
//	         System.out.println("Document inserted successfully");
	         
	         
//	         DBCursor cursor = coll.find();
//	         while (cursor.hasNext()) { 
//	            DBObject updateDocument = cursor.next();
//	            DBObject updateDocument1 = cursor.next();
//	            updateDocument.put("likes","200");
//	            coll.update(updateDocument1, updateDocument); 
//	         }
//	         System.out.println("Document updated successfully");
	         DBCursor cursor = coll.find();
	         int i=1;
	         
	         while (cursor.hasNext()) { 
	            System.out.println("Inserted Document: "+i); 
	            DBObject show = cursor.next();
	           
	          
	            System.out.println(show); 
	            //String show1 = JSON.serialize(cursor.next());
	            @SuppressWarnings("rawtypes")
				Map show1 = show.toMap();
	            String toname = (String)show1.get("username");
	            String topassword = (String)show1.get("password");
	            if(toname.equals("2016") && topassword.equals("123456"))
	            	System.out.println("��½�ɹ�����������"+"username:"+toname+"  password:"+topassword);
	            //JSON.serialize(cursor.next());
  	            System.out.println(show1.get("username"));
	            i++;
	         }
	         
	         
//	         
//	         DBObject myDoc = coll.findOne();
//	         coll.remove(myDoc);
//	         DBCursor cursor = coll.find();
//	         int i=1;
//	         while (cursor.hasNext()) { 
//	            System.out.println("Inserted Document: "+i); 
//	            System.out.println(cursor.next()); 
//	            i++;
//	         }
//	         System.out.println("Document deleted successfully");
	      }catch(Exception e){
		     System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		  }
	   }

}
