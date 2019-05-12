package com.code.user.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.sql.Connection;
import java.sql.Driver;

public class jdbcConnection{

	public Connection conn = null;
	public Statement sta = null;
	public ResultSet set = null;
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://127.0.0.1:3306/test1?characterEncoding=utf-8";
	private static String dbName = "root";
	private static String dbPassword = "123456";
	
	public jdbcConnection() 
	{
		try
		{
			Class.forName(driverName);
			System.out.println("驱动加载成功!");
		}
		catch(ClassNotFoundException  e)
		{
			System.out.println("数据库连接错误1!");
			e.printStackTrace();
			
		}
		
		
	}
	
	//获取连接
	public Connection getConnection()
	{
		try
		{
			conn = DriverManager.getConnection(url,dbName,dbPassword);

			System.out.println("数据库连接成功!");
			
		}
		catch(SQLException e)
		{
			System.out.println("数据库连接错误2!");
			e.printStackTrace();
		}
		if(conn==null)
		{
			System.out.println("数据库连接为空！");
			System.exit(0);
		}
		
		return conn;
	}
	
	
	 //更新
	public int executeUpdate(String sql)
	{
		int result = 0;
		
		try
		{
			conn = getConnection();
			
			sta = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			result = sta.executeUpdate(sql);
			
		}
		catch(SQLException ex)
		{
			result = 0;
			
		}
		
		return result;
	
	
	}
	
	//查询数据
	public ResultSet executeQuery(String sql) 
	{
		try
		{
			conn = getConnection();
			
			sta = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); //设置为指针可向前向后移动，和只读 
			
		    set = sta.executeQuery(sql);
		}
		catch(SQLException ex)
		{
			System.err.println(ex.getMessage());
			
		}
		
		return set;
	}
		//关闭连接
	public void close()
	{
		try
		{
			if(set!=null)
			{
			  set.close();
			}
			if(sta!=null)
			{
				sta.close();
			}
			if(conn!=null)
			{
				conn.close();
			}
			
			/*Enumeration<Driver> drivers = DriverManager.getDrivers();            //关闭数据库的驱动，防止内存泄漏
			
			while(drivers.hasMoreElements())
			{
				Driver driver = drivers.nextElement();
				
				DriverManager.deregisterDriver(driver);
			}
			*/
			
		}
		catch(SQLException ex)
		{
			ex.printStackTrace(System.err);
		}
		System.out.println("数据库关闭成功！");
		
	}
	

}
