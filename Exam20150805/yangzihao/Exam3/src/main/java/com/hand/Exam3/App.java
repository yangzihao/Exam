package com.hand.Exam3;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "请输入日期:" );
		Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int day=-1;
        int date=-1;
        int year=-1;
        int sum=0;
        String sYear=str.substring(0,4);
        String sDate=str.substring(5,7);
        String sDay=str.substring(8, 10);
        
        year=Integer.parseInt(sYear);
        date=Integer.parseInt(sDate);
        day=Integer.parseInt(sDay);
        
        sum+=day;
        if(year%4==0)
        {
        	if(date>2)
        	{
        		sum+=28+31;
        		if(date<8)
        		{
        		    for(int i=3;i<date;i++)
        		    {
        			    if(date%2==0)
        			    {
        			    	sum+=30;
        			    }
        			    else
        			    {
        			    	sum+=31;
        			    }
        		    }
        		}
        		else
        		{
        			for(int i=8;i<date;i++)
        		    {
        			    if(date%2==0)
        			    {
        			    	sum+=31;
        			    }
        			    else
        			    {
        			    	sum+=30;
        			    }
        		    }
        		}
        	}
        	else if(date==2)
        	{
        		sum+=31;
        	}
        	else
        	{
        		;
        	}
        	
        }
        else
        {
        	if(date>2)
        	{
        		sum+=29+31;
        		if(date<8)
        		{
        		    for(int i=3;i<date;i++)
        		    {
        			    if(date%2==0)
        			    {
        			    	sum+=30;
        			    }
        			    else
        			    {
        			    	sum+=31;
        			    }
        		    }
        		}
        		else
        		{
        			sum+=31+30+31+30+31;
        			for(int i=8;i<date;i++)
        		    {
        			    if(date%2==0)
        			    {
        			    	sum+=31;
        			    }
        			    else
        			    {
        			    	sum+=30;
        			    }
        		    }
        		}
        	}
        	else if(date==2)
        	{
        		sum+=31;
        	}
        	else
        	{
        		;
        	}
        }
     
        System.out.println( "你输入日期为当年的第:"+sum+"天\n" );
    }
}
