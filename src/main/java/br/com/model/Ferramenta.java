package br.com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ferramenta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Ferramenta() {
		
	}
	public Ferramenta(Long patrimonio, String nome) {
		super();
		this.patrimonio = patrimonio;
		this.nome = nome;
	}

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private Long patrimonio;
	
	@Column
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPatrimonio() {
		return patrimonio;
	}

	public void setPatrimonio(Long patrimonio) {
		this.patrimonio = patrimonio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
