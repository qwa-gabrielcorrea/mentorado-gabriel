package br.com.qwasolucoes.mentoria.implementacoes.algoritmos;

import br.com.qwasolucoes.mentoria.interfaces.algoritmos.Recursao;

public class RecursaoProvider implements Recursao{

	@Override
	public int recursao(int valor, int limite) {
		
		if (valor == limite){
            return valor;
        }
        
        return recursao(valor + 1, limite);
	}

	@Override
	public int recursaoSoma(int valor, int limite) {

        int resultado = valor;
        if (valor >= limite){
            return resultado;
        }
        
        return recursaoSoma(resultado + valor, limite); 
	}

	@Override
	public int recursaoFibonacci(int valor, int limite) {
		
        if (valor > limite) {
            return 0;
        }

        return valor + recursaoFibonacci(valor + 1, limite);
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
