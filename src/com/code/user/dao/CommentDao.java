package com.code.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.code.user.doamin.Comment;

public class CommentDao {
	private jdbcConnection conn = new jdbcConnection();
	
	//添加评论
	
		public boolean addComment(Comment comment,String table_name)
		{
			String name = comment.getName();
			String day = comment.getDay();
			String content = comment.getContent();
			
			String sql = "insert into "+table_name+"values('"+name+"','"+day+"','"+content+"');";
			
			System.out.println(sql);
			
			int resultRow = conn.executeUpdate(sql);
			
			conn.close();
			
			if(resultRow==0)
				return true;
			return false;
			
		}
		
		//查找所有评论
			public Vector<Comment> findComment(String table_name)
			{
				String sql = "select * from "+table_name+";";
				
				System.out.println(sql);
				
				ResultSet set = conn.executeQuery(sql);
				
				if(set!=null)
				{
					Vector<Comment> vector = new Vector<Comment>();
					
					try {
						while(set.next())
						{
							String name = set.getString("用户名");
							String day = set.getString("日期");
							String content = set.getString("评论");
							
							Comment tempt = new Comment();
							tempt.setName(name);
							tempt.setDay(day);
							tempt.setContent(content);
							
							vector.add(tempt);
						
						}
						
						
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					conn.close();
					return vector;
				}
				else
					return null;
				
				
			}


}
