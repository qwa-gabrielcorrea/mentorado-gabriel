package br.com.qwasolucoes.mentoria.implementacoes.algoritmos;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

import br.com.qwasolucoes.mentoria.interfaces.algoritmos.Pilha;

public class PilhaProvider implements Pilha {

	List<Object> lista = new ArrayList<>();

	@Override
	public void empilhar(Object elemento) {
		 
        this.lista.add(elemento);
		
	}

	@Override
	public Object desempilhar() {
		 
		if (this.lista.isEmpty()) {
            throw new EmptyStackException();
        }

        return this.lista.remove(this.lista.size() - 1);
	}

	@Override
	public List obterTodos() {
		 
		if (this.lista.isEmpty()) {
            throw new EmptyStackException();
        }

        return lista;
	}

	
}