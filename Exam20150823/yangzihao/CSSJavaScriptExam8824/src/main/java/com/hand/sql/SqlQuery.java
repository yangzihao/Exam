package com.hand.sql;

import java.sql.*;

public class SqlQuery {
	private SqlQuery(){}
	//
	////////////////////////////登录查询语句//////////////////////////////////
	//
	public static ResultSet login(Connection conn,String userName,String password) throws Exception{
		String sql="SELECT * FROM customer WHERE first_name=? AND last_name=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, userName);
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery();
		return rs;
		
	}
	//
	////////////////////////////客户查询语句//////////////////////////////////
	//
	public static ResultSet select(Connection conn) throws Exception{
		String sql="SELECT customer.first_name,customer.last_name,address.address,customer.email,customer.customer_id,customer.last_update FROM customer,address WHERE customer.address_id=address.address_id";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		return rs;	
	}
	public static ResultSet selectWithParam(Connection conn,String line) throws Exception{
		String sql="SELECT film_id,title,description,`name` FROM film,`language` WHERE film.language_id=`language`.language_id AND film_id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, Integer.parseInt(line));
		ResultSet rs=ps.executeQuery();
		return rs;	
	}
	//
	////////////////////////////电影删除语句//////////////////////////////////
	//
	public static boolean delete(Connection conn,String line) throws Exception{
		String sql="SET FOREIGN_KEY_CHECKS = 0;";
		PreparedStatement ps=conn.prepareStatement(sql);
		int i=ps.executeUpdate();

		sql="DELETE FROM film WHERE film_id=?;";
		ps=conn.prepareStatement(sql);
		ps.setInt(1, Integer.parseInt(line));
		i=ps.executeUpdate();
		if(i>=0)
			return true;
		else
			return false;
			
	}
	//
	////////////////////////////电影更新语句//////////////////////////////////
	//
	public static boolean update(Connection conn,String line,String newTitle,String newDescription,String newLanguage) throws Exception{
		int newLanguage_id=0;
		newLanguage=newLanguage.trim();
		if(newLanguage.equals("English"))
			newLanguage_id=1;
		else if(newLanguage.equals("Italian"))
			newLanguage_id=2;
		else if(newLanguage.equals("Japanese"))
			newLanguage_id=3;
		else if(newLanguage.equals("Mandarin"))
			newLanguage_id=4;
		else if(newLanguage.equals("French"))
			newLanguage_id=5;
		else if(newLanguage.equals("German"))
			newLanguage_id=6;
		else {
			System.out.println(newLanguage_id);
			return false;
		}
			
		
		int i=0;
		String sql="UPDATE film SET title=? WHERE film_id=?; "; 
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, newTitle);
		ps.setInt(2, Integer.parseInt(line));
		i+= ps.executeUpdate();
		
		sql="UPDATE film SET description=? WHERE film_id=?; ";
		ps=conn.prepareStatement(sql);
		ps.setString(1, newDescription);
		ps.setInt(2, Integer.parseInt(line));
		i+= ps.executeUpdate();
		
		sql="UPDATE film SET language_id=? WHERE film_id=?;";
		ps=conn.prepareStatement(sql);
		ps.setInt(1, newLanguage_id);
		ps.setInt(2, Integer.parseInt(line));
		i+= ps.executeUpdate();
			return true;
	}
	//
	////////////////////////////新建用户语句//////////////////////////////////
	//
	public static boolean insert(Connection conn,String FName,String LName,String Email,String Address) throws Exception{
		String sql1="SELECT address_id FROM address WHERE address=?";
		PreparedStatement ps1=conn.prepareStatement(sql1);
		ps1.setString(1, Address);
		ResultSet rs1=ps1.executeQuery();
		int Address_id=0;
		while(rs1.next()){
			Address_id=rs1.getInt(1);
		}
		
		String sql2="SET FOREIGN_KEY_CHECKS = 0;";
		PreparedStatement ps2=conn.prepareStatement(sql2);
		int j=ps2.executeUpdate();
				
		String sql="INSERT INTO customer(first_name,last_name,email,address_id) VALUES(?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, FName);
		ps.setString(2, LName);
		ps.setString(3, Email);
		ps.setInt(4, Address_id);
		int i=ps.executeUpdate();

		if(i>=0)
			return true;
		else
			return false;		
	}
}
