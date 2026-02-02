package com.hello.word.aws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AwsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsApplication.class, args);
	}

	@GetMapping("/hello/{message}")
	public String hello(@PathVariable String message) {
		return "Hello "+message;
	}

}
