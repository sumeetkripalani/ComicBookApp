package com.example.mvcproject.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.mvcproject.config.SpringRootConfig;
import com.example.mvcproject.dao.UserDAO;
import com.example.mvcproject.domain.User;

public class TestUserDAODelete {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO =ctx.getBean(UserDAO.class);
		//The user details will be taken from registration form
		userDAO.delete(2);
		System.out.println("-----------Data Deleted-------");
	}

}
