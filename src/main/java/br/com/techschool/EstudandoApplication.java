package br.com.techschool;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.techschool.utils.PropriedadesDoSistema;
import br.com.techschool.utils.SendEmail;

@SpringBootApplication
public class EstudandoApplication {

	public static void main(String[] args) {
		
        Logger logger = LoggerFactory.getLogger(EstudandoApplication.class);
        logger.info("Starting TechSchool");
	//	SpringApplication.run(EstudandoApplication.class, args);
	
    //    SendEmail sendMail = new SendEmail();
        
    //    sendMail.enviarEmail("renata.ijr@gmail.com");
      
        PropriedadesDoSistema prop = new PropriedadesDoSistema();
        try {
            String teste = prop.getPropValues("portaServidorSMTP");

            System.out.println(Integer.parseInt(teste));
            
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
					  
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		}
 
		logger.info("TechSchool Started");
	}

}
