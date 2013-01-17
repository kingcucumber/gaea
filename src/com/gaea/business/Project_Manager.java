package com.gaea.business;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.gaea.dao.DataProcess;
import com.gaea.domain.Project;

public class Project_Manager {
	public static void Add_Project(String name,String info,String time){
		try {
			name = new String(name.getBytes("ISO8895-1"));
			info = new String(info.getBytes("ISO8895-1"));
			time = new String(time.getBytes("ISO8895-1"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		String query = "insert into project(name,info,time) values ('"+name+"','" + info + "','" + time +"')'";
		try {
			DataProcess.ExeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void Edit_Project(int id,String name,String info,String time){
		try {
			name = new String(name.getBytes("ISO8895-1"));
			info = new String(info.getBytes("ISO8895-1"));
			time = new String(time.getBytes("ISO8895-1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		String query = "update project set name ='"+name + "',info='"+info + "',time='" + time+"'where id=" +id;
		try {
			DataProcess.ExeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void Delete_Project(int id){
		String query  = "delete from project where id=" +id;
		try {
			DataProcess.ExeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Project getProject(int id){
		String selectStr = "select * from project where id = " + id;
		Connection conn = DataProcess.getConnection();
		Project p = Project.getInstance();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(selectStr);
			if(rs.next()){
				String name = rs.getString("name");
				String info = rs.getString("info");
				String time = rs.getString("time");
				p.setId(id);
				p.setName(name);
				p.setInfo(info);
				p.setTime(time);
			}
			rs.close();
			st.close();
			conn.close();
			return p;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ArrayList getProjectList(){
		String query = "select * from project "	;
		Connection conn = DataProcess.getConnection();
		ArrayList pl = new ArrayList();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String info = rs.getString("info");
				String time = rs.getString("time");
				Project p = Project.getInstance();
				
				p.setId(id);
				p.setName(name);
				p.setInfo(info);
				p.setTime(time);
				pl.add(p);
			}
			rs.close();
			st.close();
			conn.close();
			return pl;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
