package com.buy.bean.coin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.buy.bean.database.DBConnect;

public class ConsumeSelectBean1 {
	public ConsumeSelectBean1() {

	}

	public StringBuffer selectConsume(String userID) {
		String condition = "select count(UserId) as num,ProductName,sum(Price) as total from consume where Id='"
				+ userID + "' group by ProductName";
		ResultSet rs = null;
		String name, coin, num;
		Statement sql = null;
		StringBuffer buffer = new StringBuffer();
		try {
			Connection conn = DBConnect.getConnection();
			sql = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY	);
			rs = sql.executeQuery(condition);
			while(rs.next()){
				num = rs.getString(1);
				name = rs.getString(2);
				coin = rs.getString(3);
				buffer.append(num + "个" + name + "," + "金额： " + coin + "<br>");
			}
			rs.close();
			sql.close();
			conn.close();
		}catch(SQLException ex){
			return new StringBuffer("查询错误！");
		}
		return buffer;
	}
}
