<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
<!-- <link href="" type="text/css" rel="stylesheet"> -->
</head>
<body>
<%
    if(session.getAttribute("name")==null){
%>
您尚未登录，请点击<a href="login.jsp">用户登录</a>进行登录
<%
    }
    else
    {
%>    	
欢迎<%=session.getAttribute("name") %>先生/小姐，您可以选择一下操作:<br>
<a href="select.jsp">列表显示界面</a><br>
<a href="insert.jsp">新增界面</a><br>
<a href="index.jsp" onclick="<%session.invalidate(); %>">退出登录</a>
<%
    }
%>
</body>
</html>
