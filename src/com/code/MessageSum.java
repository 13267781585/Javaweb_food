package com.code;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;


 //针对不同的子页面，不同的数据表如何处理

public class MessageSum 
{
	private String table_name;
	private Message message;
	private jdbcConnection conn = new jdbcConnection();
	
	public void setTable_name(String table_name)
	{
		this.table_name = table_name;
	}
	
	public String getTable_name()
	{
		return this.table_name;
	}
	
	public void setMessage(Message message)
	{
		this.message = message;
	}
	
	public Message getMessage()
	{
		return this.message;
	}
	
	//设置message和更新数据库操作
	public void addMessage(Message message)
	{
		this.setMessage(message);
		
		String sql = "insert into " + table_name + " values('" + message.getName() + "',now(),'" + message.getContent() + "');";
		
		System.out.println(sql);
		
		if(conn.executeUpdate(sql)==1)
		{
			System.out.println("数据库插入评论成功!");
		}
		else
		{
			System.out.println("数据库插入数据失败!");
		}
		
		
	}
	
	
	//搜索数据库的数据，返回一个集合
	public Collection<Message> getMessages()
	{
		Collection<Message> set = new  ArrayList<Message>();
		String sql = "select * from " + table_name + " order by 日期 desc;";
		
		System.out.println(sql);
		
		ResultSet result = conn.executeQuery(sql);
		
		try {
			
			if(result!=null)
			{
			while(result.next())
			{
				Message tempt = new Message();
				
				tempt.setName(result.getString("用户名"));
				tempt.setDay(result.getString("日期"));
				tempt.setContent(result.getString("评论"));
				
				set.add(tempt);
				
			}
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return set;
	}

	
	
}
