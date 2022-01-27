package net.javaguides.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SpringbootBackendApplication {

	public static void main(String[] args) {
		log.info("Spring Boot Initialization");
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

}
