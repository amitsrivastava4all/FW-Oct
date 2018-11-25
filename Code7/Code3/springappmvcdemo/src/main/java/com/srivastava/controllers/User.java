package com.srivastava.controllers;

public class User {
	private String userid;
	private String pwd;
	private String message;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", pwd=" + pwd + ", message=" + message + "]";
	}
	

}
