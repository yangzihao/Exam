package com.hand.Exam2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	System.out.print("请输入Customer ID：");
    	Scanner sc=new Scanner(System.in);
    	String customer_id=sc.next();
    	String customer_name="";
    	int film_id=0;
    	String film_name="";
    	String rental_date="";
    	
    	
    	//获取用户名
    	String sql="SELECT * FROM customer where customer_id="+customer_id;
    	Class.forName("com.mysql.jdbc.Driver");//装载驱动程序
    	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","");
    	Statement st=conn.createStatement();      //无参数表单

    	ResultSet rs=st.executeQuery(sql);//执行select语句并返回结果集
    	//ResultSetMetaData data=rs.getMetaData();
    	
    	while(rs.next()){
    		customer_name=rs.getString(3)+"."+rs.getString(4);
    	}
    	System.out.println(customer_name+" 租用的Film->");
    	
    	//获取Film ID、Film名称、租用时间
    	String sql1="SELECT film.film_id,film.title,rental.rental_date "
                   +"FROM film,rental,inventory "
                   +"WHERE rental.customer_id=rental.customer_id "
                   +"AND rental.inventory_id=inventory.inventory_id "
                   +"AND inventory.film_id=film.film_id "
                   +"AND rental.customer_id="+customer_id;
    	ResultSet rs1=st.executeQuery(sql1);//执行select语句并返回结果集
    	//ResultSetMetaData data=rs.getMetaData();
    	
    	System.out.println(" Film ID | Film名称 | 租用时间 ");
    	while(rs1.next()){
    		film_id=rs1.getInt(1);
    		film_name=rs1.getString(2);
    		rental_date=rs1.getString(3);
    		System.out.println(film_id+" | "+film_name+" | "+rental_date);
    	}
    }
}
