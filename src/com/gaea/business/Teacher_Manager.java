package com.gaea.business;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.gaea.dao.DataProcess;
import com.gaea.domain.Teacher;

public class Teacher_Manager {
	public static void Add_Teacher(String name, String sex, String zhicheng,
			String image, String info) {
		String gender = "";
		if (sex.equals("male")) {
			gender = "男";
		} else {
			gender = "女";
		}
		try {
			name = new String(name.getBytes("ISO8895-1"));
			zhicheng = new String(zhicheng.getBytes("ISO8895-1"));
			image = new String(image.getBytes("ISO8895-1"));
			info = new String(info.getBytes("ISO8895-1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		String query = "insert into teacher(name,sex,zhicheng,image,info) values ('"
				+ name
				+ "','"
				+ gender
				+ "','"
				+ zhicheng
				+ "','"
				+ image
				+ "','" + info + "')";
		try {
			DataProcess.ExeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void Edit_Teacher(String name, String sex, String zhicheng,
			String image, String info, int id) {
		String gender = "";
		if (sex.equals("male")) {
			gender = "男";
		} else {
			gender = "女";
		}
		try {
			name = new String(name.getBytes("ISO8895-1"));
			zhicheng = new String(zhicheng.getBytes("ISO8895-1"));
			image = new String(image.getBytes("ISO8895-1"));
			info = new String(info.getBytes("ISO8895-1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		String query = "update teacher set name='" + name + "',sex='" + gender
				+ "',zhicheng ='" + zhicheng + "',image='" + image + "'+info='"
				+ info + "' wheree id=" + id;
		try {
			DataProcess.ExeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void delete_Teacher(int id) {
		String deleteStr = "delete from teacher where id =" + id;
		try {
			DataProcess.ExeQuery(deleteStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Teacher getTeacher(int id) {
		String selectStr = "select * from teacher where id = " + id;
		Connection conn = DataProcess.getConnection();
		Teacher teacher = Teacher.getInstance();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(selectStr);
			if (rs.next()) {
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				String zhicheng = rs.getString("zhicheng");
				String image = rs.getString("image");
				String info = rs.getString("info");
				teacher.setId(id);
				teacher.setImage(image);
				teacher.setInfo(info);
				teacher.setName(name);
				teacher.setSex(sex);
				teacher.setZhicheng(zhicheng);

			}
			rs.close();
			st.close();
			conn.close();
			return teacher;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ArrayList getTeacherList(){
		String query = "select * from teacher"	;
		Connection conn = DataProcess.getConnection();
		ArrayList tl = new ArrayList();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()){
				int id = rs.getInt("id");
				String name =rs.getString("name");
				String sex = rs.getString("sex");
				String zhicheng = rs.getString("zhicheng");
				String image = rs.getString("image");
				String info = rs.getString("info");
				Teacher teacher = Teacher.getInstance();
				teacher.setId(id);
				teacher.setImage(image);
				teacher.setInfo(info);
				teacher.setName(name);
				teacher.setSex(sex);
				teacher.setZhicheng(zhicheng);
				tl.add(teacher);
			}
			rs.close();
			st.close();
			conn.close();
			return tl;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
