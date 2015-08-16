package com.hand.Exam1;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int start=101;
        int end=200;
        int count=0;
        String s=new String();
        for(int i=start;i<=end;i++)
        {
            int flag=0;
        	for(int j=2;j<i;j++)
        	{
        		if( (i%j)==0 )
        		{
        			flag=1;
        			break;
        		}
        	}
        	if(flag==0)
        	{
        		s=s+i+",";
    			count++;
        	}
        }
        
        System.out.print("101-200之间有"+count+"个素数，分别是:"+s);
    }
}
