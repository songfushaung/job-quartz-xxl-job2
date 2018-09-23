package com.xxl.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.xxl.User;

public class DBUtil {
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	private static final CallableStatement cs = null;
	
	/**
	 * Insert方法封装
	 * @param stu 传入参数
	 */
	public static void Insert(User user) {
		conn = DBConn.conn();		//调用 DBconnection 类的 conn() 方法连接数据库
		String sql = "INSERT INTO user (id,name,sex) VALUES(?,?,?)";		//插入sql语句
		try {
			ps = conn.prepareStatement(sql);
			
			/**
			 * 调用实体StuInfo类,获取需要插入的各个字段的值
			 * 注意参数占位的位置
			 * 通过set方法设置参数的位置
			 * 通过get方法取参数的值
			 */
			ps.setInt(1, user.getId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getSex());
			
			ps.executeUpdate();			//执行sql语句
			
			System.out.println("插入成功(*￣︶￣)");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConn.close();
		}
	}
}
