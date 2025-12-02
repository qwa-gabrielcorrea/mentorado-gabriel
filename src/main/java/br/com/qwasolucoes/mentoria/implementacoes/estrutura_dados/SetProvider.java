package br.com.qwasolucoes.mentoria.implementacoes.estrutura_dados;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import br.com.qwasolucoes.mentoria.interfaces.estrutura_dados.EstruturaDadosSet;
import br.com.qwasolucoes.mentoria.model.Funcionario;

public class SetProvider implements EstruturaDadosSet {

	@Override
	public Set<String> nomesUnicosOrdenados(List<String> nomes) {
		
		Set<String> ordenaNomes = new TreeSet<>();
		
		for(String nome : nomes) {
			ordenaNomes.add(nome);	
		}

		return ordenaNomes;
	}

	@Override
	public Set<String> valoresPositivosNegativos(int[] valores) {
		
		Set<Integer> ordenaNumeros = new TreeSet<>();
				
		for (Integer valor : valores) {
			if (valor >= -9 && valor <= 9) {
				ordenaNumeros.add(valor);
			}
		}
		
		Set<String> resultado = new TreeSet<>();
		
		resultado.add(((TreeSet<Integer>) ordenaNumeros).last().toString());

		return resultado;
	}

	@Override
	public Set<Integer> valoresDuplicadosOrdenados(List<Integer> valores1, List<Integer> valores2) {

		Set<Integer> resultado = new TreeSet<>();
		
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
		
		Set<Integer> resultado = new TreeSet<>(valores1);
		resultado.retainAll(valores2);
		
		return resultado;
	}

	@Override
	public Set<Integer> valoresDuplicadosDaPrimeiraListaOrdenados(List<Integer> valores1, List<Integer> valores2) {
		
		Set<Integer> resultado = new TreeSet<>(valores1);
		resultado.removeAll(valores2);
		
		return resultado;
	}

	@Override
	public Set<Integer> valoresDiferentesDaSegundaListaOrdenados(List<Integer> valores1, List<Integer> valores2) {

		Set<Integer> resultado = new TreeSet<>(valores2);
		resultado.removeAll(valores1);
		
		return resultado;
	}

	@Override
	public Set<Funcionario> pessoasUnicasOrdenados(List<Funcionario> pessoas) {
				
		return new TreeSet<Funcionario>(pessoas);
	}

	@Override
	public Set<Funcionario> pessoasDuplicadosOrdenados(List<Funcionario> pessoas1, List<Funcionario> pessoas2) {
		
		Set<Funcionario> resultado = new TreeSet<>(pessoas1);
		
		resultado.addAll(pessoas2);
		
		return resultado;
	}

	@Override
	public Set<Funcionario> pessoasDiferentesOrdenados(List<Funcionario> pessoas1, List<Funcionario> pessoas2) {
		
		Set<Funcionario> resultado = new TreeSet<>(pessoas1);
		
		resultado.retainAll(pessoas2);

		return resultado;
	}

	@Override
	public Set<Funcionario> pessoasDuplicadosDaPrimeiraListaOrdenados(List<Funcionario> pessoas1,
			List<Funcionario> pessoas2) {
		
		Set<Funcionario> resultado = new TreeSet<>(pessoas1);
		
		resultado.removeAll(pessoas2);

		return resultado;
	}

	@Override
	public Set<Funcionario> pessoasDiferentesDaSegundaListaOrdenados(List<Funcionario> pessoas1,
			List<Funcionario> pessoas2) {

		Set<Funcionario> resultado = new TreeSet<>(pessoas2);
		
		resultado.removeAll(pessoas1);

		return resultado;
	}

}
