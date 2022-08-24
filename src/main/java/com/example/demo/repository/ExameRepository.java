package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ExameEntity;

@Repository
public interface ExameRepository extends JpaRepository<ExameEntity, Integer> {

	@Query(value = 
	  "SELECT                           " +
	  "  *                              " +
	  "FROM                             " +
	  "  EXAME                          " +
	  "WHERE                            " +
	  "  EXAME_NOME                     " +
	  "LIKE                             " +
	  "   ?1                            " ,
	nativeQuery = true)
	List<ExameEntity> consultaPorNome(String nome);
	
}
