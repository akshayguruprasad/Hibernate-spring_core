package com.indream.config;

import org.apache.log4j.BasicConfigurator;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@org.springframework.context.annotation.Configuration
@ComponentScan(basePackages = { "com.indream" })
public class SpringConfig {

	@Bean
	public SessionFactory getSession() {
		BasicConfigurator.configure();
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		if (sessionFactory == null) {
			System.err.println("Failed to create the sessionfactory");
		}
		return sessionFactory;
	}

}
