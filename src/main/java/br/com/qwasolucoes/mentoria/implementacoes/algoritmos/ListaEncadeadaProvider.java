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

	@Override
	public void remover() {

		if(this.head == null) return;

		if(this.head == this.tail){
			this.head == null; 
			this.tail == null; 
		} else {
			Node atual = this.head;
			while (atual.getNext() != this.tail) {
				atual = atual.getNext();
			}
			atual.setNext(null);
			this.tail = atual;
		}

		this.tamanho--;

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

	}

	@Override
	public List<Object> todos() {

		List<Object> listaEncadeada = new ArrayList<>();
		Node atual = this.head;

		while(atual != null){
			listaEncadeada.add(atual.getValue());
			atual = atual.getNext();
		}

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

		return atual.getValue();
	}

}