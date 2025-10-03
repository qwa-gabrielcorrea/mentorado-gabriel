package br.com.qwasolucoes.mentoria.implementacoes.logica_programacao;


import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.qwasolucoes.mentoria.interfaces.logica_programacao.LogicaProgramacao;
import br.com.qwasolucoes.mentoria.model.Funcionario;

public class LogicaProgramacaoProvider implements LogicaProgramacao{

	@Override
	public List<Funcionario> conversaoStringParaPessoa(List<String> lista) {
		
		List<Funcionario> employeeList = new ArrayList<>();

		for (String dado : lista) {
			
			Funcionario employee = new Funcionario();

			Date dataNasc = null;

			try {
				dataNasc = converteStringParaData(dado.substring(39, 47).trim());
			} catch (ParseException e) {
				e.getMessage();
			}

			BigDecimal salario = converteStringParaBigDecimal(dado.substring(142, dado.length()).trim());
			int idade = caculaIdade(dataNasc);
			BigDecimal taxa = calculaTaxa(idade);
			BigDecimal salarioLiquido = calculaSalarioLiquido(salario, taxa, idade);
			boolean maioridade = calculaMaioridade(idade);

			employee.setNome(dado.substring(0, 19).trim());
			employee.setSobrenome(dado.substring(19, 39).trim());
			employee.setDataNascimento(dataNasc);
			employee.setSexo(dado.substring(47, 48).trim());
			employee.setProfissao(dado.substring(48, 88).trim());
			employee.setCpfCnpj(dado.substring(88, 102).trim());
			employee.setEscolaridade(dado.substring(102, 142).trim());
			employee.setSalario(salario);
			employee.setIdade(idade);
			employee.setTaxa(taxa);
			employee.setSalarioLiquido(salarioLiquido);
			employee.setMaiorIdade(maioridade);

			employeeList.add(employee);
		}

		return employeeList;
	}

	@Override
	public List<String> conversaoPessoaParaString(List<Funcionario> pessoas) {
		
		StringBuilder employee = new StringBuilder();
		List<String> employeeStringList = new ArrayList<>();

		for (Funcionario pessoa : pessoas) {

			// -------------------------------------- NOME -------------------------------------- //
			employee.append(pessoa.getNome());

			while (employee.length() < 19) {
				employee.append(" ");
			}

			if (employee.length() > 19) {
				employee.delete(19, employee.length());
			}

			// -------------------------------------- SOBRENOME -------------------------------------- //
			employee.append(pessoa.getSobrenome());

			while (employee.length() < 39) {
				employee.append(" ");
			}

			if (employee.length() > 39) {
				employee.delete(39, employee.length());
			}
			
			// -------------------------------------- NASCIMENTO -------------------------------------- //
			String dataFmt = "";
			
			try {
				dataFmt = formataData(pessoa.getDataNascimento());
			} catch (ParseException e){
				e.getMessage();
			}
			employee.append(dataFmt);

			while (employee.length() < 47) {
				employee.append(" ");
			}

			if (employee.length() > 47) {
				employee.delete(47, employee.length());
			}

			// -------------------------------------- SEXO -------------------------------------- //
			employee.append(pessoa.getSexo());

			while (employee.length() < 48) {
				employee.append(" ");
			}

			if (employee.length() > 48) {
				employee.delete(48, employee.length());
			}

			// -------------------------------------- PROFISSÃO -------------------------------------- //
			employee.append(pessoa.getProfissao());

			while (employee.length() < 88) {
				employee.append(" ");
			}

			if (employee.length() > 88) {
				employee.delete(88, employee.length());
			}

			// -------------------------------------- CPF/CNPJ -------------------------------------- //
			employee.append(pessoa.getCpfCnpj());

			while (employee.length() < 102) {
				employee.append(" ");
			}

			if (employee.length() > 102) {
				employee.delete(102, employee.length());
			}

			// -------------------------------------- ESCOLARIDADE -------------------------------------- //
			employee.append(pessoa.getEscolaridade());

			while (employee.length() < 142) {
				employee.append(" ");
			}

			if (employee.length() > 142) {
				employee.delete(142, employee.length());
			}

			// -------------------------------------- SALARIO -------------------------------------- //
			employee.append(pessoa.getSalario());

			while (employee.length() < 152) {
				employee.append(" ");
			}

			if (employee.length() > 152) {
				employee.delete(152, employee.length());
			}			

			employeeStringList.add(employee.toString());

		}

		return employeeStringList;

	}

	@Override
	public Funcionario conversaoArrayParaPessoa(String[] array) {
		
		Funcionario employee = new Funcionario();

		try {

			Date dataNascimento = converteStringParaData(array[2]);
			int idade = caculaIdade(dataNascimento);
			boolean maioridade = calculaMaioridade(idade);
			BigDecimal salario = converteStringParaBigDecimal(array[7]);
			BigDecimal taxa = calculaTaxa(idade);
			BigDecimal salarioLiquido = calculaSalarioLiquido(salario, taxa, idade);

			employee.setNome(array[0]);
			employee.setSobrenome(array[1]);
			employee.setDataNascimento(dataNascimento);
			employee.setIdade(idade);
			employee.setSexo(array[3]);
			employee.setProfissao(array[4]);
			employee.setCpfCnpj(array[5]);
			employee.setEscolaridade(array[6]);
			employee.setSalario(salario);
			employee.setMaiorIdade(maioridade);
			employee.setTaxa(taxa);
			employee.setSalarioLiquido(salarioLiquido);

		} catch (ParseException e) {
			e.getMessage();
		}

		return employee;
	}

	@Override
	public List<Funcionario> conversaoArrayMultidimensionalParaPessoa(String[][] arrayMultidimensional) {
		
		List<Funcionario> employeeList = new ArrayList<>();

		for (int i = 0; i < arrayMultidimensional.length; i++) {

			Funcionario employee = new Funcionario();

			try {

				Date dataNascimento = converteStringParaData(arrayMultidimensional[i][2]);
				BigDecimal salario = converteStringParaBigDecimal(arrayMultidimensional[i][7]);
				int idade = caculaIdade(dataNascimento);
				BigDecimal taxa = calculaTaxa(idade);
				BigDecimal salarioLiquido = calculaSalarioLiquido(salario, taxa, idade);
				boolean maioridade = calculaMaioridade(idade);

				employee.setNome(arrayMultidimensional[i][0]);
				employee.setSobrenome(arrayMultidimensional[i][1]);
				employee.setDataNascimento(dataNascimento);
				employee.setSexo(arrayMultidimensional[i][3]);
				employee.setProfissao(arrayMultidimensional[i][4]);
				employee.setCpfCnpj(arrayMultidimensional[i][5]);
				employee.setEscolaridade(arrayMultidimensional[i][6]);
				employee.setSalario(salario);
				employee.setIdade(idade);
				employee.setTaxa(taxa);
				employee.setSalarioLiquido(salarioLiquido);
				employee.setMaiorIdade(maioridade);

			} catch (ParseException e) {
				e.getMessage();
			}

			employeeList.add(employee);
		}

		return employeeList;

	}

	@Override
	public int[][] arrayMultidimensionalParesImparesPrimosResto(int[] array, int numeroDivisaoResto) {
		
		int matriz[][] = new int[array.length][4];

		for (int i = 0; i < array.length; i++) {
			int numeroAtual = array[i];

			if (validaParOuImpar(numeroAtual)) {
				matriz[i][0] = numeroAtual;
			} else {
				matriz[i][0] = 0;
			}

			if (!validaParOuImpar(numeroAtual)) {
				matriz[i][1] = numeroAtual;
			} else {
				matriz[i][1] = 0;
			}

			if (validaPrimo(numeroAtual)) {
				matriz[i][2] = numeroAtual;
			} else {
				matriz[i][2] = 0;
			}

			matriz[i][3] = numeroAtual % numeroDivisaoResto;

		}

		return matriz;
	}

	@Override
	public String[] arrayMultidimensionalPorPosicoes(String[][] arrayMultidimensional, int coluna, int linha) {
		
		String[] resultado = new String[0];

		if (arrayMultidimensional.length > 0 && linha <= arrayMultidimensional.length) {
			resultado = new String[4];

			for (int i = 0; i < arrayMultidimensional.length; i++) {
				for (int j = 0; j < arrayMultidimensional[i].length; j++) {

					int antecessor = j - 1;
					int sucessor = j + 1;
					int acima = i - 1;
					int abaixo = i + 1;

					if (linha == i && coluna == j) {

						resultado[0] = arrayMultidimensional[i][antecessor]; // antecessor
						resultado[1] = arrayMultidimensional[i][sucessor]; // sucessor
						resultado[2] = arrayMultidimensional[acima][j]; // acima
						resultado[3] = arrayMultidimensional[abaixo][j]; // abaixo

					}
				}
			}
		}
		return resultado;
	}

	@Override
	public String[] arrayMultidimensionalPorValor(String[][] arrayMultidimensional, String valor) {
		
		String[] resultado = new String[0];

		if (arrayMultidimensional.length > 0) {
			resultado = new String[4];

			for (int i = 0; i < arrayMultidimensional.length; i++) {
				for (int j = 0; j < arrayMultidimensional[i].length; j++) {

					int antecessor = j - 1;
					int sucessor = j + 1;
					int acima = i - 1;
					int abaixo = i + 1;

					if (valor.equals(arrayMultidimensional[i][j])) {

						resultado[0] = arrayMultidimensional[i][antecessor]; // antecessor
						resultado[1] = arrayMultidimensional[i][sucessor]; // sucessor
						resultado[2] = arrayMultidimensional[acima][j]; // acima
						resultado[3] = arrayMultidimensional[abaixo][j]; // abaixo

					}

				}
			}

		}
		return resultado;
	}

	@Override
	public String[] antecessorSucessorPor(String[] array, int posicao) {
		
		String[] resultado = new String[0];

		if (array.length > 0) {

			resultado = new String[2];

			for (int i = 0; i < array.length; i++) {

				int antecessor = i - 1;
				int sucessor = i + 1;

				if (posicao == i) {
					resultado[0] = array[antecessor];
					resultado[1] = array[sucessor];
				}
			}
		}

		return resultado;
	}

	@Override
	public String[] antecessorSucessorPor(String[] array, String valor) {
		
		String[] resultado = new String[0];

		if (array.length > 0) {
			resultado = new String[2];
			for (int i = 0; i < array.length; i++) {

				int antecessor = i - 1;
				int sucessor = i + 1;

				if (array[i].equals(valor)) {
					
					resultado[0] = array[antecessor];
					resultado[1] = array[sucessor];
				}
			}
		}

		return resultado;
	}

	@Override
	public List<Integer> numerosPares(Integer limite) {

		List<Integer> listaPares = new ArrayList<>();

		for(int i = 0; i <= limite; i++){
			if(validaParOuImpar(i)){
				listaPares.add(i);
			}
		}

		System.out.println(listaPares);
		
		return listaPares;
	}

	@Override
	public List<Integer> numerosImpares(Integer limite) {

		List<Integer> listaImpares = new ArrayList<>();

		for(int i = 0; i <= limite; i++){
			if(!validaParOuImpar(i)){
				listaImpares.add(i);
			}
		}

		System.out.println(listaImpares);
		
		return listaImpares;
	}

	@Override
	public List<Integer> numerosPrimos(Integer limite) {

		int aux = 0; 
		List<Integer> listaPrimos = new ArrayList<>();
		
		while (aux <= limite){
			if (validaPrimo(aux)){
				listaPrimos.add(aux);
			}
			aux ++;
		}

		System.out.println(listaPrimos);
				
		return listaPrimos;
	}

	@Override
	public int[] numerosParesArray(Integer limite) {
		
		int aux = 0; 
		List<Integer> listaAuxiliar = new ArrayList<>();

		for(int i = 0; i <= limite; i++){
			if(validaParOuImpar(i)){
				aux++;
				listaAuxiliar.add(i);
			}
		}

		int vect[] = new int[aux];

		for(int i = 0; i < vect.length; i++){
			vect[i] = listaAuxiliar.get(i);
			System.out.println(vect[i]);
		}
		
		return vect;
	}

	@Override
	public int[] numerosImparesArray(Integer limite) {
		
		int aux = 0; 
		List<Integer> listaAuxiliar = new ArrayList<>();

		for(int i = 0; i <= limite; i++){
			if(!validaParOuImpar(i)){
				aux++;
				listaAuxiliar.add(i);
			}
		}

		int vect[] = new int[aux];

		for(int i = 0; i < vect.length; i++){
			vect[i] = listaAuxiliar.get(i);
			System.out.println(vect[i]);
		}
		
		return vect;
	}

	@Override
	public int[] numerosPrimosArray(Integer limite) {
		
		int aux = 0; 
		List<Integer> listaAuxiliar = new ArrayList<>();

		for(int i = 0; i <= limite; i++){
			if(validaPrimo(i)){
				aux++;
				listaAuxiliar.add(i);
			}
		}

		int vect[] = new int[aux];

		for(int i = 0; i < vect.length; i++){
			vect[i] = listaAuxiliar.get(i);
			System.out.println(vect[i]);
		}
		
		return vect;
	}

	@Override
	public int[] primeiraUltimaPosicaoArray(Integer limite) {
		
		int[] vetor = new int[2];

		vetor[0] = 0;
		vetor[1] = (limite - 1);

		System.out.println(vetor);

		return vetor;
	}

	@Override
	public int[] quantidadeParesImparesPrimos(List<Integer> valores) {
		
		int[] vetor = new int[3];
		int pares = 0;
		int impares = 0;
		int primos = 0;

		for (Integer valor : valores) {
			if (validaParOuImpar(valor)) {
				pares ++;
			} else {
				impares ++;
			}
			if (validaPrimo(valor)) {
				primos ++;
			}
		}

		vetor[0] = pares;
		vetor[1] = impares;
		vetor[2] = primos;

		return vetor;
	}

	@Override
	public int[] primeiraUltimaMediaPosicaoArray(Integer limite) {
		
		int[] vetor = new int[3];
		int soma = 0;
		int aux = 1;

		vetor[0] = 0;
		vetor[1] = limite;

		for (int i = 0; i <= limite; i++) {
			soma = soma + i;
			aux++;
		}

		vetor[2] = soma / aux;

		return vetor;
	}

	@Override
	public List<Integer> removerInteirosDuplicados(List<Integer> numeros) {

		List<Integer> listaSemInteirosDuplicados = new ArrayList<>();

		for (Integer numero : numeros) {

			if (!listaSemInteirosDuplicados.contains(numero)) {
				listaSemInteirosDuplicados.add(numero);
			}
		}

		return listaSemInteirosDuplicados;
	}

	@Override
	public List<BigDecimal> removerValoresDuplicados(List<BigDecimal> numeros) {
		
		List<BigDecimal> listaSemNumerosDuplicados = new ArrayList<>();

		for (BigDecimal numero : numeros) {

			if (!listaSemNumerosDuplicados.contains(numero)) {
				listaSemNumerosDuplicados.add(numero);
			}
		}

		return listaSemNumerosDuplicados;
	}

	@Override
	public List<String> removerTextosDuplicados(List<String> textos) {
		
		List<String> listaSemTextosDuplicados = new ArrayList<>();

		for (String texto : textos) {

			if (!listaSemTextosDuplicados.contains(texto)) {
				listaSemTextosDuplicados.add(texto);
			}
		}

		return listaSemTextosDuplicados;
	}

	@Override
	public Integer valorInteiroMaiorQtdDuplicados(List<Integer> numeros) {
		
		Integer inteiroMaisDuplicado = null;
		int aux = 0;
		int maiorQtde = 0;

		//metodo para ordenar a lista 
		int x = numeros.size();
		boolean trocado; 

		for (int i = 0; i < x - 1; i++){
			trocado = false; 

			for(int j = 0; j < x - 1; j++){
				if (numeros.get(j) > numeros.get(j +1)){

					int auxiliar = numeros.get(j);
					numeros.set(j, numeros.get(j + 1));
					numeros.set(j + 1, auxiliar);
					trocado = true;
				}
			}
			if (!trocado){
				break;
			}
		}
		// final do método de ordenação

		for (Integer numeroAtual : numeros){
			System.out.println(numeroAtual);
		}

		for (Integer numeroAtual : numeros) {
			int contador = 0;

			for (Integer numeroCompara : numeros) {
				if (numeroCompara.equals(numeroAtual)) {
					contador++;
				}
			}

			if (contador > 1) {
				maiorQtde = contador;

				if (maiorQtde > aux) {
					inteiroMaisDuplicado = numeroAtual;
					aux = maiorQtde;
				}
			}
		}

		return inteiroMaisDuplicado;
	}

	@Override
	public String valorTextoMaiorQtdDuplicados(List<String> textos) {
		
		String maisRepetido = "";
		int aux = 0;
		int maiorQtde = 0;

		for (String textoAtual : textos) {
			int contador = 0;

			for (String textoCompara : textos) {
				if (textoCompara.equals(textoAtual)) {
					contador++;
				}
			}

			if (contador > 1) {
				maiorQtde = contador;

				if (maiorQtde > aux) {
					maisRepetido = textoAtual;
					aux = maiorQtde;
				}

			}

		}

		return maisRepetido;
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

		Integer soma = 0;
		int aux = 0;

		while (aux <= limite){
			soma += aux;
			aux++;
		}

		System.out.println(soma);
		
		return soma;
	}

	@Override
	public Integer somarValoresPares(Integer limite) {
		
		Integer auxiliar = 0;
		int soma = 0;

		while (auxiliar <= limite){
			if (validaParOuImpar(auxiliar)){
				soma += auxiliar;
			}
			auxiliar ++;
		}
		
		System.out.println(soma);

		return soma;
	}

	@Override
	public Integer somarValoresImpares(Integer limite) {
		
		Integer auxiliar = 0;
		int soma = 0;

		while (auxiliar <= limite){
			if (!validaParOuImpar(auxiliar)){
				soma += auxiliar;
			}
			auxiliar ++;
		}
		
		System.out.println(soma);

		return soma;
	}

	@Override
	public Integer somarValoresPrimos(Integer limite) {
		
		Integer auxiliar = 0;
		Integer soma = null;

		if (limite > 0){
			soma = 0;
			while (auxiliar <= limite){
				if (validaPrimo(auxiliar)){
					soma += auxiliar;
				}
				auxiliar ++;
			}
		}

		return soma;
	}

	@Override
	public Integer somarValoresPosicoes(int[] valores) {
		
		Integer soma = 0; 

		for(int i = 0; i < valores.length; i++){
			soma += valores[i];
		}

		return soma;
	}

	@Override
	public Integer somarValoresParesPosicoes(int[] valores) {

		Integer soma = 0;
		
		for (int i = 0; i < valores.length; i++) {
			if (validaParOuImpar(valores[i])) {
				soma += valores[i];
			}
			
		}
		
		System.out.println(soma);

		return soma;
	}

	@Override
	public Integer somarValoresImparesPosicoes(int[] valores) {
		
		Integer soma = 0;
		
		for (int i = 0; i < valores.length; i++) {
			if (!validaParOuImpar(valores[i])) {
				soma += valores[i];
			}
		}

		System.out.println(soma);
		
		return soma;
	}

	@Override
	public Integer somarValoresPrimosPosicoes(int[] valores) {
		
		Integer soma = 0;
		
		for (int i = 0; i < valores.length; i++) {
			if (validaPrimo(valores[i])) {
				System.out.println(valores[i]);
				soma = soma + valores[i];
			}
		}

		System.out.println(soma);
		
		return soma;
	}

	@Override
	public Integer somarValoresPosicoesParesMultiplosDe(Integer limite, Integer multiplo) {
				
		Integer soma = 0;

		if (multiplo == 0){
			return 0;
		}

		for (int i = 0; i <= limite; i++){
			if (validaParOuImpar(i)){
				// if (i % multiplo == 0){
					soma = soma + (i * multiplo);
				// }
			}
		}

		return soma;
	}

	@Override
	public boolean multiploDeSete(int valor) {

		if (valor % 7 == 0){
			return true;
		}
		return false;
	}
	

	@Override
	public String parOuImpar(int valor) {

		String resultado; 

		if (validaParOuImpar(valor)){
			resultado = "PAR";
		} else {
			resultado = "IMPAR";
		}

		System.out.println(resultado);
		
		return resultado;
	}

	@Override
	public String parOuImparOuZero(int valor) {
		
		String resultado; 

		if (valor == 0){
			resultado = "ZERO";
		}else if (validaParOuImpar(valor)){
			resultado = "PAR";
		} else {
			resultado = "IMPAR";
		}

		System.out.println(resultado);
		
		return resultado;
	}

	@Override
	public int[] obterDobrosAteDobroInformado(int valor) {
		
		int aux = valor; 

		List<Integer> listaAuxiliar = new ArrayList<>();
		int[] vetor;

		if (valor < 0){
			valor *= (-1);
		}

		int limite = valor * 2;
		
		do {
			int resultado = valor * 2;
			if (aux < 0){
				resultado *= (-1);
			}
			listaAuxiliar.add(resultado);
			valor++;
		} while (valor <= limite);

		vetor = new int[listaAuxiliar.size()];

		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = listaAuxiliar.get(i);
			System.out.println(vetor[i]);
		}

		return vetor;
	}

	@Override
	public int[] obterDobrosAteDez(int valor) {
		
		List<Integer> listaAuxiliar = new ArrayList<>();
		int[] vetor;

		if (valor > 0 && valor <= 10) {
			do {
				listaAuxiliar.add(valor * 2);
				valor++;
			} while (valor <= 10);
		}

		vetor = new int[listaAuxiliar.size()];

		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = listaAuxiliar.get(i);
		}

		return vetor;
	}

	@Override
	public int[] obterDobrosAteMil(int valor) {

		int auxiliar = 0;
		List<Integer> listaAuxiliar = new ArrayList<>();
		int vetor[];

		if (valor == 0) {
			System.out.println("O valor não pode ser zero.");
		} else {

			do {
				valor *= 2;
				listaAuxiliar.add(valor);
				auxiliar++;
			} while (valor <= 1000);

			vetor = new int[auxiliar];

			for (int i = 0; i < vetor.length; i++) {
				vetor[i] = listaAuxiliar.get(i);
				System.out.println(vetor[i]);
			}

			return vetor;

		}

		return null;
	}

	@Override
	public int[][] tabuada(int valor) {

		int auxiliar;

		if (valor < 0) {
			auxiliar = valor * (-1);
		} else {
			auxiliar = valor;
		}

		int[][] matriz = new int[auxiliar * 10][3];
		int linhaAtual = 0;

		for (int i = 1; i <= auxiliar; i++) {
			for (int j = 1; j <= 10; j++) {
				if (valor < 0) {
					matriz[linhaAtual][0] = i * (-1);
					matriz[linhaAtual][1] = j;
					matriz[linhaAtual][2] = (i * (-1)) * j;
				} else {
					matriz[linhaAtual][0] = i;
					matriz[linhaAtual][1] = j;
					matriz[linhaAtual][2] = i * j;
				}
				System.out
						.println(matriz[linhaAtual][0] + " x " + matriz[linhaAtual][1] + " = "
								+ matriz[linhaAtual][2]);
				linhaAtual++;
			}
		}

		return matriz;
	}

	public boolean validaParOuImpar (Integer valor){

		if (valor % 2 == 0){
			return true;
		}
		return false;
	}

	public boolean validaPrimo (Integer valor){

		if(valor < 2){
			return false;
		}

		for (int i = 2; i * i <= valor; i++){
			if (valor % i == 0){
				return false;
			}
		}

		return true;
	}

	public Integer caculaIdade (Date dataNascimento){

       return Period.between(dataNascimento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now()).getYears();

    }
    
    public boolean calculaMaioridade (Integer idade){

        if(idade >= 18){
            return true;
        }

        return false;
    }

    public BigDecimal calculaTaxa (Integer idade){

        BigDecimal taxa;

        if(idade < 18){
            taxa = new BigDecimal(0.2);
        } else if (idade >= 18 && idade < 24){
            taxa = new BigDecimal(0.15);
        } else if (idade >= 24 && idade < 32){
            taxa = new BigDecimal(0.10);
        } else if (idade >= 32 && idade < 50){
            taxa = new BigDecimal(0.05);
        } else {
            taxa = new BigDecimal(0.01);
        }

        return taxa;
    }

    public BigDecimal calculaSalarioLiquido (BigDecimal salarioBruto, BigDecimal taxa, Integer idade){

        BigDecimal salarioLiquido;

        salarioLiquido = (salarioBruto.subtract(salarioBruto.multiply(taxa)));

        return salarioLiquido;
    }

    public Date converteStringParaData (String dataNascimento) throws ParseException{

        Date dataFormatada;

        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        dataFormatada = sdf.parse(dataNascimento);

        return dataFormatada; 
    }

    public BigDecimal converteStringParaBigDecimal (String salario){

        BigDecimal salarioFormatado = new BigDecimal(salario); 

        return salarioFormatado;

    }

	public String formataData (Date dataNascimento) throws ParseException{

        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        String dataFormatada = sdf.format(dataNascimento);

        return dataFormatada;

    }

}
