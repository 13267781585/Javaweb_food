package com.code.user.dao;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.code.user.doamin.User;

public class UserDao {
	private jdbcConnection conn = new jdbcConnection();
	
	//查找是否存在该用户，有返回该用户信息，没有则返回null
	
	public User findUser(String name) {
		String sql = "select * from food_person_information where 用户名 = '"+name+"';";
		System.out.println(sql);
		
		ResultSet set = conn.executeQuery(sql);
		if(set!=null) {
		try {
			if(set.next()) {
				User tempt = new User();
				tempt.setName(name);
				tempt.setPassword(set.getString("密码"));
				
				conn.close();
				
				return tempt;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
		else
			System.out.println("set为null!");
		
		conn.close();
		
		return null;
		
	}
	
	//添加用户
	public boolean add(User user)
	{
		String name = user.getName();
		String password = user.getPassword();
		
		String sql = "insert into food_person_information values('"+name+"','"+password+"',now());";
		
		System.out.println(sql);
		
		int resultRow = conn.executeUpdate(sql);
		
		conn.close();
		
		if(resultRow==0)
			return true;
		return false;
		
	}

}