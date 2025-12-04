package br.com.qwasolucoes.mentoria.implementacoes.estrutura_dados;

import java.util.ArrayList;
import java.util.HashMap;
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
		
		Map<String, Integer> frequencia = new HashMap<>();
				
		for (String chave : mapa.keySet()) {
			
			Integer contador = frequencia.get(chave);
			
			if (contador == null) {
				frequencia.put(chave, 1);
			} else {
				frequencia.put(chave, contador + 1);
			}
		}
		
		return frequencia;
	}

	@Override
	public Map<String, Integer> mapaFrequenciaValoresLista(Map<String, List<String>> mapa) {
		
		Map<String, Integer> frequencia = new HashMap<>();
		
		for (String chave : mapa.keySet()) {
			for (String valor : mapa.keySet()) {
				Integer contador = frequencia.get(valor);
				
				if (contador == null) {
					frequencia.put(chave, 1);
				} else {
					frequencia.put(chave, contador + 1);
				}
			}
		}
		 
		return frequencia;
	}

	@Override
	public Map<String, List<String>> nomeTelefones(List<String> elemento) {
		
		Map<String, List<String>> telefones = new HashMap<>();
		List<String> aux = new ArrayList<>();
		
		for (String elemnt : elemento) {
			String[] corte = elemnt.split(";");

			for (int i = 0; i <= corte.length; i++) {
				String[] corteTelefone = corte[i].split(",");
				for(int j = 0; j <= corteTelefone[i].length(); i++) {
					aux.add(corteTelefone[j]);
				}
			}
			telefones.put(elemnt, aux);
		}
		
		return telefones;
	}

	@Override
	public Map<Funcionario, List<ContatoFuncionario>> cpfCnpjTelefonesObjeto(List<String> elemento) {
		
		Map<Funcionario, List<ContatoFuncionario>> mapa = new HashMap<>();
		for (String elemnt : elemento) {
			
			String[] corte = elemnt.split(";");
			String cpf = corte[0];
			String lista = corte[1];
			String[] telList = lista.split(",");
			
			Funcionario func = new Funcionario();
			List<ContatoFuncionario> numeros = new ArrayList<>();
			func.setCpfCnpj(cpf);
			
			for(String telefone : telList) {
				ContatoFuncionario contato = new ContatoFuncionario();
				contato.setValor(telefone);
				numeros.add(contato);
			}
			mapa.put(func, numeros);
		}
		
		return mapa;
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
