package com.code.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.code.user.doamin.LoginOrRegistStatus;
import com.code.user.doamin.User;
import com.code.user.service.UserService;

import cn.itcast.commons.CommonUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		UserService userService = new UserService();
		
		User user = CommonUtils.toBean(request.getParameterMap(), User.class);
		
		int sign = userService.login(user);
		
		String message = LoginOrRegistStatus.getMessage(sign);
		
		request.getSession().setAttribute("loginMessage",message);
		
		if(message.equals("登录成功!"))
		{
			request.getSession().setAttribute("username",user.getName());
			//request.getRequestDispatcher("/static/zhuYe.html").forward(request,response);
			response.sendRedirect("static/zhuYe.html");
			
		}
		else
			request.getRequestDispatcher("/user/login.jsp").forward(request,response);
			//response.sendRedirect("user/login.jsp");
		
			
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
}
