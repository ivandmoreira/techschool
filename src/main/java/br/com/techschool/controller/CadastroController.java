package br.com.techschool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.techschool.dto.CadastroDto;
import br.com.techschool.modelo.Endereco;
import br.com.techschool.modelo.Usuario;
import br.com.techschool.persistencia.EnderecoRepository;
import br.com.techschool.persistencia.UsuarioRepository;

@Controller
public class CadastroController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@RequestMapping(method = RequestMethod.GET, value = "/cadastro")
	public String cadastro(Model model) {
		List<Usuario> listaDeUsuarios = usuarioRepository.findAll();
		model.addAttribute("listaDeUsuarios", listaDeUsuarios);
		//for (Usuario usuario : listaDeUsuarios) {
		//	System.out.println(usuario);
		//}
		
		return "/cadastro";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/cadastro")
	public String cadastroSalvar(CadastroDto cadastroDto) {
		
		Usuario usuario = new Usuario();
		usuario.setNome(cadastroDto.getNome());
		usuario.setEmail(cadastroDto.getEmail());
		usuario.setSexo(cadastroDto.getSexo());
		
		Endereco endereco = new Endereco();
		endereco.setLogradouro(cadastroDto.getLogradouro());
		endereco.setNumero(cadastroDto.getNumero());
		endereco.setBairro(cadastroDto.getBairro());

		usuarioRepository.save(usuario);
		endereco.setUsuario(usuario);
		enderecoRepository.save(endereco);
		

		
		
		
		return "/cadastro";
	}
	
	
}
