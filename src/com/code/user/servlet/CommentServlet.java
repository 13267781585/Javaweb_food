package com.code.user.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.code.user.doamin.Comment;
import com.code.user.service.CommentService;

@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String username = (String)request.getSession().getAttribute("username");
		System.out.println(username);
		if(username==null)
		{
			System.out.println("未登录！");
			request.getRequestDispatcher("/user/login.jsp").forward(request,response);
			return;
		}
		else
		{
			System.out.println(username+"已登录!");
			
		}
		
		String table_name = request.getParameter("table_name");
		String method = request.getParameter("method");
		
		CommentService commentService = new CommentService();
		
		if(method!=null&&method.equals("add"))
		{
		Comment comment = new Comment();
		comment.setName(username);
		comment.setDay(request.getParameter("day"));
		comment.setContent(request.getParameter("content"));
		
		commentService.addComment(comment, table_name);
		
		}
		
        Vector<Comment> vector = commentService.findComments(table_name);
		
		request.setAttribute("comments",vector);

		request.getRequestDispatcher("user/comment.jsp").forward(request,response);
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

}
