package br.com.enumUtil;

public enum FuncionarioEnum {

	NOME1(" Luís Fernando",123),
	NOME2("Luís Filipe",456),
	NOME3("João Raphael",789),
	NOME4("José Paulo",987),
	NOME5("José Pedro",654),
	NOME6("Marcos André",321),
	NOME7("João Fernando",369),
	NOME8("Enzo Gabriel",258),
	NOME9("Luis Miguel",147),
	NOME10("Luís Gustavo",963),
	NOME11("Maria Eduarda",852),
	NOME12("Ana Brenda",741),
	NOME13("Ana Celine",357),
	NOME14("Ana Cristina",753),
	NOME15("Maria Joaquina",159),
	NOME16("Manuela Alves",951),
	NOME17("Lucas Gabriel",658),
	NOME18("Daniel Matheus",458),
	NOME19("Márcio Luís",125),
	NOME20("Edilson Carvalho",1);
	
	
	public String nome;
	public Integer matricula;
	FuncionarioEnum(String nome, int matricula){
		this.nome = nome;
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public Long getMatricula() {
		return Long.parseLong(matricula.toString());
	}
}
