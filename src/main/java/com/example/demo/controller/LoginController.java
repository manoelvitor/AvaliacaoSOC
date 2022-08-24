package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.ExameEntity;
import com.example.demo.entity.UsuarioEntity;
import com.example.demo.repository.ExameRealizadoRepository;
import com.example.demo.repository.ExameRepository;
import com.example.demo.repository.UsuarioRepository;

@Controller
public class LoginController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login"; 
	}
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout() {
		return "login"; 
	}
	
	@RequestMapping(value = "/logar", method = RequestMethod.POST)
	public String logar() {
		return "index";
	}
	
	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public String cadastrar() {
		return "cadastro";
	}


	@PostMapping(value = "/cadastrarUsuario")
	public String salvarAgendamento(UsuarioEntity usuario) {
		usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
		System.out.println(usuario.getLogin());
		usuarioRepository.save(usuario);
		return "redirect:/login";
	}

	

}
