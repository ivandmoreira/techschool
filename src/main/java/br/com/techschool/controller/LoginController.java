package br.com.techschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public String logar() {
		
		System.out.println("teste");
		
		return "login";
	}
	
}
