package com.classroom.app.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SignIn {

	private String userName;
	private String password;
	private int status;

	public SignIn(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "SignIn [userName=" + userName + ", password=" + password + ", status=" + status + "]";
	}

}
