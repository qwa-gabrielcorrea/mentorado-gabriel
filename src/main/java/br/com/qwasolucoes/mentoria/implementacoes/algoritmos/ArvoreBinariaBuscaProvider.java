package br.com.qwasolucoes.mentoria.implementacoes.algoritmos;

import br.com.qwasolucoes.mentoria.interfaces.algoritmos.ArvoreBinariaBusca;

public class ArvoreBinariaBuscaProvider implements ArvoreBinariaBusca {

	private NodeObj raiz;

	@Override
	public void inserir(int elemento) {
		 
		
	}

	@Override
	public int[] todosOrdenado() {
		 
		return null;
	}

	@Override
	public int[] preOrdem() {
		 
		return null;
	}

	@Override
	public int[] posOrdem() {
		 
		return null;
	}

	@Override
	public int primeiro() {

		if (raiz == null){
			return -1;
		}

		NodeObj atual = raiz; 
		
		while(atual.getPrevious() != null){
			atual = atual.getPrevious();
		}

		return atual.getValue();
	}

	@Override
	public int ultimo() {

		if (raiz == null){
			return -1;
		}

		NodeObj atual = raiz;

		while(atual.getNext() != null){
			atual = atual.getNext();
		}

		return atual.getValue();
	}

}