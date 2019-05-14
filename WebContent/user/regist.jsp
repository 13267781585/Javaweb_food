<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<c:url value = '/zhuCe.css' />" />
<title>新用户注册</title>
</head>
<body>
<div id = "main">
<form action="<url: value = '/RegistServlet' />"  method="post">
  <table align="center">
    <tr>
     <td>用户名:</td>
     <td><input type="text" name="name" placeholder = "5-10个任意字符"></td>
    </tr>
    <tr>
     <td>密码：</td>
     <td><input type="password" name="password" placeholder = "5-10个任意字符"></td> 
     </tr>
     <tr>
      <td>${registMessage}</td>
      </tr>
    
    <tr>
     <td><input type="submit" value="提交"></td>
     <td><input type="reset"  value="重置"></td>
     <td><a href="dengLu.html">已有账号!返回登录?</a></td>
    </tr> 
  </table>

</form>
</div>
</body>
</html>