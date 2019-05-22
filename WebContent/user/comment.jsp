<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id = "now" class = "java.util.Date"/>

<link rel = "stylesheet" type = "text/css" href = "comment.css"/>
<head>
<title>评论</title>
</head>
<body>

<div >
   <a href = "<%=(String)application.getAttribute("history")%>" >返回</a>
</div>
<div class = "">
<form action = "<c:url value='/addCommentServlet' />"  method = "post">
 <table align = "center">
   <tr>
     <td>用户名：${SessionScope.name}</td>
   </tr>
   <tr>
     <td>评论：</td>
     <td><textarea  name = "content" cols = "20" rows = "5" ></textarea></td>
   </tr>
   <tr>
   <td><input type = "hidden" name = "day"  value = "<fmt:formatDate value="${now}" pattern="yyyy-MM-dd " />" ></td>
   </tr>
   <tr>
      <td><input type = "submit" value = "提交" ></td>
      <td><input type = "reset" value = "重置" ></td>
   </tr>
 </table>
</form>
</div>

<div>

</div>
</body>
</html>