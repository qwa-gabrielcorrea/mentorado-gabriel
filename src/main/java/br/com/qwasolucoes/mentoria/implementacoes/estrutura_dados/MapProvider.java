package br.com.qwasolucoes.mentoria.implementacoes.estrutura_dados;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

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
			for (String valor : mapa.get(chave)) {
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
		
		List<String> chaves = new ArrayList<>(mapa.keySet());
				
		return chaves;
	}

	@Override
	public List<String> valoresMapa(Map<String, String> mapa) {
		
		List<String> valores = new ArrayList<>();
		
		for(String valor : mapa.keySet()) {
			valores.add(valor);
		}
		 
		return valores;
	}

	@Override
	public Map<String, List<Integer>> nomeTelefones(int limite) {
	
		Map<String, List<Integer>> mapa = new TreeMap<>();
		
		List<Integer> pares = new ArrayList<>();
		List<Integer> impares = new ArrayList<>();
		List<Integer> primos = new ArrayList<>();
		List<Integer> multip = new ArrayList<>();
		
		for (int i = 0; i <= limite; i++) {
			
			if(i % 2 == 0) {
				pares.add(i);
			} else {
				impares.add(i);
			}
			if(validaPrimo(i)) {
				primos.add(i);
			}
			if (i %10 == 0) {
				multip.add(i);
			}

		}
		
		mapa.put("NUMEROS_IMPARES", pares);
		mapa.put("NUMEROS_PARES", impares);
		mapa.put("NUMEROS_PRIMOS", primos);
		mapa.put("NUMEROS_MULTIPLOS_10", multip);
		
		return mapa;
	}

	@Override
	public Integer maiorNumeroEntreValores(Map<String, List<Integer>> map) {
		
		Integer resultado = null;
		Set<Integer> valores = new TreeSet<>();
		
		for(String chave : map.keySet()) {
			for (Integer valor : map.get(chave)) {
				valores.add(valor);
			}
		}
		
		resultado = valores.size();
		 
		return resultado;
	}

	@Override
	public String chaveMaiorNumeroEntreValores(Map<String, List<Integer>> map) {
		
		

		return null;
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
}


