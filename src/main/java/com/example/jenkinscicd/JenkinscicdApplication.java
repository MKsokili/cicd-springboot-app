package com.example.jenkinscicd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JenkinscicdApplication {
	@GetMapping
	public String message(){
		return "welcome to jenkins test ci cd pipeline form jenkinsfile in repo , testing docker build image zeza";
	}
	public static void main(String[] args) {
		SpringApplication.run(JenkinscicdApplication.class, args);
	}

}
