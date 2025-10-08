package br.com.qwasolucoes.mentoria.implementacoes.algoritmos;

import br.com.qwasolucoes.mentoria.interfaces.algoritmos.Recursao;

public class RecursaoProvider implements Recursao{

	@Override
	public int recursao(int valor, int limite) {
		 
		return 0;
	}

	@Override
	public int recursaoSoma(int valor, int limite) {
		 
		return 0;
	}

	@Override
	public int recursaoFibonacci(int valor, int limite) {
		 
		return 0;
	}
	
	public int iterativoFibonacci(int valor) {
		 
		int antecessor = 0;
        int preAntecessor;
        int atual = 1;

        if (valor == 0 || valor == 1) {
            return valor;
        } else {
            for (int i = 2; i <= valor; i++) {
                preAntecessor = antecessor; 
                antecessor = atual;
                atual = preAntecessor + antecessor;
            }
        }

        return atual;
	}

}
