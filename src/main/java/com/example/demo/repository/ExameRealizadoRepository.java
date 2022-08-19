package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ExameEntity;
import com.example.demo.entity.ExameRealizadoEntity;
import com.example.demo.entity.FuncionarioEntity;

@Repository
public interface ExameRealizadoRepository extends JpaRepository<ExameRealizadoEntity, Integer> {

	List<ExameRealizadoEntity> findByFuncionario(FuncionarioEntity funcionario);

	List<ExameRealizadoEntity> findByExame(ExameEntity exame);

	@Query(value = 
	  "SELECT							" +
	  "  *   							" +
	  "FROM								" +
 	  "  EXAME_REALIZADO				" +
	  "WHERE 							" +
	  "  EXAME_REALIZADO_DATA = ?1 		" +
      "AND 								" +
	  "  EXAME_EXAME_ID = ?2 			" +
	  "AND 								" +
	  "  FUNCIONARIO_FUNCIONARIO_ID = ?3 ;",
	nativeQuery = true)
	ExameRealizadoEntity verificaExameRealizado(String dtExame, Integer idExame, Integer idFuncionario);

	@Query(value = 
	  "SELECT							" +
	  "  *   							" +
	  "FROM								" +
 	  "  EXAME_REALIZADO				" +
	  "WHERE 							" +
	  "  EXAME_REALIZADO_DATA  		    " +
      "BETWEEN  						" +
	  "  ?1 AND ?2",
	nativeQuery = true)
	List<ExameRealizadoEntity> consultaRelatorio(String deDtExame, String ateDtExame);

	
}
