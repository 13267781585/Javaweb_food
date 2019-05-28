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


@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		UserService userService = new UserService();
		
		User user = CommonUtils.toBean(request.getParameterMap(), User.class);
		
		int sign = userService.regist(user);
		
		String message = LoginOrRegistStatus.getMessage(sign);
		request.getSession().setAttribute("registMessage", message);
		
		if(message.equals("注册成功!"))
		{
			request.getSession().setAttribute("uesrname", user.getName());
			//request.getRequestDispatcher("/zhuYe.html").forward(request,response);
			response.sendRedirect("static/zhuYe.html");
		}
		else 
			//request.getRequestDispatcher("/zhuCe.html").forward(request, response);
			response.sendRedirect("user/regist.jsp");

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

}
