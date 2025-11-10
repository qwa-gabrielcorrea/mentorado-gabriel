package br.com.qwasolucoes.mentoria.implementacoes.algoritmos;

import java.util.ArrayList;
import java.util.List;

import br.com.qwasolucoes.mentoria.interfaces.algoritmos.ArvoreBinariaBusca;

public class ArvoreBinariaBuscaProvider implements ArvoreBinariaBusca {

	private NodeObj raiz;

	@Override
	public void inserir(int elemento) {
		 
		adicionaRecursivo(raiz, elemento);
		
	}

	@Override
	public int[] todosOrdenado() {
		 
		List<Integer> lista = new ArrayList<>();

		ordenado(raiz, lista);

		return converteListaEmArray(lista);
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

	private int[] converteListaEmArray (List<Integer> lista) {
		int[] vetor = new int[lista.size()];

		for (int i = 0; i < lista.size(); i++){
			vetor[i]~= lista.get(i);
		}

		return vetor;
	}

	private void ordenado(NodeObj atual, List<Integer> lista){

		if (atual != null){
			ordenado(atual.getPrevious(), lista);
			lista.add(atual.getValue());
			ordenado(atual.getNext(), lista);
		}
		
	}

	private NodeObj adicionaRecursivo (NodeObj atual, int valor){

		if (atual == null){
			return new NodeObj(valor);
		}

		if (valor < atual.getValue()) {
			atual.getPrevious() = adicionaRecursivo(atual.getPrevious, valor);
		} else if (valor > atual.getValue()){
			atual.getNext() = adicionaRecursivo(atual.getNext, valor);
		}
	}

}