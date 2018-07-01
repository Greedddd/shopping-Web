package com.liuzhen.shop;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapDemo {
	  public static void main(String[] args) {  
          
	        HashMap<String, String> hashMap = new HashMap<String, String>();  
	        hashMap.put("cn", "�й�");  
	        hashMap.put("jp", "�ձ�");  
	        hashMap.put("fr", "����");  
	          
	        System.out.println(hashMap);  
	        System.out.println("cn:" + hashMap.get("cn"));  
	        System.out.println(hashMap.containsKey("cn"));  
	        System.out.println(hashMap.keySet());  
	        System.out.println(hashMap.isEmpty());  
	          
	        hashMap.remove("cn");  
	        System.out.println(hashMap.containsKey("cn"));  
	          
	        //����Iterator����HashMap  
	        @SuppressWarnings("rawtypes")
			Iterator it = hashMap.keySet().iterator();  
	        while(it.hasNext()) {  
	            String key = (String)it.next();  
	            System.out.println("key:" + key);  
	            System.out.println("value:" + hashMap.get(key));  
	        }  
	          
	        //����HashMap����һ������  
	        Set<Entry<String, String>> sets = hashMap.entrySet();  
	        for(Entry<String, String> entry : sets) {  
	            System.out.print(entry.getKey() + ", ");  
	            System.out.println(entry.getValue());  
	        }  
	    }  
}
