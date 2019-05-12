package com.code.user.doamin;


/*
 * 用sign指示登录注册的状态
 * 0.没有该用户
 * 1.密码错误
 * 2.登录成功
 * 3.该用户已被注册
 * 4.注册失败
 * 5.注册成功
 */

public class LoginOrRegistStatus {
	private static String message;
	
	public static String getMessage(int mes) {
		switch(mes)
		{
		case 0:{message = "没有该用户!";break;}
		case 1:{message = "密码错误!";break;}
		case 2:{message = "登录成功!";break;}
		case 3:{message = "该用户已被注册!";break;}
		case 4:{message = "注册失败!";break;}
		case 5:{message = "注册成功!";break;}
		
		}
		
		return message;
	}

}
