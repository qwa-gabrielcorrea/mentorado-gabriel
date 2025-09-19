package br.com.qwasolucoes.mentoria.implementacoes.logica_programacao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.qwasolucoes.mentoria.interfaces.logica_programacao.LogicaProgramacao;
import br.com.qwasolucoes.mentoria.model.Funcionario;

public class LogicaProgramacaoProvider implements LogicaProgramacao{

	@Override
	public List<Funcionario> conversaoStringParaPessoa(List<String> lista) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> conversaoPessoaParaString(List<Funcionario> pessoas) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Funcionario conversaoArrayParaPessoa(String[] array) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> conversaoArrayMultidimensionalParaPessoa(String[][] arrayMultidimensional) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[][] arrayMultidimensionalParesImparesPrimosResto(int[] array, int numeroDivisaoResto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] arrayMultidimensionalPorPosicoes(String[][] arrayMultidimensional, int coluna, int linha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] arrayMultidimensionalPorValor(String[][] arrayMultidimensional, String valor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] antecessorSucessorPor(String[] array, int posicao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] antecessorSucessorPor(String[] array, String valor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> numerosPares(Integer limite) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> numerosImpares(Integer limite) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> numerosPrimos(Integer limite) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] numerosParesArray(Integer limite) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] numerosImparesArray(Integer limite) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] numerosPrimosArray(Integer limite) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] primeiraUltimaPosicaoArray(Integer limite) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] quantidadeParesImparesPrimos(List<Integer> valores) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] primeiraUltimaMediaPosicaoArray(Integer limite) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> removerInteirosDuplicados(List<Integer> numeros) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BigDecimal> removerValoresDuplicados(List<BigDecimal> numeros) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> removerTextosDuplicados(List<String> textos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer valorInteiroMaiorQtdDuplicados(List<Integer> numeros) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String valorTextoMaiorQtdDuplicados(List<String> textos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> listaInteirosDuplicados(List<Integer> numeros) {
		
		List<Integer> numerosDuplicados = new ArrayList<>();
		Integer numero;

		for (int i = 0; i < numeros.size(); i++) {
			numero = numeros.get(i);
			int contador = 0;

			for (int j = 0; j < numeros.size(); j++) {
				if (numero.equals(numeros.get(j))) {
					contador++;
				}
			}

			if (contador > 1) {
				boolean taNaLista = false;
				for (int k = 0; k < numerosDuplicados.size(); k++) {
					if (numero.equals(numerosDuplicados.get(k))) {
						taNaLista = true;
						break;
					}
				}
				if (!taNaLista) {
					numerosDuplicados.add(numero);
				}
			}
		}

		for (Integer valor : numerosDuplicados) {
			System.out.println(valor);
		}

		return numerosDuplicados;
	}

	@Override
	public List<BigDecimal> listaDecimalDuplicados(List<BigDecimal> textos) {
		
		List<BigDecimal> decimaisRepetidos = new ArrayList <>();
		BigDecimal texto;

		for (int i = 0; i < textos.size(); i ++){
			int contador = 0;
			texto = textos.get(i); 

			for(int j = 0; j < textos.size(); j++){
				if(texto.equals(textos.get(j))){
					contador ++;
				}
			}

			if (contador > 1){
				boolean taNaLista = false; 
				for(int k = 0; k < decimaisRepetidos.size(); k++){
					if(texto.equals(decimaisRepetidos.get(k))){
						taNaLista = true; 
						break;
					}
				}
				if (!taNaLista){
					decimaisRepetidos.add(texto);
				}
			}
		}

		for(BigDecimal decimal : decimaisRepetidos){
			System.out.println(decimal);
		}
		
		return decimaisRepetidos;
	}

	@Override
	public List<String> listaTextoDuplicados(List<String> textos) {
		
		List<String> textosRepetidos = new ArrayList<>();
		String texto;

		for (int i = 0; i < textos.size(); i++) {
			texto = textos.get(i);
			int contador = 0;

			for (int j = 0; j < textos.size(); j++) {
				if (texto.equals(textos.get(j))) {
					contador++;
				}
			}

			if (contador > 1) {
				boolean taNaLista = false;
				for (int k = 0; k < textosRepetidos.size(); k++) {
					if (texto.equals(textosRepetidos.get(k))) {
						taNaLista = true;
						break;
					}
				}
				if (!taNaLista) {
					textosRepetidos.add(texto);
				}
			}

		}

		for (String valor : textosRepetidos) {
			System.out.println(valor);
		}

		return textosRepetidos;
	}

	@Override
	public Integer somarValores(Integer limite) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer somarValoresPares(Integer limite) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer somarValoresImpares(Integer limite) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer somarValoresPrimos(Integer limite) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer somarValoresPosicoes(int[] valores) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer somarValoresParesPosicoes(int[] valores) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer somarValoresImparesPosicoes(int[] valores) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer somarValoresPrimosPosicoes(int[] valores) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer somarValoresPosicoesParesMultiplosDe(Integer limite, Integer multiplo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean multiploDeSete(int valor) {

		if (valor % 7 == 0){
			return true;
		}
		return false;
	}
	}

	@Override
	public String parOuImpar(int valor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String parOuImparOuZero(int valor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] obterDobrosAteDobroInformado(int valor) {
		
		int auxiliar = 0;
		List<Integer> listaAuxiliar = new ArrayList<>();
		int vetor[];
		int limite = valor * 2; 

		do {
			listaAuxiliar.add(valor * 2);
			valor++;
			auxiliar++;
		} while ( valor <= limite);
		
		vetor = new int[auxiliar];

		for (int i = 0; i < vetor.length; i++){
			vetor[i] = listaAuxiliar.get(i);
			System.out.println(vetor[i]);
		}

		return vetor;
	}

	@Override
	public int[] obterDobrosAteDez(int valor) {
		
		int auxiliar = 0;
		List<Integer> listaAuxiliar = new ArrayList<>();
		int vetor[];


		do {
			listaAuxiliar.add(valor * 2);
			valor ++;
			auxiliar++;
		} while (valor <= 10);
		
		vetor = new int[auxiliar];

		for (int i = 0; i < vetor.length; i++){
			vetor[i] = listaAuxiliar.get(i);
			System.out.println(vetor[i]);
		}

		return vetor;
	}

	@Override
	public int[] obterDobrosAteMil(int valor) {

		int auxiliar = 0;
		List<Integer> listaAuxiliar = new ArrayList<>();
		int vetor[];

		do {
			valor *= 2;
			listaAuxiliar.add(valor);
			auxiliar++;
		} while (valor <= 1000);
		
		vetor = new int[auxiliar];

		for (int i = 0; i < vetor.length; i++){
			vetor[i] = listaAuxiliar.get(i);
			System.out.println(vetor[i]);
		}

		return vetor;
	}

	@Override
	public int[][] tabuada(int valor) {

		int[][] matriz = new int[valor * 10][3];
		int linhaAtual = 0;

		for (int i = 1; i <= valor; i++) {
			for (int j = 1; j <= 10; j++) {
				matriz[linhaAtual][0] = i;
				matriz[linhaAtual][1] = j;
				matriz[linhaAtual][2] = i * j;
				System.out
						.println(matriz[linhaAtual][0] + " x " + matriz[linhaAtual][1] + " = " + matriz[linhaAtual][2]);
				linhaAtual++;
			}
		}
		
		return matriz;
	}

}
