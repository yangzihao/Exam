<%@page import="javax.websocket.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>

<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<script src="js/jquery-2.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</head>
<body>
    <div class="container">
        <div class="header">
            <h3>8824 杨子豪</h3>
        </div>
        
        <div class="content">
            <form action="loginAction" method="post">
                <table>
                    <tr>
                        <th>电影租赁管理系统</th>
                    </tr>
                    <tr>
                        <td>用户名</td>
                        <td><input type="text" name="userName" id="userName"></td>
                    </tr>
                    <tr>
                        <td>密码</td>
                        <td><input type="password" name="password" id="password"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="登陆"></td>
                    </tr>
                </table>
            </form>
        </div>
        
        <div class="footer">
        </div>
    </div>
    
    
                    <div id="myModal" class="modal fade" role="dialog">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">
                                        <span>&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <h2>登录失败，请重新登录</h2>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">close</button>
                                </div>
                            </div>
                        </div>  
                    </div>
                    <%
                        int loginFlag=0; 
                        String f=new String();
                        f=(String)session.getAttribute("f");
                        if(f!=null)
                        {
                        	loginFlag=Integer.parseInt(f);
                        }
                    %>
                    <script type="text/javascript">
                        if(<%=loginFlag%>==1)
                            $("#myModal").modal("show");
                        else
                        	$("#myModal").modal("hide");
                    </script>
</body>
</html>