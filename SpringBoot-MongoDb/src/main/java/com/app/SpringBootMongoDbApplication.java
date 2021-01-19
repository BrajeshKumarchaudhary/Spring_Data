package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.app.repo.FaceBookUserRepo;
import com.app.repo.UserRepo;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = {UserRepo.class,FaceBookUserRepo.class})
public class SpringBootMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongoDbApplication.class, args);
	}

}
