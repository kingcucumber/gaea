package com.gaea.domain;

public class Manager {
	
	private String username;
	private String password;
	private Manager(){};
	private Manager(String username,String password){
		this.username = username;
		this.password  = password;
	}
	public static Manager getInstance(){
		return new Manager();
	}
	public static Manager getInstance(String username,String password){
		return new Manager(username,password);
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
