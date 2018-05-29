package model;

public class User {
	private String name;
	private String password;
	private String[] characteristics;
	
	public User(String Name, String Password, String[] Characteristics) {
		this.name = Name;
		this.password = Password;
		this.characteristics = Characteristics;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String[] getCharacteristics() {
		return this.characteristics;
	}
}
