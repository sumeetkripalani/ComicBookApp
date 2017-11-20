package com.example.mvcproject.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.mvcproject.config.SpringRootConfig;
import com.example.mvcproject.dao.UserDAO;
import com.example.mvcproject.domain.User;

public class TestUserDAOUpdate {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO =ctx.getBean(UserDAO.class);
		//The user details will be taken from user profile
		User u = new User();
		u.setUserId(2);
		u.setName("Mayur Krips Yo");
		u.setPhone("9594962219");
		u.setEmail("mayurkrips@gmail.com");
		u.setAddress("valley_Shilp, Kharghar");
		/*u.setLoginName("Gol");
		u.setPassword("mayur123");
*/		u.setRole(1);//Admin Role
		u.setLoginStatus(1); //Active
		userDAO.update(u);
		System.out.println("-----------Data Updated-------");
	}

}
