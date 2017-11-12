package br.com.enumUtil;

public enum EmpresaEnum {

	MASTER("Master Reforma Engenharia", "39.995.501/0001-90"),
	GABI("Gabi Telhados Colonial","63.190.457/0001-26"),
	AJA("AJA - Projetos e Construções", "50.581.318/0001-81"),
	PITA("Pitta Construções", "45.391.985/0001-61"),
	FERNANDA("Fernandes Correa Construção Civil E Reformas", "71.235.408/0001-90"),
	RENOVA("Renova Drywall", "37.894.476/0001-23"),
	GEO("Geonova Topografia", "31.936.702/0001-05"),
	AS("As Engenharia", "82.378.548/0001-34"),
	NOVA("Nova Era Engenharia e Arquitetura", "87.288.351/0001-28"),
	MG("Mg Serviços E Reformas", "48.598.284/0001-96"),
	PARQ("Parq Arquitetura", "05.938.765/0001-90"),
	NAT("Nathália Martins", "63.297.179/0001-00"),
	LEMA("Lemarg Projetos E Servicos", "63.159.522/0001-50"),
	RJS("Rjs Construções E Reformas Ltda", "88.653.802/0001-41"),
	PROJ("iProjeta Arquitetura Sustentável", "40.516.589/0001-08"),
	LEAN("4lean Engenharia E Gestão", "99.170.947/0001-08"),
	VANE("Vanessa Soares Arquitetura", "99.841.378/0001-85"),
	ONIX("Onix Arquitetura", "10.892.610/0001-09"),
	FA("Fa Construções", "75.043.635/0001-75"),
	JM("Jm Reformas E Construçoes", "86.944.512/0001-21");
	
	private String nome;
	private String cnpj;
	
	EmpresaEnum(String nome, String cnpj){
		this.nome = nome;
		this.cnpj = cnpj;
	}
	
	public String getNome() {
		return nome;
	}

	public String getCnpj() {
		return cnpj;
	}

}
