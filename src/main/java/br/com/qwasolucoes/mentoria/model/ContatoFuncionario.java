package br.com.qwasolucoes.mentoria.model;

public class ContatoFuncionario {

	/**
	 * 0 - telefone
	 * 1 - celular
	 * 2 - email
	 */
	private int tipo;
	
	private String valor;

	public int getTipo() {
		return tipo;
	}

	public String getValor() {
		return valor;
	}
	
}
