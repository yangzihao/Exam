<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login page</title>

<!-- bootstrap link -->
<link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="css/login.css" rel="stylesheet" type="text/css">
<script src="Bootstrap/js/jquery-2.1.1.min.js"></script>
<script src="Bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
    <div class="container">
        <div class="navbar-header">
            <h2>8824   杨子豪</h2>
        </div>
    
        <div id="myModal" class="modal fade" role="dialog" style="margin-top: 100px;">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h3 class="modal-title">电影租赁管理系统</h3>
                    </div>
                    <div class="modal-body">
                       <form action="Login_login.action" method="post" role="form">
                          <div class="form-group has-feedback">
                            <label>用户名</label>
                            <input type="text" name="username" class="form-control" placeholder="Enter your First Name">
                            <label>密码</label>
                            <input type="password" name="password" class="form-control" placeholder="Enter your Last Name">
                            <input type="submit" class="btn btn-primary" value="登陆">
                          </div>
                       </form>
                    </div>
                </div>
            </div>  
        </div>
        
        
    </div>
    <script type="text/javascript">
    $("#myModal").modal({
		backdrop:false
	})
        $("#myModal").modal("show");
    </script>
</body>
</html>