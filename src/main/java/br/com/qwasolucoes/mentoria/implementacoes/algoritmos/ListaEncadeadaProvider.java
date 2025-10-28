package br.com.qwasolucoes.mentoria.implementacoes.algoritmos;

import java.util.ArrayList;
import java.util.List;

import br.com.qwasolucoes.mentoria.interfaces.algoritmos.ListaEncadeada;

public class ListaEncadeadaProvider implements ListaEncadeada {

	private int tamanho; 
	private Node head;
	private Node tail;

	public ListaEncadeadaProvider(){
		this.tamanho = 0; 
	}

	List<Object> listaEncadeada = new ArrayList<>();


	@Override
	public void remover() {

	}

	@Override
	public void adicionar(Object elemento) {

		Node novoNo = new Node(elemento);

		if(this.head == null && this.tail == null){
			this.head = novoNo;
			this.tail = novoNo;
		} else {
			this.tail.setNext(novoNo);
			this.tail = novoNo;
		}

		this.tamanho ++;
		listaEncadeada.add(novoNo);

	}

	@Override
	public List todos() {

		return listaEncadeada;
	}

	@Override
	public Object obter(int indice) {

		Node atual = this.head;
		for (int i = 0; i < indice; i++){
			if(atual.getNext() != null){
				atual = atual.getNext();
			}
		}

		return atual;
	}

}