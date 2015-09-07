<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新建</title>

<link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<script src="Bootstrap/js/jquery-2.1.1.min.js"></script>
<script src="Bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
    
    <div class="container" style="width:90%; margin:auto;">
    
        <div class="navbar navbar-fixed-top navbar-default" role="navigation" style="width:88%; margin:auto;height: 50px;">
            <h2 style="margin-left: 20px; margin-top: 10px;">8824   杨子豪
                <a class="navbar-brand navbar-right" href="exit.jsp" style="margin-right: 20px; margin-top:-5px;">exit</a>
            </h2>
        </div>
        
        <div class="nav-left" style="float:left; margin-top:60px; width:20%;height:100%;">
            <ul class="list-group">
                <li class="list-group-item"><a href="index.do">Customer管理</a></li>
                <li class="list-group-item"><a href="FilmIndex.do">film设置</a></li>
            </ul>
        </div>
        
        <div class="form" style="float: right; width: 80%; margin-top:60px;">
            <form action="CustomerManager_insert.action" method="post" role="form" style="width:60%;">
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
</body>
</html>