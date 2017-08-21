package br.com.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Empresa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -346365797949201306L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String nome;
	
	@OneToMany
	@JoinColumn(name="empresa_id")
	private List<Funcionario > funcionario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Funcionario> getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(List<Funcionario> funcionario) {
		this.funcionario = funcionario;
	}
	
}
