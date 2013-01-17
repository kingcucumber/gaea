package com.gaea.domain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import com.gaea.dao.DataProcess;
import com.mysql.jdbc.PreparedStatement;

public class News {
	private int id;
	private String title;
	private String content;
	private String time;
	public News() {
		// TODO Auto-generated constructor stub
	}
	public News(int id, String title, String content, String time) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
	public static Vector search(String sql,int page) throws Exception{
		Vector Items = new Vector();
		Connection conn = DataProcess.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			Pageable pgb = new Pageable(rs);
			pgb.setPageSize(5);
			pgb.gotoPage(page);
			
			rs.absolute(pgb.getRowsCount());
			int  i =0;
			do{
				Items.addElement(new News(rs.getInt("id"),rs.getString("title"),rs.getString("content"),rs.getString("datetime")));
				i++;
			}while(rs.next() && i<pgb.getCurrentPageRowsCount());
			return Items;
		} finally{
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static  News getNews(int id){
		String selectStr = "select * from news where id=" + id;
		Connection conn = DataProcess.getConnection();
		News news = new News();
		try {
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(selectStr);
			if(rs.next()){
				String title = rs.getString("title");
				String content = rs.getString("content");
				String time  = rs.getString("datetime");
				
				news.setId(id);
				news.setTitle(title);
				news.setContent(content);
				news.setTime(time);
			}
			rs.close();
			st.close();
			conn.close();
			return news;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}	
