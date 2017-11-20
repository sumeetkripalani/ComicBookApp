package com.example.mvcproject.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.mvcproject.config.SpringRootConfig;
import com.example.mvcproject.dao.UserDAO;
import com.example.mvcproject.domain.User;

public class TestUserDAOFindSingleRecord {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO =ctx.getBean(UserDAO.class);
		User u = userDAO.findById(5);
		System.out.println("-----------User Details-------");
		
		System.out.println(u.getUserId());
		System.out.println(u.getName());
		System.out.println(u.getPhone());
		System.out.println(u.getAddress());
		System.out.println(u.getEmail());
		System.out.println(u.getLoginName());
		System.out.println(u.getLoginStatus());
		System.out.println(u.getRole());


		
	}

}
