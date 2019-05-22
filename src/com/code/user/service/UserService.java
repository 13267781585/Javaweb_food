package com.code.user.service;

import java.sql.ResultSet;
import java.util.Vector;

import com.code.user.dao.UserDao;
import com.code.user.doamin.Comment;
import com.code.user.doamin.User;

public class UserService {
	private UserDao userDao = new UserDao();
	private int sign = 0;
	
	/*
	 * 用sign指示登录注册的状态
	 * 0.没有该用户
	 * 1.密码错误
	 * 2.登录成功
	 * 3.该用户已被注册
	 * 4.注册失败
	 * 5.注册成功
	 */
	
	//登录验证
	public int login(User loginUser)
	{
		User user = userDao.findUser(loginUser.getName());
		
		if(user!=null&&loginUser!=null) {
			if(loginUser.getPassword().equals(user.getPassword()))
				sign = 2;
			else
				sign = 1;
			
		}
		else {
			sign = 0;
		}
		return sign;
	}
	
	//注册验证
	
	public int regist(User registUser)
	{
		User user = userDao.findUser(registUser.getName());
		
		if(user!=null) {
			sign = 3;
			
		}
		else {
			
			if(userDao.addUser(registUser))
			{
				sign = 4;
				
			}
			else
				sign = 5;
		}
		return sign;
	}
	
	

}