package com.ashok.service;

import java.util.ArrayList;
import java.util.List;

import com.ashok.model.User;

public class UserService {

	/**
	 * This method is used to return Users Data
	 * @return List<User>
	 */
	public List<User> fetchUsersData() {
		// talk to dao to get the data

		List<User> usersList = new ArrayList<User>();
		
		//adding sample data here
		usersList.add(new User("Mayank", "mayank@in.com", "India"));
		usersList.add(new User("Dean", "dean@in.com", "UK"));
		usersList.add(new User("Cedrone Charles", "charles@yahoo.com", "UK"));
		usersList.add(new User("Shiba Orlen", "shiba@in.com", "Australia"));
		usersList.add(new User("Rohan", "rohan@gmail.com", "India"));

		return usersList;
	}

}
