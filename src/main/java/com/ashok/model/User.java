package com.ashok.model;

public class User {

	private String username;
	private String userEmail;
	private String userAddress;

	public User() {
	}

	public User(String username, String userEmail, String userAddress) {
		this.username = username;
		this.userEmail = userEmail;
		this.userAddress = userAddress;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", userEmail=" + userEmail + ", userAddress=" + userAddress + "]";
	}

}
