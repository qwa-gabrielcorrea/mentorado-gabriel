package br.com.qwasolucoes.mentoria.implementacoes.algoritmos;

import br.com.qwasolucoes.mentoria.interfaces.algoritmos.Ordenacao;

public class OrdenacaoProvider implements Ordenacao {

	@Override
	public int[] ordenar(int[] elementos) {
		 
		return null;
	}

	@Override
	public int[] quicksort(int[] elementos) {
		 
		particaoQuicksort(elementos, 0, elementos.length - 1);
        
        return elementos;
	}

	@Override
	public int[] mergesort(int[] elementos) {
		 
		return null;
	}

	@Override
	public int[] bubbleSort(int[] elementos) {
		 
		int aux = elementos.length;
        boolean troca;

        for (int i = 0; i < aux - 1; i++) {
            troca = false;
            for (int j = 0; j < aux - 1; j++) {

                if (elementos[j] > elementos[j + 1]) {

                    int var = elementos[j];
                    elementos[j] = elementos[j + 1];
                    elementos[j + 1] = var;
                    troca = true;
                }
            }

            if (!troca) {
                break;
            }
        }

        return elementos;
	}

	@Override
	public int[] particaoPositivosNegativos(int[] valores) {
		 
		return null;
	}

	public static void particaoQuicksort(int[] elementos, int inicioArray, int finalArray){

        int pivot = elementos[inicioArray];
        int pLeft = inicioArray;
        int pRight = finalArray;

        while (pLeft <= pRight){
            
            while (elementos[pLeft] < pivot) pLeft++;
            while (elementos[pRight] > pivot) pRight--;

            if (pLeft <= pRight){
                int troca = elementos[pLeft];
                elementos[pLeft] = elementos[pRight];
                elementos[pRight] = troca;
                pLeft++;
                pRight--;
            }

        } 

        if(inicioArray < pRight) {
            particaoQuicksort(elementos, inicioArray, pRight);
        }

        if(pLeft < finalArray) {
            particaoQuicksort(elementos, pLeft, finalArray);
        }

    }

}