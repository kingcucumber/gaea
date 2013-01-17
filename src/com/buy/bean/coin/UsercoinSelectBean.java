package com.buy.bean.coin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.buy.bean.database.DBConnect;

public class UsercoinSelectBean {
	public String selectUsercoin(String ID,int i){
		String condition;
		if(i == 0){
			condition = "select Coin from User where UserId = '" + ID + "'";
		}else if(i == 1){
			condition = "select Consume from User where UserId = '" + ID + "'";
		}else if(i == 2){
			condition = "select Consume + Coin from User where UserId = '" + ID + "'";
		}else if(i == 3){
			condition = "select Name from User where UserId = '" + ID + "'";
		}else {
			condition = "select Type frome User where UserId = '" + ID + "'";
		}
		ResultSet rs = null;
		Statement sql = null;
		String str = new String();
		try {
			int coin;
			Connection  conn = DBConnect.getConnection();
			sql = conn.createStatement();
			rs = sql.executeQuery(condition);
			while(rs.next()){
				str = rs.getString(1);
			}
			coin = Integer.parseInt(str);
			rs.close();
		}catch(SQLException ex){
			return new String("cann't select !");
		}
		return str;
	}
}
