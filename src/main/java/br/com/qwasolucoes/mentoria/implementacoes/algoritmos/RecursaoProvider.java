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

		int numAtual = valor;
        
        if (valor == 0 || valor == 1) {
            return valor;
        }

        if (numAtual >= limite){
            return valor;
        }

        numAtual = (valor - 1) + (valor -2);

        return recursaoFibonacci(numAtual, limite);
	}
	
	public int iterativoFibonacci(int valor) {

		int numAtual = 0; 
        int ultimo = 1; 
        int penultimo = 0;

        for (int i = 0; i <= valor; i++){
            numAtual = ultimo + penultimo;
            penultimo = ultimo; 
            ultimo = numAtual;
        }

        return numAtual;
	}

}
