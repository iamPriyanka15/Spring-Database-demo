package com.priyanka.database.database_demo;

import com.priyanka.database.database_demo.entity.Person;
import com.priyanka.database.database_demo.jdbc.PersonJdbcDao;
import com.priyanka.database.database_demo.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("one user -> {}",repository.findById(10003));

		logger.info("Inserting 10005 -> No of rows inserted-> {}",
				repository.insert(new Person("Priya","Denver",new Date())));
		logger.info("updating 10003 -> {}",
				repository.update(new Person(10003, "Tara", "Lone tree", new Date())));
		repository.deleteById(10002);


		/*
		logger.info("All users -> {}",repository.findAll());
		//logger.info("by name -> {}",dao.findByName("Pieter"));
		logger.info("Deleting 10002 -> No of rows deleted-> {}",repository.deleteById(10002));


*/
	}
}
