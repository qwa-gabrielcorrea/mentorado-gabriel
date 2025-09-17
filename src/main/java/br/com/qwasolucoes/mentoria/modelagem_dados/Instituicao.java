package br.com.qwasolucoes.mentoria.modelagem_dados;

import java.util.List;

public class Instituicao {
	private List<Escolaridade> formacoes;
	private String codigo;
	private String nome;
	private String areaAtuacao;
	private String quantidadeSemestre;

	public List<Escolaridade> getFormacoes() {
		return formacoes;
	}

	public void setFormacoes(List<Escolaridade> formacoes) {
		this.formacoes = formacoes;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}

	public String getQuantidadeSemestre() {
		return quantidadeSemestre;
	}

	public void setQuantidadeSemestre(String quantidadeSemestre) {
		this.quantidadeSemestre = quantidadeSemestre;
	}

}
