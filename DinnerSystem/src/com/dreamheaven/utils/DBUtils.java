package com.dreamheaven.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.dreamheaven.constant.Constant;
import com.mchange.v2.c3p0.DataSources;

public class DBUtils {
	
//	public static Connection getConnection() throws SQLException, ClassNotFoundException{
//	//	使用c3p0连接数据库
//		Class.forName(Constant.MYSQL_DRIVER_CLASS);
//		DataSource unpooled = DataSources.unpooledDataSource(Constant.MYSQL_JDBC_URL, Constant.MYSQL_USER, Constant.MYSQL_PASSWORD);
//		return DataSources.pooledDataSource(unpooled).getConnection();
//	}
	//
//	public void queryDB(String sql, Object obj) throws SQLException, ClassNotFoundException{
//		Connection conn = getConnection();
//		Statement stmt = conn.createStatement();
//		ResultSet rs = stmt.executeQuery(sql);
//		while(!rs.isLast()){
//			rs.next();
//			int i = rs.getMetaData().getColumnCount();
//			for(int j = 0 ; j < i ; i ++){
//				System.out.println(rs.getString(j));
//			}
//		}
//	}
//	
//	public boolean updateDB(String sql) throws SQLException, ClassNotFoundException{
//		Connection conn = getConnection();
//		return conn.createStatement().execute(sql);
//	}
//	
//	public boolean deleteDB(String sql) throws SQLException, ClassNotFoundException{
//		Connection conn = getConnection();
//		return conn.createStatement().execute(sql);	
//	}
//	
//	public boolean insertDB(String sql) throws SQLException, ClassNotFoundException{
//		Connection conn = getConnection();
//		return conn.createStatement().execute(sql);
//	}
}
