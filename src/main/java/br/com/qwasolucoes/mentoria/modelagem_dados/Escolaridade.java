package br.com.qwasolucoes.mentoria.modelagem_dados;

import java.util.List;
import java.util.Objects;

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

	public Instituicao getInstituicao() {
	    if (instituicao == null || instituicao.isEmpty()) {
	        return null;
	    }
	    return instituicao.get(0);
	}


	public void setInstituicao(List<Instituicao> instituicao) {
		this.instituicao = instituicao;
	}
	
	public void setInstituicao(Instituicao instituicao) {
	    if (instituicao == null) {
	        this.instituicao = null;
	    } else {
	        this.instituicao = java.util.Arrays.asList(instituicao);
	    }
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoInstituicao, concluido, cpfCnpj, dataTermino, instituicao, semestreAtual);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Escolaridade other = (Escolaridade) obj;
		return Objects.equals(codigoInstituicao, other.codigoInstituicao) && Objects.equals(concluido, other.concluido)
				&& Objects.equals(cpfCnpj, other.cpfCnpj) && Objects.equals(dataTermino, other.dataTermino)
				&& Objects.equals(instituicao, other.instituicao) && Objects.equals(semestreAtual, other.semestreAtual);
	}

}
