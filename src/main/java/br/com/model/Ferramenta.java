package br.com.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.enumUtil.StatusEnum;

/**
 * Classe Modelo de Ferramenta
 * @author Carvalho
 * @since  20/11/2017
 * @version 1.0
 */
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
	
	@NotNull(message = "Favor preencher o número do patrimônio")
	@Column
	private Long patrimonio;
	
	@NotEmpty(message = "Favor preencher o nome da ferramenta")
	@Size(max = 30, message = "O nome da ferramenta não pode conter mais do que 30 caracteres")
	@Column
	private String nome;
	
	@Enumerated(EnumType.STRING)
	private StatusEnum status;

	/** DateTimeFormat
	 * anotação aproveitada pelo thymeleaf na view
	 *  **/
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataCadastrada;
	
	
	public boolean isEmprestado() {
		return StatusEnum.EMPRESTADO.equals(this.status);
	}
	
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
	public StatusEnum getStatus() {
		return status;
	}
	public void setStatus(StatusEnum status) {
		this.status = status;
	}
	public Date getDataCadastrada() {
		return dataCadastrada;
	}
	public void setDataCadastrada(Date dataCadastrada) {
		this.dataCadastrada = dataCadastrada;
	}
	
}
