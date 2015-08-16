package com.hand.Exam4;

import java.awt.List;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.print("随机生成50个小于100的数,分别为:");
    	List list=new List();
    	int number[]=new int[50];
    	int key[]=new int[10];
    	TreeSet<String> ts=new TreeSet<String>();    //自动排序
    	for(int i=0;i<50;i++)
    	{
    		number[i]=(int)  (Math.random()*100);
    		list.add(Integer.toString(number[i]));
    		System.out.print(list.getItem(i)+",");   		
    	}
    	System.out.print("\n");
        
    	
    	System.out.print("Map中的数据为:");
    	for(int i=0;i<10;i++)
    	{
    		key[i]=-1;
    	}
    	for(int i=0;i<50;i++)
    	{
    		key[number[i]/10]=number[i]/10;
    	}
    	
    	HashMap<String, TreeSet<String>> hm=new HashMap<String, TreeSet<String>>();
    	String s=new String();
    	for(int j=0;j<50;j++)
    	{
    		if( hm.containsKey(Integer.toString(number[j]/10)) )         //查询是否有该key键的元素
    		{
    			
    		}
    		else
    		{
    			
    		}
    		
    	}
    	System.out.print(hm);
    }
}
