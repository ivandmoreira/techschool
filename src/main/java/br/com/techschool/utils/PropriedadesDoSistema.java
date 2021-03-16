package br.com.techschool.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.techschool.EstudandoApplication;

/**
 * @author Ivan Domingos Moreira
 * 
 * Classe criada para retornar as propriedades do sistema
 * apartir no arqivo config.properties
 */
 
public class PropriedadesDoSistema {
	
	private InputStream inputStream;
 	private String propriedade = null;
 	Logger logger = LoggerFactory.getLogger(PropriedadesDoSistema.class);
 
	public String getPropValues(String nomeDaPropriedade) throws IOException {

		try {
			Properties prop = new Properties();
			String nomeDoArquivo = "config.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(nomeDoArquivo);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("Arquivo de propriedades '" + nomeDoArquivo + "' não encontrado no classpath");
			}

			propriedade = prop.getProperty(nomeDaPropriedade);
		if(propriedade == null || propriedade.isBlank()){
			throw new javax.validation.ValidationException("Propriedade " + nomeDaPropriedade + "sem valor declarado no arquivo de configuração");
		}

		} catch (Exception e) {
			System.out.println("Exception: " + e);
			logger.error("Erro durante a recuperação das propriedades do sistema " + e.getMessage());
		} finally {
			inputStream.close();
		}
		return propriedade;
	}
}