package br.com.techschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CadastrarController {

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public String cadastrar () {
		
		
		
		return "cadastro";
	}
	
}
