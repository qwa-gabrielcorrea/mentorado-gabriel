package br.com.qwasolucoes.mentoria.implementacoes.algoritmos;

import br.com.qwasolucoes.mentoria.interfaces.algoritmos.Recursao;

public class RecursaoProvider implements Recursao{

	@Override
	public int recursao(int valor, int limite) {
		
        if (valor == limite){
            return valor;
        }
        
        return recursao(valor, limite - 1);
	}

	@Override
	public int recursaoSoma(int valor, int limite) {

        if (limite == valor){
            return valor;
        }
        
        return recursaoSoma(valor, limite - 1) + limite;
	}

	@Override
	public int recursaoFibonacci(int valor, int limite) {
		
        if (valor > limite) {
            return valor;
        }

        return valor + recursaoFibonacci(valor + 1, limite);
	}
	
	public int iterativoFibonacci(int valor) {

		if (valor <= 0) {
            return 0;
        }
        if (valor == 1) {
            return 1;
        }

        int posicao = 2;
        int numAtual;
        int anterior = 1;
        int penultimo = 1;

        while (posicao < valor) {

            numAtual = anterior + penultimo;
            penultimo = anterior;
            anterior = numAtual;
            posicao++;
        }

        return anterior;

	}

}
