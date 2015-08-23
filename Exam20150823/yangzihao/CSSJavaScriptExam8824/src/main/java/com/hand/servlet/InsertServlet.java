package com.hand.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.hand.MysqlConnection;
import com.hand.SqlQuery;

/**
 * Servlet implementation class insertServlet
 */
@WebServlet("/insertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String FName=request.getParameter("FName");
		String LName=request.getParameter("LName");
		String Email=request.getParameter("Email");
		String Address=request.getParameter("Address");
		System.out.println(FName+"   "+LName+"    "+Email+"    "+Address);
		Connection conn;
		try {
			
			conn = MysqlConnection.getConnection();
			if(SqlQuery.insert(conn,FName,LName,Email,Address)){
				JOptionPane.showMessageDialog(null, "插入成功");
				response.sendRedirect("index.jsp");
			}
			else{
				JOptionPane.showMessageDialog(null, "插入失败");
				response.sendRedirect("index.jsp");
			}
			
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
