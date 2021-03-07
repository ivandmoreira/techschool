package br.com.techschool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.techschool.dto.ProdutoDto;
import br.com.techschool.modelo.Produto;
import br.com.techschool.persistencia.ProdutoRepository;

@Controller
public class HelloController {

	@Autowired
	private ProdutoRepository repository;
	@GetMapping("/hello")
	public String hello(Model model) {
		
//		Produto produto = new Produto();
//		produto.setNome("iphone");
//		repository.salvar(produto);
		try {
			List<Produto> produtos =  repository.findAll();
			for (Produto produto : produtos) {
				System.out.println(produto.getNome());
			}
		} catch (Exception e) {
			System.out.println("Erro apresentado " + e.getMessage() );
		}
		
		return "hello";
	}
	@RequestMapping (method = RequestMethod.POST, value="/hello")
	public String grava(ProdutoDto produtoDto) {
		
		Produto produto = new Produto();
		produto.setNome(produtoDto.getNome());
		
		System.out.println(produto.getNome());
		
		return "hello";
	}
	
}
