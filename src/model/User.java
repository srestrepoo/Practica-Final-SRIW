package model;

import java.util.ArrayList;

public class User {
	private String userName;
	private String password;
	private String Department;
	private ArrayList<ObjetoRecomendar> puntosGustan = new ArrayList<ObjetoRecomendar>();
	
	public User(String Name, String Password, String Department) {
		this.userName = Name;
		this.password = Password;
		this.Department = Department;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getDepartment() {
		return this.Department;
	}
	
	public void setPuntosGustan(ArrayList<ObjetoRecomendar> PuntosGustan) {
		puntosGustan = PuntosGustan;
	}
	
	public ArrayList<ObjetoRecomendar> getPuntosGustan(){
		return puntosGustan;
	}
}
