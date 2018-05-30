package model;

public class User {
	private String userName;
	private String password;
	private String[] characteristics;
	
	public User(String Name, String Password, String[] Characteristics) {
		this.userName = Name;
		this.password = Password;
		this.characteristics = Characteristics;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String[] getCharacteristics() {
		return this.characteristics;
	}
}
