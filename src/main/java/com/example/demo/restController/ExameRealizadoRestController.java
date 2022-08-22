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

import com.example.demo.entity.ExameRealizadoEntity;
import com.example.demo.service.ExameRealizadoService;

@RestController
@RequestMapping(value = "/exameRealizados")
public class ExameRealizadoRestController {
	
	@Autowired
	ExameRealizadoService service;
	
	@GetMapping
	public ResponseEntity<List<ExameRealizadoEntity>> getAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> get(@PathVariable("id") Integer id) {
		ExameRealizadoEntity exameRealizado = service.findById(id);
		if (exameRealizado != null) {
			return ResponseEntity.ok(exameRealizado);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@PostMapping
	public ResponseEntity<?> post(@Validated @RequestBody ExameRealizadoEntity obj) {
		Boolean salvo = service.create(obj);
		if(!salvo) {
			return ResponseEntity.ok().body("REGISTRO JÁ EXISTENTE");
		}
		return ResponseEntity.ok(obj);
	}
	
	@PutMapping
	public ResponseEntity<?> put(@RequestBody ExameRealizadoEntity obj) {
		if (service.update(obj)) {
			return ResponseEntity.ok(obj);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@DeleteMapping(value = "{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		ExameRealizadoEntity exameRealizado = service.findById(id);
		if (exameRealizado != null) {
			service.delete(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

}
