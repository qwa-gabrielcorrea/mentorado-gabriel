package br.com.qwasolucoes.mentoria.implementacoes.estrutura_dados;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import br.com.qwasolucoes.mentoria.interfaces.estrutura_dados.EstruturaDadosSet;
import br.com.qwasolucoes.mentoria.model.Funcionario;

public class SetProvider implements EstruturaDadosSet {

	@Override
	public Set<String> nomesUnicosOrdenados(List<String> nomes) {
		
		TreeSet<String> ordenaNomes = new TreeSet<>();
		
		for(String nome : nomes) {
			ordenaNomes.add(nome);	
		}

		return ordenaNomes;
	}

	@Override
	public Set<String> valoresPositivosNegativos(int[] valores) {
		
		TreeSet<Integer> ordenaNumeros = new TreeSet<>();
				
		for (Integer valor : valores) {
			if (valor >= -9 && valor <= 9) {
				ordenaNumeros.add(valor);
			}
		}
		
		TreeSet<String> resultado = new TreeSet<>();
		
		resultado.add(ordenaNumeros.last().toString());

		return resultado;
	}

	@Override
	public Set<Integer> valoresDuplicadosOrdenados(List<Integer> valores1, List<Integer> valores2) {

		TreeSet<Integer> resultado = new TreeSet<>();
		
		for(Integer valor1 : valores1) {
			for (Integer valor2 :  valores2) {
				if(valor1.equals(valor2)) {
					resultado.add(valor1);
				}
			}
		}
		
		return resultado;
	}

	@Override
	public Set<Integer> valoresDiferentesOrdenados(List<Integer> valores1, List<Integer> valores2) {

		return null;
	}

	@Override
	public Set<Integer> valoresDuplicadosDaPrimeiraListaOrdenados(List<Integer> valores1, List<Integer> valores2) {

		return null;
	}

	@Override
	public Set<Integer> valoresDiferentesDaSegundaListaOrdenados(List<Integer> valores1, List<Integer> valores2) {

		return null;
	}

	@Override
	public Set<Funcionario> pessoasUnicasOrdenados(List<Funcionario> pessoas) {

		return null;
	}

	@Override
	public Set<Funcionario> pessoasDuplicadosOrdenados(List<Funcionario> pessoas1, List<Funcionario> pessoas2) {

		return null;
	}

	@Override
	public Set<Funcionario> pessoasDiferentesOrdenados(List<Funcionario> pessoas1, List<Funcionario> pessoas2) {

		return null;
	}

	@Override
	public Set<Funcionario> pessoasDuplicadosDaPrimeiraListaOrdenados(List<Funcionario> pessoas1,
			List<Funcionario> pessoas2) {

		return null;
	}

	@Override
	public Set<Funcionario> pessoasDiferentesDaSegundaListaOrdenados(List<Funcionario> pessoas1,
			List<Funcionario> pessoas2) {

		return null;
	}

}
