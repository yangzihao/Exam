<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.hand.sql.SqlQuery"%>
<%@page import="java.sql.*"%>
<%@page import="com.hand.sql.MysqlConnection"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert</title>

<%
    Connection conn;
	conn = MysqlConnection.getConnection();
	String line=request.getParameter("line");
	ResultSet rs=SqlQuery.selectLanguage(conn);
%>

</head>
<body>
<form action="insertAction" method="post">
        <table style="width: 90%;height: auto;text-align: center;margin: auto;" border="1px">
    <tr>
        <td style="width: 10%">title</td>
        <td style="width: 40%">description</td>
        <td style="width: 5%">language</td>
        <td style="width: 12%">operator</td>
    </tr>
    <tr>
        <td><input type="text" name="title"></td>
        <td><input type="text" name="description" size="70%"></td>
        <td>
            <select name="language">
                <option value="0" selected="selected">请选择</option>
                <%while(rs.next()){ %>
                <option value="<%=rs.getInt(1) %>"><%=rs.getString(2) %></option>   
                <%} %>   
            </select>
        </td>
        <td><input type="submit" value="插入"></td> 
    </tr>
</table>
    </form>
</body>
</html>