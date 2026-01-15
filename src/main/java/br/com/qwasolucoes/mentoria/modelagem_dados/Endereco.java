package br.com.qwasolucoes.mentoria.modelagem_dados;

import java.util.Objects;

public class Endereco {
	private String cpfCnpj;
	private String tipoEndereço;
	private String pais;
	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private String complementoCep;

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getTipoEndereço() {
		return tipoEndereço;
	}

	public void setTipoEndereço(String tipoEndereço) {
		this.tipoEndereço = tipoEndereço;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplementoCep() {
		return complementoCep;
	}

	public void setComplementoCep(String complementoCep) {
		this.complementoCep = complementoCep;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bairro, cep, cidade, complementoCep, cpfCnpj, estado, numero, pais, rua, tipoEndereço);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep)
				&& Objects.equals(cidade, other.cidade) && Objects.equals(complementoCep, other.complementoCep)
				&& Objects.equals(cpfCnpj, other.cpfCnpj) && Objects.equals(estado, other.estado)
				&& Objects.equals(numero, other.numero) && Objects.equals(pais, other.pais)
				&& Objects.equals(rua, other.rua) && Objects.equals(tipoEndereço, other.tipoEndereço);
	}

}
