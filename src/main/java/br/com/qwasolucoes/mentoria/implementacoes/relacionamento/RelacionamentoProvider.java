package br.com.qwasolucoes.mentoria.implementacoes.relacionamento;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.qwasolucoes.mentoria.implementacoes.logica_programacao.LogicaProgramacaoProvider;
import br.com.qwasolucoes.mentoria.interfaces.relacionamento.Relacionamentos;
import br.com.qwasolucoes.mentoria.modelagem_dados.Contato;
import br.com.qwasolucoes.mentoria.modelagem_dados.Empresa;
import br.com.qwasolucoes.mentoria.modelagem_dados.Endereco;
import br.com.qwasolucoes.mentoria.modelagem_dados.Escolaridade;
import br.com.qwasolucoes.mentoria.modelagem_dados.Pessoa;
import br.com.qwasolucoes.mentoria.modelagem_dados.Profissao;
import br.com.qwasolucoes.mentoria.modelagem_dados.TipoEndereco;

public class RelacionamentoProvider implements Relacionamentos{
	
	public Map<String, Pessoa> pessoasPorCpf; 
	// chave: cpf linha[4] 
	// valor: pessoa instanciada 
	
	public Map<String, Endereco> enderecosPorCpf;
	// chave: cpf linha[0] 
	// valor: endereco instanciado 
	
	public Map<String, Escolaridade> escolaridadePorCpf;
	//chave: cpf linha[0]
	//valor: escoladirade instanciada
	
	public Map<String, TipoEndereco> buscaTipoEndereco;
	//chave: tipoEndereco p / r
	//valor: endereco linha[1]
	
	public Map<String, Profissao> profissaoPorCodigo;
	//chave codigo linha[0]
	//valor: profissao instanciada

	public Map<String, Empresa> empresaPorNome;
	//chave nome empresa
	//valor: empresa instanciada 
	
	public Map<String, Contato> contatoPorCpf;
	//chave cpf linha[0]
	//contato instanciado 
	
	
	@Override
	public void iniciar() {
		 
		List<String[]> pessoasCSV = lerCSV("resources/Pessoa.csv");
		
		for (String[] linha : pessoasCSV) {
			
			Pessoa pessoa = new Pessoa(); 
			Pessoa conjuge = new Pessoa();
			Endereco endereco = new Endereco();
			
			pessoa.setNome(linha[0]);
			pessoa.setSobrenome(linha[1]);
			pessoa.setDataNascimento(linha[2]);
			pessoa.setSexo(linha[3]);
			pessoa.setCpfCnpj(linha[4]);
			pessoa.setEstadoCivil(linha[5]);
			conjuge.setNome(linha[6]);
			pessoa.setConjuge(conjuge);
			
			pessoasPorCpf.put(pessoa.getCpfCnpj(), pessoa);
			enderecosPorCpf.put(pessoa.getCpfCnpj(), endereco);
			
			
		}
		
		
	}

	private List<String[]> lerCSV(String caminho) {

		List<String[]> linhas = new ArrayList<String[]>();
		BufferedReader br = null; 
		
		try {
			br = new BufferedReader (new FileReader(caminho));
			String linha; 
			
			while ((linha = br.readLine()) != null) {
				
				if(linha.trim().isEmpty()) {
					continue;
				}
				
				String[] colunas = linha.split(",");
				
				linhas.add(colunas);
			}
		} catch(IOException e) {
			throw new RuntimeException("Erro ao ler arquivo: " + caminho, e);
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.getMessage();
			}
		}
		
		return linhas;
	}

	@Override
	public List<String> buscarCPFsDasPessoasMaioresIdade() {
		
		List<String> resultado = new ArrayList<>();
		
		Pessoa pessoa = new Pessoa();
		
		LogicaProgramacaoProvider lgp = new LogicaProgramacaoProvider();
		
		Integer idade = lgp.caculaIdade(pessoa.getDataNascimento());
		
		boolean ehMaior = lgp.calculaMaioridade(idade);
		
		if (ehMaior) {
			resultado.add(pessoa.getCpfCnpj());
		}
		
		return resultado;
	}

	@Override
	public List<String> buscarNomeSobrenomeDasPessoasPorAnorNascimento(Integer ano) {
		
		Pessoa pessoa = new Pessoa(); 
		String anoNasc = pessoa.getDataNascimento();
		
		List<String> resultado = new ArrayList<>();
		
		String nomeCompleto = pessoa.getNome() + " " + pessoa.getSobrenome();
		
		if (anoNasc.contains(ano.toString())) {
			resultado.add(nomeCompleto);
		}
		
		return resultado;
	}

	@Override
	public List<String> buscarNomeSobrenomeDasPessoasPorEstadoCivil(String estadoCivil) {
		
		List<String> resultado = new ArrayList<>();
		
		Pessoa pessoa = new Pessoa();
		String nomeCompleto = pessoa.getNome() + " " + pessoa.getSobrenome();
		
		if (estadoCivil.equals(pessoa.getEstadoCivil())) {
			resultado.add(nomeCompleto);
		}
		
		return resultado;
	}

	@Override
	public List<Pessoa> buscarPessoasPorTipoResidencia(String tipoResidencia) {
		
		Pessoa pessoa = new Pessoa();
		
		List<Pessoa> resultado = new ArrayList<>();
		
		return resultado;
	}

	@Override
	public List<Pessoa> buscarPessoasPorTipoContato(String tipoContato) {
		
		List<Pessoa> resultado = new ArrayList<>();
		
		return resultado;
	}

	@Override
	public List<Pessoa> buscarPessoasPorBairro(String bairro) {
		
		List<Pessoa> resultado = new ArrayList<>();
		
		return resultado;
	}

	@Override
	public List<Pessoa> buscarPessoasPorNomeBairroContem(String valor) {
		
		List<Pessoa> resultado = new ArrayList<>();
		
		
		return resultado;
	}

	@Override
	public List<Pessoa> buscarPessoasPorEstado(String estado) {
		
		List<Pessoa> resultado = new ArrayList<>();
		
		
		return resultado;
	}

	@Override
	public List<Pessoa> buscarPessoasPorProfissao(String nomeProfissao) {
		
		List<Pessoa> resultado = new ArrayList<>();
		
		
		return resultado;
	}

	@Override
	public List<Pessoa> buscarPessoasPorProfissaoNomeAreaAtuacaoContem(String valor) {
		
		List<Pessoa> resultado = new ArrayList<>();
		
		
		return resultado;
	}

	@Override
	public List<Pessoa> buscarPessoasPorSalarioBaseMaiorQue(BigDecimal salarioBase) {
		
		List<Pessoa> resultado = new ArrayList<>();
		
		
		return resultado;
	}

	@Override
	public List<Pessoa> buscarPessoasPorSalarioBaseMaiorIgual(BigDecimal salarioBase) {
		
		List<Pessoa> resultado = new ArrayList<>();
		
		
		return resultado;
	}

	@Override
	public List<Pessoa> buscarPessoasPorSalarioBaseEntre(BigDecimal salarioBaseInicio, BigDecimal salarioBaseFim) {
		
		List<Pessoa> resultado = new ArrayList<>();
		
		
		return resultado;
	}

	@Override
	public List<Pessoa> buscarPessoasPorEscolaridadeConcluida() {
		
		List<Pessoa> resultado = new ArrayList<>();
		
		
		return resultado;
	}

	@Override
	public List<Pessoa> buscarPessoasPorEscolaridadeAreaAtuacao(String areaAtuacao) {
		
		List<Pessoa> resultado = new ArrayList<>();
		
		
		return resultado;
	}

	@Override
	public List<Pessoa> buscarPessoasPorEscolaridadeAnoTermino(Integer ano) {
		
		List<Pessoa> resultado = new ArrayList<>();
		
		
		return resultado;
	}

	@Override
	public List<Pessoa> buscarPessoasPorEscolaridadeQuantidadeSemestre(Integer semestre) {
		
		List<Pessoa> resultado = new ArrayList<>();
		
		
		return resultado;
	}

	@Override
	public List<Pessoa> buscarPessoasPorProfissaoAreaAtuacaoEscolaridadeConcluido(String areaAtuacao) {
		
		List<Pessoa> resultado = new ArrayList<>();
		
		
		return resultado;
	}

	@Override
	public List<Pessoa> buscarPessoasPorProfissaoAreaAtuacaoEscolaridadePorSemestre(String areaAtuacao,
			Integer semestre) {
		
		List<Pessoa> resultado = new ArrayList<>();
		
		
		return resultado;
	}

	@Override
	public List<Pessoa> buscarPessoasPorEstadoCivilProfissaoAreaAtuacaoEscolaridadePorAreaAtuacao(String estadoCivil,
			String areaAtuacaoProfissao, String areaAtuacaoEscolaridade) {
		
		List<Pessoa> resultado = new ArrayList<>();
		
		
		return resultado;
	}

	@Override
	public List<Endereco> buscarEnderecoDasPessoasMaioresIdadeEEstadoCivil(String estadoCivil) {
		
		List<Endereco> resultado = new ArrayList<>();
		
		
		return resultado;
	}

	@Override
	public List<Endereco> buscarEnderecoPorTipoEndereco(String tipoEndereco) {
		
		List<Endereco> resultado = new ArrayList<>();
		
		
		return resultado;
	}

	@Override
	public List<Endereco> buscarNomeRuaEnderecoPorCidadePorPessoaSexoConjungeComAnoNascimento(String cidade,
			String sexo, Integer anoNascimentoConjunge) {
		
		List<Endereco> resultado = new ArrayList<>();
		
		
		return resultado;
	}

	@Override
	public List<String> buscarNomeDoConjungeDasPessoasMaioresIdadeEEstadoCivil(String estadoCivil) {
		
		List<String> resultado = new ArrayList<>();
		
		
		return resultado;
	}

	@Override
	public List<String> buscarNomeDoConjungeDasPessoasPorEstadoCivil(List<String> estadoCivil) {
		
		List<String> resultado = new ArrayList<>();
		
		
		return resultado;
	}

	@Override
	public List<String> buscarNomeDoConjungeMaioresDeIdadeDasPessoasPorEstadoCivil(String estadoCivil) {
		
		List<String> resultado = new ArrayList<>();
		
		
		return resultado;
	}

	@Override
	public List<Contato> buscarContatoPorProfissaoAreaAtuacao(String areaAtuacao) {
		
		List<Contato> resultado = new ArrayList<>();
		
		
		return resultado;
	}

	@Override
	public List<Contato> buscarContatoPorProfissaoAreaAtuacaoEnderecoPorEstadoEBairro(String areaAtuacao, String estado,
			String bairro) {
		
		List<Contato> resultado = new ArrayList<>();
		
		
		return resultado;
	}

	@Override
	public List<Contato> buscarContatoPorProfissaoAreaAtuacaoEnderecoPorEstadosEBairro(String areaAtuacao,
			List<String> estados, String bairro) {
		
		List<Contato> resultado = new ArrayList<>();
		
		
		return resultado;
	}

	@Override
	public List<Contato> buscarContatoPorTipoContato(String tipoContato) {
		
		List<Contato> resultado = new ArrayList<>();
		
		
		return resultado;
	}

	@Override
	public List<Contato> buscarContatoPorTiposContato(List<String> tipoContato) {
		
		List<Contato> resultado = new ArrayList<>();
		
		
		return resultado;
	}

	@Override
	public List<String> buscarEmailPorPessoaAnoNascimentoProfissaoAreaAtuacaoEscolaridadePorAreaAtuacao(
			Integer anoNasicmento, String areaAtuacaoProfissao, String areaAtuacaoEscolaridade) {
		
		List<String> resultado = new ArrayList<>();
		
		
		return resultado;
	}

	@Override
	public List<String> buscarNomeInstituicaoPorPorAreaAtuacao(String areaAtuacaoProfissao) {
		
		List<String> resultado = new ArrayList<>();
		
		
		return resultado;
	}

	@Override
	public List<String> buscarNomePessoasPorProfissaoPorAreaAtuacao(String areaAtuacaoProfissao) {
		
		List<String> resultado = new ArrayList<>();
		
		
		return resultado;
	}

	@Override
	public List<String> buscarNomePessoasPorEscolaridadePorAreaAtuacao(String areaAtuacaoEscolaridade) {
		
		List<String> resultado = new ArrayList<>();
		
		
		return resultado;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorProfissaoPorAreaAtuacao(String areaAtuacaoProfissao) {
		
		Integer resultado;
		
		
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorEscolaridadePorAreaAtuacao(String areaAtuacaoEscolaridade) {
		
		Integer resultado;
		
		
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasMaioresIdade() {
		
		Integer resultado;
		
		
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalDasPessoasPorEstadoCivil(String estadoCivil) {
		
		Integer resultado;
		
		
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorBairro(String bairro) {
		
		Integer resultado;
		
		
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorProfissao(String nomeProfissao) {
		
		Integer resultado;
		
		
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorSalarioBaseMaiorIgual(BigDecimal salarioBase) {
		
		Integer resultado;
		
		
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorEscolaridadeAreaAtuacao(String areaAtuacao) {
		
		Integer resultado;
		
		
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorEscolaridadeQuantidadeSemestre(Integer semestre) {
		
		Integer resultado;
		
		
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorProfissaoAreaAtuacaoEscolaridadePorSemestre(String areaAtuacao,
			Integer semestre) {
		
		Integer resultado;
		
		
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalEmailPorPessoaAnoNascimentoProfissaoAreaAtuacaoEscolaridadePorAreaAtuacao(
			Integer anoNasicmento, String areaAtuacaoProfissao, String areaAtuacaoEscolaridade) {
		
		Integer resultado;
		
		
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalConjugeDasPessoasMaioresIdadeEEstadoCivil(String estadoCivil) {
		
		Integer resultado;
		
		
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalContatosPorTipoContato(String tipoContato) {
		
		Integer resultado;
		
		
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorEscolaridadeNaoConcluida() {
		
		Integer resultado;
		
		
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorBairroPorProfissaoPorAreaAtuacao(String bairro,
			String areaAtuacaoProfissao) {
		
		Integer resultado;
		
		
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalContatoPorTiposContato(List<String> tipoContato) {
		
		Integer resultado;
		
		
		return null;
	}

}
