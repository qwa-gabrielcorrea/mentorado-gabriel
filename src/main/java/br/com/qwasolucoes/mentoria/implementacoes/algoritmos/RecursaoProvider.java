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
		 
		int auxiliar = valor;

        if (valor >= 2) {
            while (valor <= limite) {
                auxiliar = recursaoFibonacci((valor - 1), limite) + recursaoFibonacci((valor - 2), limite);
            }
        }

        return auxiliar;
	}
	
	public int iterativoFibonacci(int valor) {
		 
		int ultimo = 0;
        int penultimo;
        int atual = 1;

        for (int i = 0; i <= valor; i++) {

            if (valor == 0 || valor == 1) {
                return valor;
            }
            penultimo = ultimo;
            ultimo = atual;
            atual = penultimo + ultimo;

            System.out.println(atual);

        }

        return atual;
	}

}
