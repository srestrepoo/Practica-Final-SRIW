package controller;

import database.Users;
import java.util.ArrayList;
import model.User;

public class IniciarSesion {
	
	public static boolean autenticacion(String username, String password){
        ArrayList<User> Usuarios = Users.getActiveUsers();
        for (int i = 0; i < Usuarios.size(); i++) {
            if(Usuarios.get(i).getUserName().equals(username) && Usuarios.get(i).getPassword().equals(password)){
                Users.login(Usuarios.get(i));
                return true;
            }
        }
        return false;
    }
}
