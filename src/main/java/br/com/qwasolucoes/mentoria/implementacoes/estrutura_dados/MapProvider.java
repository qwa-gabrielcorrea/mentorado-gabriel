package br.com.qwasolucoes.mentoria.implementacoes.estrutura_dados;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import br.com.qwasolucoes.mentoria.interfaces.estrutura_dados.EstruturaDadosMap;
import br.com.qwasolucoes.mentoria.model.ContatoFuncionario;
import br.com.qwasolucoes.mentoria.model.Funcionario;

public class MapProvider implements EstruturaDadosMap{

	@Override
	public Map<String, Integer> nomeFrequencia(List<String> nomes) {
		
		Map<String, Integer> frequencia = new TreeMap<>();
		
		for(String nome : nomes) {
			
			Integer contador = frequencia.get(nome);
			
			if (contador == null) {
				frequencia.put(nome, 1);
			} else {
				frequencia.put(nome, contador + 1);
			}
		}
		
		return frequencia;
	}

	@Override
	public Map<String, Integer> mapaFrequenciaValores(Map<String, String> mapa) {
		 
		return null;
	}

	@Override
	public Map<String, Integer> mapaFrequenciaValoresLista(Map<String, List<String>> mapa) {
		 
		return null;
	}

	@Override
	public Map<String, List<String>> nomeTelefones(List<String> elemento) {
		 
		return null;
	}

	@Override
	public Map<Funcionario, List<ContatoFuncionario>> cpfCnpjTelefonesObjeto(List<String> elemento) {
		 
		return null;
	}

	@Override
	public List<String> chavesMapa(Map<String, String> mapa) {
		 
		return null;
	}

	@Override
	public List<String> valoresMapa(Map<String, String> mapa) {
		 
		return null;
	}

	@Override
	public Map<String, List<Integer>> nomeTelefones(int limite) {
		 
		return null;
	}

	@Override
	public Integer maiorNumeroEntreValores(Map<String, List<Integer>> map) {
		 
		return null;
	}

	@Override
	public String chaveMaiorNumeroEntreValores(Map<String, List<Integer>> map) {

		return null;
	}
}
