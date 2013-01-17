package com.gaea.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataProcess {
	public DataProcess() {
		// TODO Auto-generated constructor stub
	}
	public static Connection getConnection(){
		String classForName = "com.java.mysql.Driver";
		String serverUrl = "jdbc:mysql://localhost:3306/gaea?" + "user=root&password=root&useUnicode=true&characterEncoding=gb2312";
		Connection conn;
		try {
			Class.forName(classForName);
			conn = DriverManager.getConnection(serverUrl);
			
			return conn;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public static int nCount(String sql){
		Connection myConnection = getConnection();
		int count = 0;
		
		try {
			Statement stm = myConnection.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			if(rs.next()){
				count = rs.getInt(1);
				rs.close();
			}
			stm.close();
			myConnection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public static void ExeQuery(String sql){
		Connection conn = getConnection();
		try {
			Statement stm = conn.createStatement();
			stm.executeUpdate(sql);
			stm.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static ResultSet getResult(String sql,Connection conn){
		ResultSet rs = null;
		try {
			Statement stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			stm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public static void CloseConnection(Connection conn){
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void CloseResultSet(ResultSet rs){
		try {
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
