package com.code.user.service;

import java.util.Vector;

import com.code.user.dao.CommentDao;
import com.code.user.doamin.Comment;

public class CommentService {
	private CommentDao commentDao = new CommentDao();
	
	//插入评论
	
	public boolean addComment(Comment comment_information,String table_name)
	{
		return commentDao.addComment(comment_information, table_name);
		
	}
	
	//查找评论
	
	public Vector<Comment> findComments(String table_name)
	{
		return commentDao.findComment(table_name);
			
	}
	

}
