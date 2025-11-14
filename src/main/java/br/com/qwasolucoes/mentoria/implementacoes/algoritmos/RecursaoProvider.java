package br.com.qwasolucoes.mentoria.implementacoes.algoritmos;

import br.com.qwasolucoes.mentoria.interfaces.algoritmos.Recursao;

public class RecursaoProvider implements Recursao {

    @Override
    public int recursao(int valor, int limite) {

        if (valor >= limite) {
            return 0;
        }

        return 1 + recursao(valor + 1, limite);
    }

    @Override
    public int recursaoSoma(int valor, int limite) {

        if (valor > limite) {
            return 0;
        }
        if (valor == limite) {
            return limite; 
        }

        return valor + recursaoSoma(valor + 1, limite);
    }

    @Override
    public int recursaoFibonacci(int valor, int limite) {

        if (valor > limite) {
            return -1;
        }

        if (valor <= 0) {
            return 0;
        }

        if (valor == 1) {
            return 1; 
        }

        return recursaoFibonacci(valor - 1, limite) + recursaoFibonacci(valor - 2, limite);
    }

    public int iterativoFibonacci(int valor) {

        if (valor < 0) {
            return -1;
        }

        if (valor == 0) {
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
