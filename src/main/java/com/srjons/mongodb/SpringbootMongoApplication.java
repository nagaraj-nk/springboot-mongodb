package com.srjons.mongodb;

import com.srjons.mongodb.model.Customer;
import com.srjons.mongodb.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SpringbootMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMongoApplication.class, args);
	}

}
