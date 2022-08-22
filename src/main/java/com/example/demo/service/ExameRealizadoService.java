package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ExameRealizadoEntity;
import com.example.demo.repository.ExameRealizadoRepository;

@Service
public class ExameRealizadoService {

	@Autowired
	ExameRealizadoRepository repository;

	public Boolean create(ExameRealizadoEntity obj) {
		if (repository.verificaExameRealizado(obj.getDtExame(), obj.getExame().getId(), obj.getFuncionario().getId()) == null) {
			repository.save(obj);
			return true;
		}
		else {
			return false;
		}
	}

	public ExameRealizadoEntity findById(Integer id) {
		Optional<ExameRealizadoEntity> exame = repository.findById(id);
		return exame.orElse(null);
	}

	public List<ExameRealizadoEntity> findAll() {
		return repository.findAll();
	}

	public boolean update(ExameRealizadoEntity obj) {
		if (repository.existsById(obj.getId())) {
			repository.save(obj);
			return true;
		}
		return false;
	}

	public boolean delete(Integer id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
		}
		return false;
	}
	
}
