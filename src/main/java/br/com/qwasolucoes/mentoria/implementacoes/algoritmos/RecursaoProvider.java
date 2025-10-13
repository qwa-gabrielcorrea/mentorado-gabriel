package br.com.qwasolucoes.mentoria.implementacoes.algoritmos;

import br.com.qwasolucoes.mentoria.interfaces.algoritmos.Recursao;

public class RecursaoProvider implements Recursao{

	@Override
	public int recursao(int valor, int limite) {
		
		if (valor == 0) {
			return valor; 
		}
		
		if (valor >= limite){
			return limite;
		}

        int aux = valor + 1;

        return recursao(aux, limite);
	}

	@Override
	public int recursaoSoma(int valor, int limite) {
		 
		if (valor >= limite){
            return limite;
        }

        int n = valor + valor - 1;

        return recursao(n, limite);
	}

	@Override
	public int recursaoFibonacci(int valor, int limite) {
		
        if (valor > limite) {
            return 0;
        }

        return valor + recursaoFibonacci(valor + 1, limite - 1);
	}
	
	public int iterativoFibonacci(int valor) {

		int numAtual = 0; 
        int ultimo = 1; 
        int penultimo; 

        if (valor <= 0) {
            return 0;
        } else if (valor == 1){
            return numAtual;
        }

        for (int i = 2; i < valor; i ++){
            penultimo = numAtual + ultimo;
            numAtual = ultimo; 
            ultimo = penultimo;
        }

        return ultimo;
	}

}
