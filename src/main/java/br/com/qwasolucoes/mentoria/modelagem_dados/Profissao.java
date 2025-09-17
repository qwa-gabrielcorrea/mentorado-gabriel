package br.com.qwasolucoes.mentoria.modelagem_dados;

public class Profissao {
	private String codigoProfissao;
	private String nomeProfissao;
	private String areaAtuação;
	private String salarioBase;

	public String getCodigoProfissao() {
		return codigoProfissao;
	}

	public void setCodigoProfissao(String codigoProfissao) {
		this.codigoProfissao = codigoProfissao;
	}

	public String getNomeProfissao() {
		return nomeProfissao;
	}

	public void setNomeProfissao(String nomeProfissao) {
		this.nomeProfissao = nomeProfissao;
	}

	public String getAreaAtuação() {
		return areaAtuação;
	}

	public void setAreaAtuação(String areaAtuação) {
		this.areaAtuação = areaAtuação;
	}

	public String getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(String salarioBase) {
		this.salarioBase = salarioBase;
	}

}
