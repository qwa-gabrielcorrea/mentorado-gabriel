package br.com.qwasolucoes.mentoria.implementacoes.relacionamento;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.qwasolucoes.mentoria.implementacoes.logica_programacao.LogicaProgramacaoProvider;
import br.com.qwasolucoes.mentoria.interfaces.relacionamento.Relacionamentos;
import br.com.qwasolucoes.mentoria.modelagem_dados.Contato;
import br.com.qwasolucoes.mentoria.modelagem_dados.Endereco;
import br.com.qwasolucoes.mentoria.modelagem_dados.Pessoa;

public class RelacionamentoProvider implements Relacionamentos{

	@Override
	public void iniciar() {
		 
		
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
		
		
		
		List<String> resultado = new ArrayList<>();
		
		return resultado;
	}

	@Override
	public List<String> buscarNomeSobrenomeDasPessoasPorEstadoCivil(String estadoCivil) {
		
		List<String> resultado = new ArrayList<>();
		
		return resultado;
	}

	@Override
	public List<Pessoa> buscarPessoasPorTipoResidencia(String tipoResidencia) {
		
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
		
		
		return resultado;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorEscolaridadePorAreaAtuacao(String areaAtuacaoEscolaridade) {
		
		Integer resultado;
		
		
		return resultado;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasMaioresIdade() {
		
		Integer resultado;
		
		
		return resultado;
	}

	@Override
	public Integer buscarQuantidadeTotalDasPessoasPorEstadoCivil(String estadoCivil) {
		
		Integer resultado;
		
		
		return resultado;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorBairro(String bairro) {
		
		Integer resultado;
		
		
		return resultado;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorProfissao(String nomeProfissao) {
		
		Integer resultado;
		
		
		return resultado;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorSalarioBaseMaiorIgual(BigDecimal salarioBase) {
		
		Integer resultado;
		
		
		return resultado;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorEscolaridadeAreaAtuacao(String areaAtuacao) {
		
		Integer resultado;
		
		
		return resultado;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorEscolaridadeQuantidadeSemestre(Integer semestre) {
		
		Integer resultado;
		
		
		return resultado;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorProfissaoAreaAtuacaoEscolaridadePorSemestre(String areaAtuacao,
			Integer semestre) {
		
		Integer resultado;
		
		
		return resultado;
	}

	@Override
	public Integer buscarQuantidadeTotalEmailPorPessoaAnoNascimentoProfissaoAreaAtuacaoEscolaridadePorAreaAtuacao(
			Integer anoNasicmento, String areaAtuacaoProfissao, String areaAtuacaoEscolaridade) {
		
		Integer resultado;
		
		
		return resultado;
	}

	@Override
	public Integer buscarQuantidadeTotalConjugeDasPessoasMaioresIdadeEEstadoCivil(String estadoCivil) {
		
		Integer resultado;
		
		
		return resultado;
	}

	@Override
	public Integer buscarQuantidadeTotalContatosPorTipoContato(String tipoContato) {
		
		Integer resultado;
		
		
		return resultado;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorEscolaridadeNaoConcluida() {
		
		Integer resultado;
		
		
		return resultado;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorBairroPorProfissaoPorAreaAtuacao(String bairro,
			String areaAtuacaoProfissao) {
		
		Integer resultado;
		
		
		return resultado;
	}

	@Override
	public Integer buscarQuantidadeTotalContatoPorTiposContato(List<String> tipoContato) {
		
		Integer resultado;
		
		
		return resultado;
	}

}
