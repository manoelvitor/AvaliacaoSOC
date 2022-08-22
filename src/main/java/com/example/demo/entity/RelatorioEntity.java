package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class RelatorioEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String dtDe;
	private String dtAte;
	
	public String getDtDe() {
		return dtDe;
	}
	public void setDtDe(String dtDe) {
		this.dtDe = dtDe;
	}
	public String getDtAte() {
		return dtAte;
	}
	public void setDtAte(String dtAte) {
		this.dtAte = dtAte;
	}
	public RelatorioEntity() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	
	
}
