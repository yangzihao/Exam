package com.hand.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.hand.sql.MysqlConnection;
import com.hand.sql.SqlQuery;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName=req.getParameter("userName");
		String password=req.getParameter("password");
		try {
			
			
			if(loginCheck(userName,password)){
				req.getSession().setAttribute("userName", userName);
				req.getSession().setAttribute("f", null);
				resp.sendRedirect("index.jsp");
			}
			else{
				//JOptionPane.showMessageDialog(null, "登录失败");
				req.getSession().setAttribute("f", "1");
				resp.sendRedirect("login.jsp");
			}
			
			
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private boolean loginCheck(String userName,String password) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=MysqlConnection.getConnection();
		ResultSet rs=SqlQuery.login(conn,userName,password);
		if(rs.next())
			return true;
		else
			return false;
	}
	
	
	

}
