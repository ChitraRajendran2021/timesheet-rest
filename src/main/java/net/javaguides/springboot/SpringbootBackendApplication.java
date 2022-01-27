package net.javaguides.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
public class SpringbootBackendApplication {
	private static final Logger logger = LogManager.getLogger(SpringbootBackendApplication.class);

	public static void main(String[] args) {

		logger.info("Stttttttttttttttta");
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

}
