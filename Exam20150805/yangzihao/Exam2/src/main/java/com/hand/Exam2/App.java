package com.hand.Exam2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.print("请输入工资:");
			BufferedReader strin=new BufferedReader(new InputStreamReader(System.in));  
            String str=new String();
			try {
				str = strin.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		double gongzi=Integer.parseInt(str);
		double zhengshui=gongzi-3500;
		if(zhengshui>0 && zhengshui<=1500)
		{
			zhengshui=zhengshui*0.03;
		}
		else if(zhengshui>1500 && zhengshui<=4500)
		{
			zhengshui=zhengshui*0.1;
		}
		else if(zhengshui>4500 && zhengshui<=9000)
		{
			zhengshui=zhengshui*0.2;
		}
		else if(zhengshui>9000 && zhengshui<=35000)
		{
			zhengshui=zhengshui*0.25;
		}
		else if(zhengshui>35000 && zhengshui<=55000)
		{
			zhengshui=zhengshui*0.3;
		}
		else if(zhengshui>55000 && zhengshui<=80000)
		{
			zhengshui=zhengshui*0.35;
		}
		else if(zhengshui>80000)
		{
			zhengshui=zhengshui*0.45;
		}
		else
		{
			System.out.print("出入错误\n");
		}
		
		System.out.print("所需要缴纳的税费为:"+zhengshui);
    }
}
