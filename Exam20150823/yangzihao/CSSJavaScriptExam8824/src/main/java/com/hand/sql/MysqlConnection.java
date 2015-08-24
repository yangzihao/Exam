package com.hand.sql;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class MysqlConnection {
	
	private static String driver;
	private static String dburl;
	private static String user;
	private static String password;
	
	public static Connection getConnection() throws Exception{
		
		Properties prop=new Properties();
		InputStream in=MysqlConnection.class.getClassLoader()
				.getResourceAsStream("com/hand/dbconfig.properties");
		prop.load(in);
		driver=prop.getProperty("driver");
	    dburl=prop.getProperty("dburl");
	    user=prop.getProperty("user");
	    password=prop.getProperty("password");
	    Class.forName(driver);//装载驱动程序
	  	Connection conn=DriverManager.getConnection(dburl,user,password);
	    
		//Class.forName("com.mysql.jdbc.Driver");//装载驱动程序
		//Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","");
		return conn;
	}
}
