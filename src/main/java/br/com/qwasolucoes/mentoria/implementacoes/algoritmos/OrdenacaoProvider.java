package br.com.qwasolucoes.mentoria.implementacoes.algoritmos;

import br.com.qwasolucoes.mentoria.interfaces.algoritmos.Ordenacao;

public class OrdenacaoProvider implements Ordenacao {

	@Override
	public int[] ordenar(int[] elementos) {

		bubbleSort(elementos);
		 
		return elementos;
	}

	@Override
	public int[] quicksort(int[] elementos) {
		 
		if (elementos.length > 0) {
            particaoQuicksort(elementos, 0, elementos.length - 1);
        }
        
        return elementos;
	}

	@Override
	public int[] mergesort(int[] elementos) {
		 
		if (elementos == null || elementos.length <= 1){
            return elementos;
        }

        mergesortAuxiliar(elementos, 0, elementos.length -1);

        return elementos;
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

    public static void mergesortAuxiliar(int[] arrayAux, int inicio, int fim){

        if(inicio < fim){
            int meio = (inicio + fim) / 2;
            mergesortAuxiliar(arrayAux, inicio, meio);
            mergesortAuxiliar(arrayAux, meio + 1, fim);
            merge(arrayAux, inicio, meio, fim);
        }
    }

    public static void merge(int[] arrayAux, int inicio, int meio, int fim){
        int[] arrayTemporario = new int[fim - inicio + 1];
        int i = inicio; 
        int j = meio + 1; 
        int k = 0; 

        while (i <= meio && j <= fim){
            if (arrayAux[i] <= arrayAux[j]){
                arrayTemporario[k++] = arrayAux [i++];
            } else{
                arrayTemporario[k++] = arrayAux [j++];
            }
        }

        while(i <= meio){
            arrayTemporario[k++] = arrayAux [i++];
        }

        while(j <= fim){
            arrayTemporario[k++] = arrayAux [j++];
        }

        for(i = 0; i < arrayTemporario.length; i++){
            arrayAux[inicio + i] = arrayTemporario[i];
        }
    }

}