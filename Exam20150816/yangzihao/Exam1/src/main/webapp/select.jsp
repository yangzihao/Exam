<%@page import="com.hand.sql.SqlQuery"%>
<%@page import="com.hand.sql.MysqlConnection"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>select</title>

<%
    Connection conn;int count=0;
	conn = MysqlConnection.getConnection();
	ResultSet rs=SqlQuery.select(conn);
%>

</head>
<body>

<table style="width: 90%;height: auto;text-align: center;margin: auto;" border="1px">
    <tr>
        <td style="width: 1%">film_id</td>
        <td style="width: 10%">title</td>
        <td style="width: 40%">description</td>
        <td style="width: 5%">language</td>
        <td style="width: 10%">operator</td>
    </tr>
    <%while(rs.next()){%>
    <tr>
        <td><%=rs.getInt(1) %></td>
        <td><%=rs.getString(2) %></td>
        <td><%=rs.getString(3) %></td>
        <td><%=rs.getString(4) %></td>
        <td>
            <a href="delete.jsp?line=<%=rs.getInt(1)%>">删除</a>
            /
            <a href="update.jsp?line=<%=rs.getInt(1)%>">编辑</a>
        </td>
        
    </tr>
    <%} %>
</table>
</body>
</html>