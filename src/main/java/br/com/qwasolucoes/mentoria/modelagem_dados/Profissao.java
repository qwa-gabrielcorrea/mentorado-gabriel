package br.com.qwasolucoes.mentoria.modelagem_dados;

public class Profissao {
	private String codigoProfissao;
	private String nomeProfissao;
	private String areaAtuacao;
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

	public String getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtucao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}

	public String getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(String salarioBase) {
		this.salarioBase = salarioBase;
	}

}
