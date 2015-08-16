package com.hand.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.hand.sql.MysqlConnection;
import com.hand.sql.SqlQuery;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
		String line=request.getParameter("film_id");
		String newTitle=request.getParameter("title");
		String newDescription=request.getParameter("description");
		String newLanguage=request.getParameter("language");
		System.out.println(line+"      "+newTitle+"      "+newDescription+"      "+newLanguage);
		Connection conn;
		try {
			conn = MysqlConnection.getConnection();
			if(SqlQuery.update(conn, line, newTitle, newDescription, newLanguage)){
				JOptionPane.showMessageDialog(null, "删除成功");
				response.sendRedirect("select.jsp");
			}
			else{
				JOptionPane.showMessageDialog(null, "删除失败");
				response.sendRedirect("select.jsp");
			}
			
			
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
