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
	  "SELECT                           " +
	  "  *                              " +
	  "FROM                             " +
 	  "  EXAME_REALIZADO                " +
	  "WHERE                            " +
	  "  EXAME_REALIZADO_DATA = ?1      " +
      "AND                              " +
	  "  EXAME_EXAME_ID = ?2            " +
	  "AND                              " +
	  "  FUNCIONARIO_FUNCIONARIO_ID = ?3 ;",
	nativeQuery = true)
	ExameRealizadoEntity verificaExameRealizado(String dtExame, Integer idExame, Integer idFuncionario);

	@Query(value = 
	  "SELECT                           " +
	  "  *                              " +
	  "FROM                             " +
 	  "  EXAME_REALIZADO                " +
	  "WHERE                            " +
	  "  EXAME_REALIZADO_DATA           " +
      "BETWEEN                          " +
	  "  ?1 AND ?2",
	nativeQuery = true)
	List<ExameRealizadoEntity> consultaRelatorio(String deDtExame, String ateDtExame);
	
	@Query(value = 
	  "SELECT                                   " +
	  "  *                                      " +
	  "FROM                                     " +
	  "  EXAME_REALIZADO                        " +
	  "LEFT JOIN                                " +
	  "  EXAME ON EXAME_EXAME_ID = EXAME_ID     " +
	  "WHERE                                    " +
	  " EXAME_NOME LIKE ?1 ;",	  	
	nativeQuery = true)
	List<ExameRealizadoEntity> consultaPorNomeExame(String nome);
	
	
	
	@Query(value = 
	  "SELECT                                                       " +
	  "  *                                                          " +
	  "FROM                                                         " +
	  "  EXAME_REALIZADO                                            " +
	  "LEFT JOIN                                                    " +
	  "  FUNCIONARIO ON FUNCIONARIO_ID = FUNCIONARIO_FUNCIONARIO_ID " +
	  "WHERE                                                        " +
	  " FUNCIONARIO_NOME LIKE ?1 ;",	  	
	nativeQuery = true)
	List<ExameRealizadoEntity> consultaPorNomeFuncionario(String nome);
	
	
	
	@Query(value = 
	  "SELECT                                           " +
	  "  EXAME_EXAME_ID                                 " +
	  "FROM                                             " +
	  "  EXAME_REALIZADO                                " +
	  "WHERE                                            " +
	  "  EXAME_REALIZADO_DATA                           " +
	  "BETWEEN ?1 AND ?2                                " +
	  "GROUP BY EXAME_EXAME_ID                          " +
	  "HAVING COUNT(EXAME_EXAME_ID) > 1                 " +
	  "ORDER BY count(EXAME_EXAME_ID) DESC LIMIT 5;     ",   	
	nativeQuery = true)
	List<Integer> consultaTop5(String dtDe, String dtAte);
	
	
	
}
