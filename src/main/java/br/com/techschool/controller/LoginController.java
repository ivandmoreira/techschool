package br.com.techschool.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.techschool.EstudandoApplication;
import br.com.techschool.modelo.Usuario;
import br.com.techschool.persistencia.UsuarioRepository;
import br.com.techschool.utils.SendEmail;

@Controller
public class LoginController {

	@Autowired
	UsuarioRepository usuarioRepository;
    final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public String login() {
		
		System.out.println("teste" );
		
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/logar")
	public String logar(@RequestParam("usuario") String usuario,@RequestParam("senha") String senha ) {
		
		System.out.println("Usuario: " + usuario + " Senha: " + senha );
		
		return "login";
	}
		
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public String cadastrar (@RequestParam("nome") String nome,@RequestParam("emailUsuario") String emailUsuario,
							@RequestParam("senha") String senha ) {
		
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setEmail(emailUsuario);
		usuario.setSenha(senha);
		try {
			usuarioRepository.save(usuario);
			SendEmail sender = new SendEmail();
			sender.enviarEmail(emailUsuario, "Seja bem vindo a Techschool, esse email significa que você ja está cadastrado"
												+ " como aspirante a programador de alguma tecnologia, "
												+ "continue navegendo em nosso sistema e cadastre-se em um de nossos cursos");
		} catch (Exception e) {
	        logger.info("Erro no cadastro do aluno " + e.getStackTrace());
	        
		}

		return "login";
	}
	
}
