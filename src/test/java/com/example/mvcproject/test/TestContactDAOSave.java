package com.example.mvcproject.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.mvcproject.config.SpringRootConfig;
import com.example.mvcproject.dao.ContactDAO;
import com.example.mvcproject.dao.UserDAO;
import com.example.mvcproject.domain.Contact;
import com.example.mvcproject.domain.User;

public class TestContactDAOSave {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ContactDAO contactDAO =ctx.getBean(ContactDAO.class);
		//The user details will be taken from registration form
		Contact c = new Contact();
		c.setUserId(1);
		c.setName("pops");
		c.setAddress("valleyshilp");
		c.setEmail("manoj@gmail.com");
		c.setPhone("95949738");
		c.setRemark("father");
		contactDAO.save(c);
		System.out.println("-----------Data Saved-------");
	}

}
