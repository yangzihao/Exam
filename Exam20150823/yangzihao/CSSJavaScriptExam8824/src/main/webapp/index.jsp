<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.hand.sql.SqlQuery"%>
<%@page import="com.hand.sql.MysqlConnection"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>

<%
    Connection conn;int count=0;
	conn = MysqlConnection.getConnection();
	ResultSet rs=SqlQuery.select(conn);
	
	int nowPage=0;
	String np=new String();
	if( (np=request.getParameter("nowPage"))==null )
	{
		nowPage=1;
	}
	else
	{
		nowPage=Integer.parseInt(np);
	}
%>

<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<script src="js/jquery-2.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</head>
<body>
    <div class="container">
        <div class="header">
            <h3>8824 杨子豪</h3>
            <a href="exit.jsp">退出登录</a>
        </div>
        
        <div class="content">
            <div class="nav">
                <a href="index.jsp">Customer管理</a>
                <a href="FilmIndex.jsp">Film管理</a>
            </div>
            
            
            <div class="main">
                <div class="showCustomer">
                    <h4>客户列表</h4>
                    <a href="insert.jsp" class="btn btn-primary">新建</a>
                    
                    
                    <div id="myModal" class="modal fade" role="dialog">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">
                                        <span>&times;</span>
                                    </button>
                                    <h3 class="modal-title">编辑</h3>
                                </div>
                                <div class="modal-body">
                                    <form action="updateAction" method="post" role="form" style="width:60%;">
                                        <div class="form-group has-feedback">
                                            <label>First Name*</label>
                                            <input type="text" name="FName" class="form-control" placeholder="Enter your First Name">
                                            <label>Last Name*</label>
                                            <input type="text" name="LName" class="form-control" placeholder="Enter your Last Name">
                                            <label>Email</label>
                                            <input type="email" name="Email" class="form-control" placeholder="Enter your email">
                                            <label>Address*</label>
                                            <input type="text" name="Address" class="form-control" placeholder="Enter your Adress">
                                            
                                            <input type="submit" class="btn btn-primary" value=确认>
                                            <input type="reset" class="btn btn-default" value="取消">
                                        </div>
                                    </form>
                                </div>
                                <div class="modal-footer" >
                                    <button type="button" class="btn btn-default" data-dismiss="modal">close</button>
                                </div>
                            </div>
                        </div>  
                    </div>
                    
                        
                    <table class="table table-striped table-bordered table-hover">
                      <thead>
                        <tr>
                            <td>操作</td>
                            <td>Fast Name</td>
                            <td>Last Name</td>
                            <td>Address</td>
                            <td>Email</td>
                            <td>CustomerId</td>
                            <td>LastUpdate</td>
                        </tr>
                      </thead>
                        <%
                            for(int i=1;i<=(nowPage-1)*10;i++){rs.next();} 
                            int line_count=0;
                        %>
                        <%while(rs.next() && line_count<10){%>
                      <tbody>
                        <tr>
                            <td>
                                <a href="" data-toggle="modal" data-target="#myModal" data-whatever="text from button">编辑</a>
                                |
                                <a href="delete.jsp?line=<%=rs.getInt(5)%>">删除</a>
                            </td>
                            <td><%=rs.getString(1) %></td>
                            <td><%=rs.getString(2) %></td>
                            <td><%=rs.getString(3) %></td>
                            <td><%=rs.getString(4) %></td>
                            <td><%=rs.getInt(5) %></td>
                            <td><%=rs.getString(6) %></td>
                        </tr>
                      </tbody>
                        <%line_count++;} %>
                    </table>
                    
                    <div class="btn-toolbar">
                        <div class="btn-group">
                          <%
                              rs=SqlQuery.select(conn);
                              int all_line=0;
                              int sum_page=0;
                      	      while( rs.next() ) {all_line++;}
                      	      if(all_line%10!=0)
                         	 {
                      		    sum_page=all_line/10+1;
                      	     }
                      	     else
                         	 {
                      		     sum_page=all_line/10;
                      	     }
                      	     rs=SqlQuery.select(conn);
                          %>  
                          <%for(int i=1;i<=sum_page;i++){ %>
                          <a href="index.jsp?nowPage=<%=i %>" type="button"
                             class="btn btn-default <%if(i==nowPage){%>  <%="active" %>  <%}%>  "><%=i %></a>
                          <%} %>
                        </div>
                    </div>
                        
                </div>
            </div>
        </div>
        
        <div class="footer">
        </div>
    </div>
    
    <script>
        $("#myModal").modal({
	    	backdrop:false
	    })
	    $("#myModal").modal("hide")
	</script>
</body>
</html>