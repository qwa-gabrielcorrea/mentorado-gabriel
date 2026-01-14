package br.com.qwasolucoes.mentoria.modelagem_dados;

import java.util.List;

public class Escolaridade {
	private String cpfCnpj;
	private String codigoInstituicao;
	private String concluido;
	private String dataTermino;
	private String semestreAtual;
	private List<Instituicao> instituicao;

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getCodigoInstituicao() {
		return codigoInstituicao;
	}

	public void setCodigoInstituicao(String codigoInstituicao) {
		this.codigoInstituicao = codigoInstituicao;
	}

	public String getConcluido() {
		return concluido;
	}

	public void setConcluido(String concluido) {
		this.concluido = concluido;
	}

	public String getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(String dataTermino) {
		this.dataTermino = dataTermino;
	}

	public String getSemestreAtual() {
		return semestreAtual;
	}

	public void setSemestreAtual(String semestreAtual) {
		this.semestreAtual = semestreAtual;
	}

	public List<Instituicao> getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(List<Instituicao> instituicao) {
		this.instituicao = instituicao;
	}

}
