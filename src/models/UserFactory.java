package models;

import java.util.ArrayList;

public class UserFactory {
	private ArrayList<User> userList;
	
	public UserFactory () {
		this.userList = new ArrayList<User>();
	}

	public ArrayList<User> getUserList() {
		return userList;
	}
	
	public void addUser(User newUser) {
		this.userList.add(newUser);
	}
	
	public User verifyLogin(String username, String password) {
		boolean loginSuccess = false;
		
		for(User user: userList) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				loginSuccess = true;
				return user;
			}
		}

		return null;
	}
	
}
