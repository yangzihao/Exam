<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新建</title>

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
            </div>
            
            <div class="main">
                <h2>创建Customer</h2>
                    <form action="insertAction" method="post" role="form" style="width:60%;">
                        <div class="form-group has-feedback">
                            <label>First Name*</label>
                            <input type="text" name="FName" class="form-control" placeholder="Enter your First Name">
                            <label>Last Name*</label>
                            <input type="text" name="LName" class="form-control" placeholder="Enter your Last Name">
                            <label>Email</label>
                            <input type="email" name="Email" class="form-control" placeholder="Enter your email">
                            <label>Address*</label>
                            <input type="text" name="Address" class="form-control" placeholder="Enter your Address">
                                            
                            <input type="submit" class="btn btn-primary" value="新建">
                            <input type="reset" class="btn btn-default" value="取消">
                        </div>
                   </form>
            </div>
        </div>
        
        <div class="footer">
        </div>
    
    </div>
</body>
</html>