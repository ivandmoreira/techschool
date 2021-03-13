package br.com.techschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.techschool.modelo.Usuario;
import br.com.techschool.persistencia.UsuarioRepository;

@Controller
public class LoginController {

	@Autowired
	UsuarioRepository usuarioRepository;
	
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
		usuarioRepository.save(usuario);
		
		
		return "login";
	}
	
}
