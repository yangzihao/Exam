<%@page import="com.hand.sql.SqlQuery"%>
<%@page import="java.sql.*"%>
<%@page import="com.hand.sql.MysqlConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>delete</title>

<%
    Connection conn;int count=0;
	conn = MysqlConnection.getConnection();
	String line=request.getParameter("line");
	ResultSet rs=SqlQuery.selectWithParam(conn,line);
	session.setAttribute("line", line);
%>


</head>
<body>
    <form action="deleteAction" method="post">
        <table style="width: 90%;height: auto;text-align: center;margin: auto;" border="1px">
    <tr>
        <td style="width: 1%">film_id</td>
        <td style="width: 10%">title</td>
        <td style="width: 40%">description</td>
        <td style="width: 5%">language</td>
        <td style="width: 12%">operator</td>
    </tr>
    <%while(rs.next()){ %>
    <tr>
        <td><%=rs.getInt(1) %></td>
        <td><%=rs.getString(2) %></td>
        <td><%=rs.getString(3) %></td>
        <td><%=rs.getString(4) %></td>
        <td><input type="submit" value="删除"></td> 
    </tr>
    <%} %>
</table>
    </form>
</body>
</html>