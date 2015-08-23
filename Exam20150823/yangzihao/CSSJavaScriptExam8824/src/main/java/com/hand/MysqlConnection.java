package com.hand;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlConnection {
	private MysqlConnection(){
		
	}
	public static Connection getConnection() throws Exception{
		//Properties prop =new Properties();//新建Properties对象
	   // InputStream in=ConnectionFactory.class.getClassLoader().getResourceAsStream("dbconfig.properties");
	  //  prop.load(in);
	   // String driver=prop.getProperty("driver");
	   // String dburl=prop.getProperty("dburl");
	    //String user=prop.getProperty("user");
	    //String password=prop.getProperty("password");
	    //Class.forName(driver);//装载驱动程序
	  	//Connection conn=DriverManager.getConnection(dburl,user,password);
	    
		Class.forName("com.mysql.jdbc.Driver");//装载驱动程序
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","");
		return conn;
	}
}
