package br.com.techschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.techschool.modelo.Usuario;
import br.com.techschool.persistencia.UsuarioRepository;

@Controller
public class CadastrarController {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public String cadastrar (@RequestParam("nome") String nome,@RequestParam("emailUsuario") String emailUsuario,
							@RequestParam("senha") String senha ) {
		
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setEmail(emailUsuario);
		usuario.setSenha(senha);
		usuarioRepository.save(usuario);
		
		
		return "cadastro";
	}
	
}
