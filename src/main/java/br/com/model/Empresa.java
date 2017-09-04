package br.com.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Empresa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -346365797949201306L;

	@Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty(message = "Favor preencher o cnpj da empresa")
	@Column
	private String cnpj;
	
	@NotEmpty(message = "Favor preencher o nome da empresa")
	@Size(max = 50, 
	message = "O nome da Empresa não pode conter mais do que 50 caracteres")
	@Column
	private String nome;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataCadastrada;
	
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

	public Date getDataCadastrada() {
		return dataCadastrada;
	}

	public void setDataCadastrada(Date dataCadastrada) {
		this.dataCadastrada = dataCadastrada;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
}
