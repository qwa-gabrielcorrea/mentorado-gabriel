package br.com.qwasolucoes.mentoria.implementacoes.estrutura_dados;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.qwasolucoes.mentoria.interfaces.estrutura_dados.EstruturaDadosList;
import br.com.qwasolucoes.mentoria.model.Funcionario;

public class ListProvider implements EstruturaDadosList {

	@Override
	public List<String> nomes(List<Funcionario> pessoas) {
		
		List<String> lista = new ArrayList<>();
		
		for (Funcionario func : pessoas) {
			lista.add(func.getNome()); 
		}

		return lista;
	}

	@Override
	public List<String> sobrenomes(List<Funcionario> pessoas) {
		
		List<String> lista = new ArrayList<>();
		
		for (Funcionario func : pessoas) {
			lista.add(func.getSobrenome());
		}

		return lista;
	}

	@Override
	public List<Integer> maiores18(List<Funcionario> pessoas) {
		
		List<Integer> lista = new ArrayList<>();
		
		for (Funcionario func : pessoas) {
			
			if (func.getIdade() >= 18) {
				lista.add(func.getIdade());
			}
		}

		return lista;
	}

	@Override
	public List<Integer> menores18(List<Funcionario> pessoas) {
		
		List<Integer> lista = new ArrayList<>();
		
		for (Funcionario func : pessoas) {
			
			if (func.getIdade() < 18) {
				lista.add(func.getIdade());
			}
		}

		return lista;
	}

	@Override
	public Integer pessoaMaisVelha(List<Funcionario> pessoas) {
		
		Integer older = null;

		for (Funcionario func : pessoas) {
			if (older == null || func.getIdade().compareTo(older) > 0) {
				older = func.getIdade(); 
			}
		}

		return older;
	}

	@Override
	public Integer pessoaMaisNova(List<Funcionario> pessoas) {
		
		Integer younger = null; 
		
		for (Funcionario func : pessoas) {
			if (younger == null || younger.compareTo(func.getIdade()) > 0) {
				younger = func.getIdade();
			}
		}

		return younger;
	}

	@Override
	public BigDecimal maiorSalario(List<Funcionario> pessoas) {
		
		BigDecimal wage = null; 
		
		for (Funcionario func : pessoas) {
			if (wage == null || func.getSalario().compareTo(wage) > 0 ) {
				wage = func.getSalario();
			}
		}

		return wage;
	}

	@Override
	public BigDecimal menorTaxa(List<Funcionario> pessoas) {

		BigDecimal fee = null; 
		
		for (Funcionario func : pessoas) {
			if (fee == null || fee.compareTo(func.getTaxa()) > 0);
		}
		
		return fee;
	}

	@Override
	public String nomePrimeiraPessoa(List<Funcionario> pessoas) {
				
		return pessoas.get(0).getNome();
	}

	@Override
	public String nomeUltimaPessoa(List<Funcionario> pessoas) {
		
		int posicaoAux = pessoas.size() - 1;

		return pessoas.get(posicaoAux).getNome();
	}

	@Override
	public String maiorNome(List<Funcionario> pessoas) {

		return null;
	}

	@Override
	public String maiorNomeCompleto(List<Funcionario> pessoas) {

		return null;
	}

	@Override
	public Integer quantidadePessoasSexoMasculino(List<Funcionario> pessoas) {

		return null;
	}

	@Override
	public List<BigDecimal> maioresSalariosPeloValor(List<Funcionario> pessoas, BigDecimal valor) {

		return null;
	}
}
