<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel = "stylesheet" type = "text/css" href = "<c:url value = '/dengLu.css'/> " />
<title>登录</title>
</head>
<body>
<div id = "main">
<form  action="<c:url value = '/LoginServlet' /> method="post">
  <table align="center">
  <tr>
      <td>用户名：</td>
      <td><input type = "text" name = "name"></td>
   </tr>
   
   <tr>
       <td>密码：</td>
       <td><input type = "password" name = "password"></td>
   </tr>
  <tr>
  <td>${loginMessage}</td>
  </tr>
  <tr>
    <td><input type = "submit" value = "登录"></td>
    <td><input type = "reset" value = "重置"></td>
    <td><a href="zhuCe.html">无账号？注册!</a>
  </tr>
  </table>
</form>
</div>

</body>
</html>