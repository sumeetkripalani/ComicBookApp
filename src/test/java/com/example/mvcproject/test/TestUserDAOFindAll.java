package com.example.mvcproject.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.mvcproject.config.SpringRootConfig;
import com.example.mvcproject.dao.UserDAO;
import com.example.mvcproject.domain.User;

public class TestUserDAOFindAll {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO =ctx.getBean(UserDAO.class);
		//User u = userDAO.findById(5);
		
		List<User> users = userDAO.findAll();
		
		for(User u:users)
		{
			System.out.println(u.getUserId()+" "+u.getName()+" "+u.getRole());
		}
			

		
	}

}
