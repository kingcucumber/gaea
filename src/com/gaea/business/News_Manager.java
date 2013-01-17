package com.gaea.business;

import java.util.GregorianCalendar;

import com.gaea.dao.DataProcess;

public class News_Manager {
	public static void Add_News(String title, String content) {
		GregorianCalendar gc = new GregorianCalendar();
		try {
			title = new String(title.getBytes("ISO8895-1"));
			content = new String(content.getBytes("ISO8895-1"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		String query = "insert into news(title,content,datetime) values ('"
				+ title + "','" + content + "','"
				+ gc.getTime().toLocaleString() + "')";
		try {
			DataProcess.ExeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void Edit_News(String title, String content, int id) {
		GregorianCalendar gc = new GregorianCalendar();
		try {
			title = new String(title.getBytes("ISO8859-1"));
			content = new String(content.getBytes("ISO8859-1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		String query = "update news set title = '" + title + "',content='"
				+ content + "',datetime='" + gc.getTime().toLocaleString()
				+ "'where id=" + id;
		try {
			DataProcess.ExeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void Delete_News(int id){
		String deleteStr = "delete from news where id=" + id;
		try {
			DataProcess.ExeQuery(deleteStr);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
