package com.hand.Exam1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	System.out.print("请输入country ID：");
    	Scanner sc=new Scanner(System.in);
    	String country_id=sc.next();
    	String country_name="";
    	int city_id=0;
    	String city_name="";
    	
    	//获取国家名
    	String sql="SELECT * FROM country where country_id="+country_id;
    	Class.forName("com.mysql.jdbc.Driver");//装载驱动程序
    	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","");
    	Statement st=conn.createStatement();      //无参数表单

    	ResultSet rs=st.executeQuery(sql);//执行select语句并返回结果集
    	//ResultSetMetaData data=rs.getMetaData();
    	
    	while(rs.next()){
    		country_name=rs.getString(2);
    	}
    	System.out.println("Country "+country_name+" 的城市->");
    	
    	//获取城市
    	String sql1="SELECT * FROM city where country_id="+country_id;
    	ResultSet rs1=st.executeQuery(sql1);//执行select语句并返回结果集
    	//ResultSetMetaData data=rs.getMetaData();
    	
    	System.out.println("城市ID|城市名称");
    	while(rs1.next()){
    		city_id=rs1.getInt(1);
    		city_name=rs1.getString(2);
    		System.out.println(city_id+"   |"+city_name);
    	}
    }
}
