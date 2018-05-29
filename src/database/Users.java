package database;

import java.util.ArrayList;

import model.User;

public class Users {
	private static ArrayList<User> activeUsers;
	
	public static void addUser(User user) {
		activeUsers.add(user);
	}
	
	public static boolean removeUser(User user) {
		return activeUsers.remove(user);
	}
	
	public static ArrayList<User> getActiveUser(){
		return activeUsers;
	}
}
