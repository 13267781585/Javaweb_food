<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import = "java.util.*,com.code.Message" %>

<%
   request.setCharacterEncoding("utf-8");
   response.setCharacterEncoding("utf-8");
   
   String isLogin = (String)application.getAttribute("isLogin");
   
   String history = (String)request.getParameter("history");
   if(history!=null)
   {
      application.setAttribute("history",history);
   }
   System.out.println(history);
   
   String table_name = (String)request.getParameter("table_name");
   if(table_name!=null)
   {
      application.setAttribute("table_name",table_name);
   }
   System.out.println(table_name);
   
   if(isLogin==null||!isLogin.equals("1"))
   {
	   response.sendRedirect("dengLu.html");
   }
%>

<jsp:useBean id = "message" class = "com.code.Message" scope = "page">
<jsp:setProperty name = "message" property = "*"/>
</jsp:useBean>

<jsp:useBean id = "messageSum" class = "com.code.MessageSum" scope = "page"/>

<link rel = "stylesheet" type = "text/css" href = "comment.css"/>
<head>
<title>评论</title>
</head>
<body>

<div >
   <a href = "<%=(String)application.getAttribute("history")%>" >返回</a>
</div>
<div class = "">
<form action = "comment.jsp"  method = "post">
 <table align = "center">
   <tr>
     <td>用户名：<%=application.getAttribute("name")%></td>
   </tr>
   <tr>
     <td>评论：</td>
     <td><textarea name = "content" cols = "20" rows = "5" ></textarea></td>
   </tr>
   <tr>
      <td><input type = "submit" value = "提交" ></td>
      <td><input type = "reset" value = "重置" ></td>
   </tr>
 </table>
</form>
</div>

<div>
<% 
   String table_name1 = (String)application.getAttribute("table_name");
   String content = (String)request.getParameter("content");
   String name = (String)application.getAttribute("name");
   
   if(null!=table_name1)
   {
	  if(!table_name1.equals(""))
	  {
         messageSum.setTable_name(table_name1);      //设置表名
      
         if(null!=content)
         {
            message.setName(name);                     //设置用户名
            messageSum.addMessage(message);
            System.out.println("评论成功!");
         }
	  }
   }
   else
   {
	 System.out.println("没有接收到表名!");

   }
  
   Collection<Message> messages = messageSum.getMessages();
   Iterator<Message> it = messages.iterator();
   
   while(it.hasNext())
   {
	   Message tempt = (Message)it.next();
  
%>

<table>
  <tr>
    <td><%=tempt.getName() %></td>
    <td><%=tempt.getDay() %></td>
  </tr>
  
  <tr>
    <td><%=tempt.getContent() %></td>
  </tr>
</table>
<%
   out.println("<hr>");
   }
%>
</div>
</body>
</html>