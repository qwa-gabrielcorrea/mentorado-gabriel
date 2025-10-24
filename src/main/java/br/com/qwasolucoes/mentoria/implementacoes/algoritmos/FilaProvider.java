package br.com.qwasolucoes.mentoria.implementacoes.algoritmos;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

import br.com.qwasolucoes.mentoria.interfaces.algoritmos.Fila;

public class FilaProvider implements Fila {

    List<Object> lista = new ArrayList<>();

	@Override
	public void remover() {

        if (this.lista.isEmpty()) {
            throw new EmptyStackException();
        }

        this.lista.remove(this.lista.get(0));		 
		
	}

	@Override
	public void adicionar(Object elemento) {
		 
        this.lista.add(elemento);
		
	}

	@Override
	public List todos() {

        if (this.lista.isEmpty()) {
            throw new EmptyStackException();
        }

        return lista;
	}

	@Override
	public Object obter(int indice) {

        if (this.lista.isEmpty()) {
            throw new EmptyStackException();
        }

        if (indice <= this.lista.size()) {
            return this.lista.get(indice);
        }

        throw new NullPointerException();
	}

}