package br.com.enumUtil;

public enum StatusEnum {

	DISPONIVEL("Disponível"),
	EMPRESTADO("Emprestado");
	
	private String descricao;
	
	StatusEnum(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
