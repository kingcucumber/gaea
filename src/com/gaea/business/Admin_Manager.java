package com.gaea.business;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.gaea.dao.DataProcess;
import com.gaea.domain.Manager;

public class Admin_Manager {
	public static boolean CheckAdmin(String username,String password){
		String query = "select count(*) from admin where admin.name='" + username + "',and admin.password='" + password + "'";
		int count= DataProcess.nCount(query);
		if(count>0){
			return true;
		}else 
			return false;
	}
	
	public static boolean HasAdmin(String username){
		String query = "select count(*) from admin where admin.name='" + username+"'";
		int count = DataProcess.nCount(query);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	public static void add_Admin(String username,String password){
		String query = "insert into admin(admin.name,admin.password values('" + username + "','" +password +"')";
		try {
			DataProcess.ExeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void Edit_Admin(String username,String password){
		String query = "update admin set admin.password = '" + password + "' where admin.name = '" + username + "'";
		try {
			DataProcess.ExeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void Delete_Admin(String username){
		String query = "delete from admin where admin.name='" + username + "'";
		try {
			DataProcess.ExeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Manager getManager(String username){
		String selectStr="select * from admin where admin.name ='" + username+"'";
		Connection conn  =DataProcess.getConnection();
		Manager m =Manager.getInstance();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(selectStr);
			if(rs.next()){
				String password = rs.getString("password");
				m.setPassword(password);
				m.setUsername(username);
			}
			rs.close();
			st.close();
			conn.close();
			return m;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static  ArrayList getManagerList(){
		String selectStr="select * from admin ";
		Connection conn  =DataProcess.getConnection();
		ArrayList ml = new ArrayList();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(selectStr);
			while(rs.next()){
				String name = rs.getString("name");
				String password = rs.getString("password");
				Manager m =Manager.getInstance();
				m.setPassword(password);
				m.setUsername(name);
				ml.add(m);
			}
			rs.close();
			st.close();
			conn.close();
			return ml;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
