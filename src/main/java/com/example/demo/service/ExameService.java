package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ExameEntity;
import com.example.demo.repository.ExameRealizadoRepository;
import com.example.demo.repository.ExameRepository;

@Service
public class ExameService {
	@Autowired
	ExameRepository repository;
	
	@Autowired
	ExameRealizadoRepository exameRealizadoRepository;

	public ExameEntity create(ExameEntity obj) {
		repository.save(obj);
		return obj;
	}

	public ExameEntity findById(Integer id) {
		Optional<ExameEntity> exame = repository.findById(id);
		return exame.orElse(null);
	}

	public List<ExameEntity> findAll() {
		return repository.findAll();
	}

	public boolean update(ExameEntity obj) {
		if (repository.existsById(obj.getId())) {
			repository.save(obj);
			return true;
		}
		return false;
	}

	public boolean delete(Integer id) {
		ExameEntity exame = repository.findById(id).get();
		if (exameRealizadoRepository.findByExame(exame).isEmpty()) {
			repository.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}

}
