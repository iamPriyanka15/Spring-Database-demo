package com.priyanka.database.database_demo;

import com.priyanka.database.database_demo.entity.Person;
import com.priyanka.database.database_demo.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

//@SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users -> {}",dao.findAll());
		logger.info("one user -> {}",dao.findById(10003));
		//logger.info("by name -> {}",dao.findByName("Pieter"));
		logger.info("Deleting 10002 -> No of rows deleted-> {}",dao.deleteById(10002));
		logger.info("Inserting 10005 -> No of rows inserted-> {}",
				dao.insert(new Person(10005,"Priya","Denver",new Date())));
		logger.info("updating 10003 -> {}",
				dao.update(new Person(10003, "Tara", "Lone tree", new Date())));


	}
}
