package controllers;

import java.util.List;

import models.User;

import play.db.jpa.GenericModel.JPAQuery;


public class Security extends Secure.Security {
	
	static boolean authenticate(String username, String password) {
		
		JPAQuery jpaResult = User.find("select u from User u where u.login = ?", "admin");
		List<User> result = jpaResult.fetch();
		
		User admin = result.get(0);
		
		if (username.equals(admin.login) && password.equals(admin.password)){
			return true;
		} else {
			return false;
		}
    }
	
	static void onDisconnected() {
	   // Application.index();
	}

}
