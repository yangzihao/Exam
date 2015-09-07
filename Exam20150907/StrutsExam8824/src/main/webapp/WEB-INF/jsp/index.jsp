<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index page</title>

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
        
        <div class="table" style="float: right; width: 80%; margin-top:60px; ">
            <div style="width: 100%; height:100px;">
                <h3>客户管理</h3><hr>
                <p style="float: left;">客户列表</p><a class="btn btn-primary" style="margin-left: 30%;" href="index.do">新建</a>
            </div>
            <table class="table table-striped table-bordered table-hover">
            <thead>
                <tr>
                    <th>thead标题</th>
                    <th>thead标题</th>
                    <th>thead标题</th>
                </tr>
            </thead>
            <tfoot>
                <tr>
                    <td>tfoot表尾</td>
                    <td>tfoot表尾</td>
                    <td>tfoot表尾</td>
                </tr>
            </tfoot>
            <tbody>
                <tr class="active">
                    <td>tbody表单元</td>
                    <td>tbody表单元</td>
                    <td>tbody表单元</td>
                </tr>
                <tr class="success">
                    <td>tbody表单元</td>
                    <td>tbody表单元</td>
                    <td>tbody表单元</td>
                </tr>
                <tr class="info">
                    <td>tbody表单元</td>
                    <td>tbody表单元</td>
                    <td>tbody表单元</td>
                </tr>
                <tr class="warning">
                    <td>tbody表单元</td>
                    <td>tbody表单元</td>
                    <td>tbody表单元</td>
                </tr>
                <tr class="danger">
                    <td>tbody表单元</td>
                    <td>tbody表单元</td>
                    <td>tbody表单元</td>
                </tr>
            </tbody>
        </table>
        </div>
        
    </div>
</body>
</html>