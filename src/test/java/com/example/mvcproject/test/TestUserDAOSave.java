package com.example.mvcproject.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.mvcproject.config.SpringRootConfig;
import com.example.mvcproject.dao.UserDAO;
import com.example.mvcproject.domain.User;

public class TestUserDAOSave {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO =ctx.getBean(UserDAO.class);
		//The user details will be taken from registration form
		User u = new User();
		u.setName("Mayur");
		u.setPhone("1234456");
		u.setEmail("mayur@gmail.com");
		u.setAddress("valley_Shilp");
		u.setLoginName("Gol");
		u.setPassword("mayur123");
		u.setRole(1);//Admin Role
		u.setLoginStatus(1); //Active
		userDAO.save(u);
		System.out.println("-----------Data Saved-------");
	}

}
