package com.easylearnjava.provider.webservice;

import com.easylearnjava.provider.dto.User;

public class UserWrapper {

	private User user;
	private int statusId;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

}
