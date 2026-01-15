package br.com.qwasolucoes.mentoria.modelagem_dados;

import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(areaAtuação, codigoProfissao, nomeProfissao, salarioBase);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profissao other = (Profissao) obj;
		return Objects.equals(areaAtuação, other.areaAtuação) && Objects.equals(codigoProfissao, other.codigoProfissao)
				&& Objects.equals(nomeProfissao, other.nomeProfissao) && Objects.equals(salarioBase, other.salarioBase);
	}

}
