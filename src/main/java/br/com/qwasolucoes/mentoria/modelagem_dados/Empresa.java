package br.com.qwasolucoes.mentoria.modelagem_dados;

import java.util.List;
import java.util.Objects;

public class Empresa {

	private List<Profissao> profissao;
	private String nome;
	private String codigoProfissao;
	private String cpfCnpj;

	public List<Profissao> getProfissao() {
		return profissao;
	}

	public void setProfissao(List<Profissao> profissao) {
		this.profissao = profissao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigoProfissao() {
		return codigoProfissao;
	}

	public void setCodigoProfissao(String codigoProfissao) {
		this.codigoProfissao = codigoProfissao;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoProfissao, cpfCnpj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		return Objects.equals(codigoProfissao, other.codigoProfissao) && Objects.equals(cpfCnpj, other.cpfCnpj);
	}

}
