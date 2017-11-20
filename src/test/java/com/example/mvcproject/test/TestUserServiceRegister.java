package com.example.mvcproject.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.mvcproject.config.SpringRootConfig;
import com.example.mvcproject.domain.User;
import com.example.mvcproject.service.UserService;

public class TestUserServiceRegister {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserService userService=ctx.getBean(UserService.class);
		
		//The user details will be taken from registration form
		User u = new User();
		u.setName("Gol");
		u.setPhone("76858648");
		u.setEmail("gol@gmail.com");
		u.setAddress("ShilpValley");
		u.setLoginName("jhol");
		u.setPassword("gol123");
		u.setRole(UserService.ROLE_ADMIN);//Admin Role
		u.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE); //Active
		userService.register(u);
		System.out.println("-----------User Registered Successfully-------");
	}

}
