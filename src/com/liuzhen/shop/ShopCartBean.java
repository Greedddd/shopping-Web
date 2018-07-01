package com.liuzhen.shop;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ShopCartBean {
	
	    //ShopCartBean类构造函数
		public ShopCartBean(){
			
		}
		
		//定义一个存储整形数值的键值对hashMap
		HashMap<String, Integer> hm=new HashMap<String, Integer>();
		//定义购物车总物品总价格，初始值为0
		double total=0;
		
		//添加购买的物品，存入哈希表hm中，并计算购买成功后的总价格
		public void add(String sid)
		{
			if(hm.containsKey(sid))
			{
				//如果hm中包含键值对sid,则获取该键值对中的值，并加1
				int xc=((Integer)hm.get(sid)).intValue()+1;
				//把上面获取的xc值存入hm中
				hm.put(sid,new Integer(xc));;
			}
			else
			{
				//如果hm中不包含键值对sid,则将该键值对存入hm中，并该键值对值为1
				hm.put(sid,new Integer(1));			
			}
			total=total+MongodbBean.getPrice(sid);  //购买物品后，计算物品总价格
		}
		
		//获取购物车当前物品总价格
		public double getTotal()
		{
			return total;
		}
		
		//根据物品编号sid，设定购买物品数目，并将购买数目存入哈希表hm中，并更新当前购物车物品总价格
		public void setCount(int c,String sid)
		{
			int yc=((Integer)hm.get(sid)).intValue();
			total=total+(c-yc)*MongodbBean.getPrice(sid);
			hm.put(sid,new Integer(c));	
		}
		
		//根据物品编号sid,从购物车中删除物品,并删除存入哈希表hm中物品的数目，以及当前购物车物品总价格
		public void deleteFromCart(String sid)
		{
			int yc=((Integer)hm.get(sid)).intValue();
			total=total-yc*MongodbBean.getPrice(sid);
			hm.remove(sid);
		}
		
		//判断当前哈希表hm是否为空
		public boolean isEmpty()
		{
			return hm.isEmpty();
		} 
		
		//返回用户购买物品的详细信息(物品编号、物品名称、物品价格、物品购买数量)
		public String[][] getCart()
		{
			//定义一个set集合，存放哈希表hm中键值对的键名称
			Set<String> ks=hm.keySet();
			//定义一个迭代器,用于遍历set集合
			Iterator<String> ii=ks.iterator();
			//获取哈希表hm中键值对的个数
			int size=hm.size();
			//定义二维数组，存放购买物品的信息
			String rs[][]=new String[size][]; 
			for(int i=0;i<size;i++)
			{
				
				String sid=(String)ii.next(); //存放键值对的键名,即货物的编号sid
				String[] sa=new String[4];   
				sa[0]=sid;        //获取购买货物sid
				String[] sat=MongodbBean.getDetail(sid);   //根据货物sid,获取购买货物的名称和价格
				sa[1]=sat[0];     //获取购买货物名称
				sa[2]=sat[1];     //获取购买货物价格
				sa[3]=((Integer)hm.get(sid)).toString();   //获取购买货物数量
				rs[i]=sa;       //将上述单个物品详细存入二维数组rs中
			}
			return rs;
		}

}
