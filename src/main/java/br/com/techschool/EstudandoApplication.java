package br.com.techschool;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EstudandoApplication {

	public static void main(String[] args) {
		
        Logger logger = LoggerFactory.getLogger(EstudandoApplication.class);
        logger.info("Starting TechSchool");
		SpringApplication.run(EstudandoApplication.class, args);
		
		logger.info("TechSchool Started");
	}

}
