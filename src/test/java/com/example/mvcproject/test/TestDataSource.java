package com.example.mvcproject.test;



import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;


import com.example.mvcproject.config.SpringRootConfig;

public class TestDataSource {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		DataSource ds = ctx.getBean(DataSource.class);
		JdbcTemplate jt = new JdbcTemplate(ds);
		String sql="INSERT INTO user(`name`, `phone`, `email`, `address`, `loginName`, `password`) VALUES(?,?,?,?,?,?)";
		Object[] param = new Object[] {"Sumit","9975873170","inspiredsumit@gmail.com","Mumbai","Sumeet","sumeet1234"};
		jt.update(sql,param);
		System.out.println("-------------SQL EXECUTED------------");
	}

}
