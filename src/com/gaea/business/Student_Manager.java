package com.gaea.business;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.gaea.dao.DataProcess;
import com.gaea.domain.Student;

public class Student_Manager {
	public static void Add_Student(String name, int grade_id, String image,
			String sex) {
		String gender = sex;
		if (sex.equals("male")) {
			gender = "男";
		} else {
			gender = "女";
		}
		try {
			name = new String(name.getBytes("ISO8895-1"));
			image = new String(image.getBytes("ISO8895-1"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		String query = "insert into student(name,grade_id,image,sex) values('"
				+ name + "','" + grade_id + "','" + image + "','" + gender
				+ "')";
		try {
			DataProcess.ExeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void Edit_Student(int id, String name, int grade_id,
			String image, String sex) {
		String gender = sex;
		if (sex.equals("male")) {
			gender = "男";
		} else {
			gender = "女";
		}
		try {
			name = new String(name.getBytes("ISO8895-1"));
			image = new String(image.getBytes("ISO8895-1"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		String query = "update student set name= '" + name + "',grade_id='"
				+ grade_id + "',image='" + image + "',sex='" + gender
				+ "' where id =" + id;
		try {
			DataProcess.ExeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void Delete_Student(int id) {

		String query = "delete from student where id=" + id;
		try {
			DataProcess.ExeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Student getStudent(int id) {
		String query = "select * from student where id =" + id;
		Connection conn = DataProcess.getConnection();
		Student s = Student.getInstance();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				String name = rs.getString("nanme");
				String sex = rs.getString("sex");
				String image = rs.getString("image");
				int grade_id = rs.getInt("grade_id");
				s.setGrade_id(grade_id);
				s.setId(id);
				s.setImage(image);
				s.setName(name);
				s.setSex(sex);
				rs.close();
				st.close();
				conn.close();
			}
			return s;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ArrayList getStudentList() {
		String query = "select * from student ";
		Connection conn = DataProcess.getConnection();
		ArrayList sl = new ArrayList();

		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("nanme");
				String sex = rs.getString("sex");
				String image = rs.getString("image");
				int grade_id = rs.getInt("grade_id");

				Student s = Student.getInstance();
				s.setGrade_id(grade_id);
				s.setId(id);
				s.setImage(image);
				s.setName(name);
				s.setSex(sex);
				rs.close();
				st.close();
				conn.close();
				sl.add(s);
			}
			return sl;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
