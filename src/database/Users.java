package database;

import java.util.ArrayList;

import model.User;

public class Users {
	//Agregar usuarios
	private static ArrayList<User> activeUsers = new ArrayList<User>();
	private static User activeUser;
	
	public static void addUser(User user) {
		activeUsers.add(user);
	}
	
	public static ArrayList<User> getActiveUsers(){
		return activeUsers;
	}
	
    public static void login(User user){
        activeUser = user;
    }
    
    public static void signOut(){
        activeUser = null;
    }
    
    public static User getActiveUser(){
        return activeUser;
    }
}
