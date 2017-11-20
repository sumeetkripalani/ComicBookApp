package com.example.mvcproject.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {"com.example.mvcproject.dao","com.example.mvcproject.service"})
public class SpringRootConfig {
	//TODO : Services,DAO, DATASOURCE, EMAIL SEMDER OR SOME OTHER BUSSINESS LAYER BEANS 
	
	@Bean
	public BasicDataSource getDataSource()
	{
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/capp_db");
		ds.setUsername("root");
		ds.setPassword("sharingan@1234");
		ds.setMaxTotal(2);
		ds.setInitialSize(1);
		ds.setDefaultAutoCommit(true);
		return ds;
	}
		
}
