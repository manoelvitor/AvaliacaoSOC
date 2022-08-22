package com.example.demo.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.FuncionarioEntity;
import com.example.demo.service.FuncionarioService;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioRestController {
	
	@Autowired
	FuncionarioService service;
	
	@GetMapping
	public ResponseEntity<List<FuncionarioEntity>> getAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> get(@PathVariable("id") Integer id) {
		FuncionarioEntity funcionario = service.findById(id);
		if (funcionario != null) {
			return ResponseEntity.ok(funcionario);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@PostMapping
	public ResponseEntity<FuncionarioEntity> post(@Validated @RequestBody FuncionarioEntity obj) {
		service.create(obj);
		return ResponseEntity.ok(obj);
	}
	
	@PutMapping
	public ResponseEntity<?> put(@RequestBody FuncionarioEntity obj) {
		if (service.update(obj)) {
			return ResponseEntity.ok(obj);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@DeleteMapping(value = "{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		FuncionarioEntity funcionario = service.findById(id);
		if (funcionario != null) {
			service.delete(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

}
