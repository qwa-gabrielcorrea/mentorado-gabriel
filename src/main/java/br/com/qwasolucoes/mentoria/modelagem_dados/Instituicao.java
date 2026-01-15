package br.com.qwasolucoes.mentoria.modelagem_dados;

import java.util.List;
import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(areaAtuacao, codigo, formacoes, nome, quantidadeSemestre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Instituicao other = (Instituicao) obj;
		return Objects.equals(areaAtuacao, other.areaAtuacao) && Objects.equals(codigo, other.codigo)
				&& Objects.equals(formacoes, other.formacoes) && Objects.equals(nome, other.nome)
				&& Objects.equals(quantidadeSemestre, other.quantidadeSemestre);
	}

}
