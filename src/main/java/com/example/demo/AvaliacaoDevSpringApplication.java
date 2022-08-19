package com.example.demo;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.ExameEntity;
import com.example.demo.entity.ExameRealizadoEntity;
import com.example.demo.entity.FuncionarioEntity;
import com.example.demo.repository.ExameRealizadoRepository;
import com.example.demo.repository.ExameRepository;
import com.example.demo.repository.FuncionarioRepository;

@SpringBootApplication
public class AvaliacaoDevSpringApplication implements CommandLineRunner {
	
	@Autowired
	private ExameRepository exameRepository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private ExameRealizadoRepository exameRealizadoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(AvaliacaoDevSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ExameEntity exame1 =  new ExameEntity("HEMOGRAMA");
		ExameEntity exame2 =  new ExameEntity("URINA");
		ExameEntity exame3 =  new ExameEntity("HCG");
		ExameEntity exame4 =  new ExameEntity("ESCARRO");
		ExameEntity exame5 =  new ExameEntity("PARASITOLÓGICO ");
		
		exameRepository.saveAll(Arrays.asList(exame1, exame2, exame3, exame4, exame5));
		
		FuncionarioEntity func1 =  new FuncionarioEntity("Maria da Silva");
		FuncionarioEntity func2 =  new FuncionarioEntity("José de Souza");
		FuncionarioEntity func3 =  new FuncionarioEntity("Carlos dos Santos");
		FuncionarioEntity func4 =  new FuncionarioEntity("Beatriz de Oliveira");
		FuncionarioEntity func5 =  new FuncionarioEntity("Juliana Pereira");
		
		funcionarioRepository.saveAll(Arrays.asList(func1, func2, func3, func4, func5));
		
		
		ExameRealizadoEntity ex1 = new ExameRealizadoEntity(func1,exame1, "2022-10-10" );	
		ExameRealizadoEntity ex2 = new ExameRealizadoEntity(func2,exame2, "2022-11-25" );		
		ExameRealizadoEntity ex3 = new ExameRealizadoEntity(func3,exame3, "2022-12-08" );		
		ExameRealizadoEntity ex4 = new ExameRealizadoEntity(func4,exame4, "2022-10-09" );		
		ExameRealizadoEntity ex5 = new ExameRealizadoEntity(func5,exame5, "2022-01-10" );		

		exameRealizadoRepository.saveAll(Arrays.asList(ex1,ex2,ex3,ex4,ex5));
	

	}



}
