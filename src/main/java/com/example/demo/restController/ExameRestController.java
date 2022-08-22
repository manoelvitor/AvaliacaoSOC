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

import com.example.demo.entity.ExameEntity;
import com.example.demo.service.ExameService;

@RestController
@RequestMapping(value = "/exames")
public class ExameRestController {

	@Autowired
	ExameService service;

	@GetMapping
	public ResponseEntity<List<ExameEntity>> getAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> get(@PathVariable("id") Integer id) {
		ExameEntity exame = service.findById(id);
		if (exame != null) {
			return ResponseEntity.ok(exame);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@PostMapping
	public ResponseEntity<ExameEntity> post(@Validated @RequestBody ExameEntity obj) {
		service.create(obj);
		return ResponseEntity.ok(obj);
	}

	@PutMapping
	public ResponseEntity<?> put(@RequestBody ExameEntity obj) {
		if (service.update(obj)) {
			return ResponseEntity.ok(obj);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@DeleteMapping(value = "{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		ExameEntity exame = service.findById(id);
		if (exame != null) {
			service.delete(id);
			if (!service.delete(id)) {
				return ResponseEntity.ok()
						.body("NÃO FOI POSSIVEL EXCLUIR O EXAME, POIS ESTÁ SENDO UTILIZADO POR ALGUM FUNCIONÁRIO");
			} else {

			}
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

}
