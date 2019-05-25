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


@WebServlet("/ShowCommentServlet")
public class ShowCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String table_name = request.getParameter("table_name");
		
		CommentService commentService = new CommentService();
		
		Vector<Comment> vector = commentService.findComments(table_name);
		
		request.getSession().setAttribute("coments",vector);
		
		response.sendRedirect("/书写饮食/user/comment.jsp?table_name="+table_name);
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	

}
