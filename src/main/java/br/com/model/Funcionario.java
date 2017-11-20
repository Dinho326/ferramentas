package br.com.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Classe Modelo de Funcionário
 * @author Carvalho
 * @since  20/11/2017
 * @version 1.0
 */
@Entity
public class Funcionario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull(message = "Favor preencher a matrícula do Funcionário")
	@Column
	private Long matricula;
	
	@NotEmpty(message = "Favor preencher o nome do Funcionário")
	@Column
	private String nome;
	
	@NotNull(message = "Favor  selecionar a empresa do Funcionário")
	@ManyToOne(fetch = FetchType.EAGER)
	private Empresa empresa;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column
	private Date dataCadastrada;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Date getDataCadastrada() {
		return dataCadastrada;
	}

	public void setDataCadastrada(Date dataCadastrada) {
		this.dataCadastrada = dataCadastrada;
	}
}
