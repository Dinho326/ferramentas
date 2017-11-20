package br.com.enumUtil;
/**
 * Enum responsável por retornar 
 * a descrição do status de uma ferramenta
 * @author Carvalho
 * @since  20/11/2017
 * @version 1.0
 */
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
