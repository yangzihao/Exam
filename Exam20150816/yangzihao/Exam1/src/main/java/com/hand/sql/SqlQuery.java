package com.hand.sql;

import java.sql.*;

public class SqlQuery {
	private SqlQuery(){}
	//
	////////////////////////////登录查询语句//////////////////////////////////
	//
	public static ResultSet login(Connection conn,String name) throws Exception{
		String sql="SELECT * FROM customer WHERE first_name=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, name);
		ResultSet rs=ps.executeQuery();
		return rs;
		
	}
	//
	////////////////////////////电影查询语句//////////////////////////////////
	//
	public static ResultSet select(Connection conn) throws Exception{
		String sql="SELECT film_id,title,description,`name` FROM film,`language` WHERE film.language_id=`language`.language_id";
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
		String sql="DELETE FROM film WHERE film_id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, Integer.parseInt(line));
		int i=ps.executeUpdate();
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
		if(newLanguage=="English")
			newLanguage_id=1;
		else if(newLanguage=="Italian")
			newLanguage_id=2;
		else if(newLanguage=="Japanese")
			newLanguage_id=3;
		else if(newLanguage=="Mandarin")
			newLanguage_id=4;
		else if(newLanguage=="French")
			newLanguage_id=5;
		else if(newLanguage=="German")
			newLanguage_id=6;
		else {
			return false;
		}
			
		
		
		String sql="UPDATE film SET title=? WHERE film_id=?; "+
                   "UPDATE film SET description=? WHERE film_id=?; "+
                   "UPDATE film SET language_id=? WHERE film_id=?;";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, newTitle);
		ps.setInt(2, Integer.parseInt(line));
		ps.setString(3, newDescription);
		ps.setInt(4, Integer.parseInt(line));
		ps.setInt(5, newLanguage_id);
		ps.setInt(6, Integer.parseInt(line));
		int i= ps.executeUpdate();
		if(i>=0)
			return true;
		else
			return false;
			
	}

}
