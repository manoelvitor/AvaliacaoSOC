package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

@Entity
@Table(name = "EXAME_REALIZADO")
public class ExameRealizadoEntity implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EXAME_REALIZADO_ID", nullable = false)
	private Integer id;
	
	@OneToOne
	@NotNull
	private FuncionarioEntity funcionario;
	
	@ManyToOne
	@NotNull
	private ExameEntity exame;

	@Column(name = "EXAME_REALIZADO_DATA", nullable = false)
	private String dtExame;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public FuncionarioEntity getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(FuncionarioEntity funcionario) {
		this.funcionario = funcionario;
	}

	public ExameEntity getExame() {
		return exame;
	}

	public void setExame(ExameEntity exame) {
		this.exame = exame;
	}

	public String getDtExame() {
		return dtExame;
	}

	public void setDtExame(String dtExame) {
		this.dtExame = dtExame;
	}
	
	public ExameRealizadoEntity(FuncionarioEntity funcionario, ExameEntity exame, String dtExame) {
		this.funcionario = funcionario;
		this.exame = exame;
		this.dtExame = dtExame;
	}

	public ExameRealizadoEntity() {
		
	}

	
	
	
	
	
	
	
}
