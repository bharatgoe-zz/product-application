package com.product.application.model;

public class ResponseUser {

	public boolean isAddItem() {
		return addItem;
	}

	public void setAddItem(boolean addItem) {
		this.addItem = addItem;
	}

	private String responseAuth;
	private boolean addItem;

	public String getResponseAuth() {
		return responseAuth;
	}

	public void setResponseAuth(String responseAuth) {
		this.responseAuth = responseAuth;
	}

}
