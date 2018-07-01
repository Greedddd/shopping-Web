package com.liuzhen.shop;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ShopCartBean {
	
	    //ShopCartBean�๹�캯��
		public ShopCartBean(){
			
		}
		
		//����һ���洢������ֵ�ļ�ֵ��hashMap
		HashMap<String, Integer> hm=new HashMap<String, Integer>();
		//���幺�ﳵ����Ʒ�ܼ۸񣬳�ʼֵΪ0
		double total=0;
		
		//��ӹ������Ʒ�������ϣ��hm�У������㹺��ɹ�����ܼ۸�
		public void add(String sid)
		{
			if(hm.containsKey(sid))
			{
				//���hm�а�����ֵ��sid,���ȡ�ü�ֵ���е�ֵ������1
				int xc=((Integer)hm.get(sid)).intValue()+1;
				//�������ȡ��xcֵ����hm��
				hm.put(sid,new Integer(xc));;
			}
			else
			{
				//���hm�в�������ֵ��sid,�򽫸ü�ֵ�Դ���hm�У����ü�ֵ��ֵΪ1
				hm.put(sid,new Integer(1));			
			}
			total=total+MongodbBean.getPrice(sid);  //������Ʒ�󣬼�����Ʒ�ܼ۸�
		}
		
		//��ȡ���ﳵ��ǰ��Ʒ�ܼ۸�
		public double getTotal()
		{
			return total;
		}
		
		//������Ʒ���sid���趨������Ʒ��Ŀ������������Ŀ�����ϣ��hm�У������µ�ǰ���ﳵ��Ʒ�ܼ۸�
		public void setCount(int c,String sid)
		{
			int yc=((Integer)hm.get(sid)).intValue();
			total=total+(c-yc)*MongodbBean.getPrice(sid);
			hm.put(sid,new Integer(c));	
		}
		
		//������Ʒ���sid,�ӹ��ﳵ��ɾ����Ʒ,��ɾ�������ϣ��hm����Ʒ����Ŀ���Լ���ǰ���ﳵ��Ʒ�ܼ۸�
		public void deleteFromCart(String sid)
		{
			int yc=((Integer)hm.get(sid)).intValue();
			total=total-yc*MongodbBean.getPrice(sid);
			hm.remove(sid);
		}
		
		//�жϵ�ǰ��ϣ��hm�Ƿ�Ϊ��
		public boolean isEmpty()
		{
			return hm.isEmpty();
		} 
		
		//�����û�������Ʒ����ϸ��Ϣ(��Ʒ��š���Ʒ���ơ���Ʒ�۸���Ʒ��������)
		public String[][] getCart()
		{
			//����һ��set���ϣ���Ź�ϣ��hm�м�ֵ�Եļ�����
			Set<String> ks=hm.keySet();
			//����һ��������,���ڱ���set����
			Iterator<String> ii=ks.iterator();
			//��ȡ��ϣ��hm�м�ֵ�Եĸ���
			int size=hm.size();
			//�����ά���飬��Ź�����Ʒ����Ϣ
			String rs[][]=new String[size][]; 
			for(int i=0;i<size;i++)
			{
				
				String sid=(String)ii.next(); //��ż�ֵ�Եļ���,������ı��sid
				String[] sa=new String[4];   
				sa[0]=sid;        //��ȡ�������sid
				String[] sat=MongodbBean.getDetail(sid);   //���ݻ���sid,��ȡ�����������ƺͼ۸�
				sa[1]=sat[0];     //��ȡ�����������
				sa[2]=sat[1];     //��ȡ�������۸�
				sa[3]=((Integer)hm.get(sid)).toString();   //��ȡ�����������
				rs[i]=sa;       //������������Ʒ��ϸ�����ά����rs��
			}
			return rs;
		}

}
