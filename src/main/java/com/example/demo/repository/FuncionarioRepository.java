package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.FuncionarioEntity;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Integer> {

	@Query(value = 
	  "SELECT                           " +
	  "  *                              " +
	  "FROM                             " +
 	  "  FUNCIONARIO                    " +
	  "WHERE                            " +
	  "  FUNCIONARIO_NOME               " +
	  "LIKE                             " +
	  "   ?1   " ,
	  nativeQuery = true)
	List<FuncionarioEntity> consultaPorNome(String nome);

}
