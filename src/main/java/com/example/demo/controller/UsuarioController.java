package com.example.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UsuarioEntity;
import com.example.demo.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository service;

	@PostMapping
	public ResponseEntity<UsuarioEntity> post(@RequestBody UsuarioEntity obj) {
		return ResponseEntity.ok(service.save(obj));
	}
	

	
	
}
