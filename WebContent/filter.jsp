<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import = "com.code.*" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>验证信息</title>
</head>
<body>

<%
   request.setCharacterEncoding("utf-8");
   response.setCharacterEncoding("utf-8");
   
   String id = (String)request.getParameter("id");
   String name = request.getParameter("name");
   String password = request.getParameter("password");

   if(null==id||name==null||password==null||id.equals("")||name.equals("")||password.equals(""))
    {

	    response.sendRedirect("dengLu.html");
    }
    else
    {
    	jdbcConnection conn = new jdbcConnection();
    	  
       if(id.equals("1"))
        {
    	   String sql = "select * from food_person_information where 用户名='" +
                         name + "' and 密码='" + password + "';";
                         
            System.out.println(sql);
    	   
    	  try{
    		  if(conn.executeQuery(sql).next())
    		  {
    			   application.setAttribute("name",name);
    			   application.setAttribute("isLogin","1");
    		  }
    		  
    		 // request.getRequestDispatcher("comment.jsp?table_name=beef_comments").forward(request,response);
    		 response.sendRedirect("comment.jsp");
    		  
    	  }
    	  catch(Exception e)
    	  {
    		  e.printStackTrace();
    	  }
    
        
	   
        }
           else
	           if(id.equals("2"))
	            {
	        	   String sql = "select * from food_person_information where 用户名='" + name+"';";
	   			String sql1 = "insert into food_person_information values('" + name + "' ,'"+ password+"',now());";
	   			
	   			System.out.println(sql+sql1);
	   			
	   			try
	   			{
	   				if(conn.executeQuery(sql).next())
	   				{
	   					response.sendRedirect("zhuCe.html");
	   				}
	   				else
	   				{	
	   					if(1==conn.executeUpdate(sql1))
	   					{
	   						
	   						out.println("<b>注册成功！</b>");
	   						
	   					}
	   					else
	   					{
	   						out.println("<b>注册失败！</b>");
	   						out.println("<a href=\"zhuCe.html\">重新注册?</a>");
	   					}
	   					out.println("<a href=\"dengLu.html\">返回登录？</a>");
	   					
	   				}
	   				
	   				
	   			}
	   			catch(Exception e)
	   			{
	   				e.printStackTrace();
	   			}
	   			
	   			                                 //关闭数据库
	   			
	            }
       conn.close();

    }
%>
</body>
</html>