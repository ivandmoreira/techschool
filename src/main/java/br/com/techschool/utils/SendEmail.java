package br.com.techschool.utils;

import java.io.IOException;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.techschool.EstudandoApplication;


/**
 * @author Ivan Domingos Moreira
 * 
 * Classe criada para realizar os envios de email do sistema
 */
 
public class SendEmail {
	
	PropriedadesDoSistema propValues = new PropriedadesDoSistema();
	
    Logger logger = LoggerFactory.getLogger(SendEmail.class);

	public void enviarEmail(String destinatario, String mensagem) {
		
		try {
			
		String servidorSMTP = propValues.getPropValues("servidorSMTP");
		String portaServidorSMTP = propValues.getPropValues("portaServidorSMTP");
		String loginEmail = propValues.getPropValues("loginEmail");
		String senhaEmail = propValues.getPropValues("senhaEmail");
		Boolean SSL = Boolean.valueOf(propValues.getPropValues("SSL"));
		String remetente = propValues.getPropValues("remetente");
			
			
		Email email = new SimpleEmail();
		email.setHostName(servidorSMTP);
		email.setSmtpPort(Integer.parseInt(portaServidorSMTP));
		email.setAuthenticator(new DefaultAuthenticator(loginEmail, senhaEmail));
		email.setSSLOnConnect(SSL);
		
			email.setFrom("remetente");
			email.setSubject("Bem Vindo a Tech School");
			email.setMsg(mensagem);
			email.addTo(destinatario);
			email.send();
		    logger.info("Email enviado com sucesso");
		} catch (NumberFormatException e) {
			
		    logger.error("Não foi possível converter a propriedade portaServidorSMTP para inteiro, favor verificar o arquivo de configuracão " +  e.getMessage());
		    
		}catch (Exception e) {
			
		    logger.error("Falha no envio de email " +  e.getMessage());
			
		}
	}
	
}
