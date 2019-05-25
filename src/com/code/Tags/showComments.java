package com.code.Tags;

import java.util.Vector;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.code.user.doamin.Comment;

public class showComments extends SimpleTagSupport {
	private Vector<Comment> vector = null;
	
	public void setVector(Vector<Comment> vector)
	{
		this.vector = vector;
	}
	
	public void doTag()
	{
		JspWriter writer = this.getJspContext().getOut();
		
		while(vector.)
		
	}

}
