package com.product.application.model;



/**
 * this class manages the login credentials of the user.
 * 
 */
public class User {

	private String userName;
	private String passWord;

	public String getUserName() {
		return userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

}