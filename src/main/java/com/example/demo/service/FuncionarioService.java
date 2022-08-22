package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ExameRealizadoEntity;
import com.example.demo.entity.FuncionarioEntity;
import com.example.demo.repository.ExameRealizadoRepository;
import com.example.demo.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	FuncionarioRepository repository;

	@Autowired
	ExameRealizadoRepository exRealizadoRepository;

	public FuncionarioEntity create(FuncionarioEntity obj) {
		repository.save(obj);
		return obj;
	}

	public FuncionarioEntity findById(Integer id) {
		Optional<FuncionarioEntity> exame = repository.findById(id);
		return exame.orElse(null);
	}

	public List<FuncionarioEntity> findAll() {
		return repository.findAll();
	}

	public boolean update(FuncionarioEntity obj) {
		if (repository.existsById(obj.getId())) {
			repository.save(obj);
			return true;
		}
		return false;
	}

	public void delete(Integer id) {
		if (repository.existsById(id)) {
			FuncionarioEntity funcionario = repository.findById(id).get();
			if (!exRealizadoRepository.findByFuncionario(funcionario).isEmpty()) {
				for (ExameRealizadoEntity exameRealizado : exRealizadoRepository.findByFuncionario(funcionario)) {
					exRealizadoRepository.deleteById(exameRealizado.getId());
				}
			}
			repository.deleteById(id);
		}
	}

}
