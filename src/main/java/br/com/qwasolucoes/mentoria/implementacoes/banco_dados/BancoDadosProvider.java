package br.com.qwasolucoes.mentoria.implementacoes.banco_dados;

import br.com.qwasolucoes.mentoria.interfaces.banco_dados.BancoDados;

import java.math.BigDecimal;
import java.util.List;

public class BancoDadosProvider implements BancoDados {

	@Override
	public void iniciarDDL() {

 }

	@Override
	public List<String> iniciarInserts() {

		return null;
	}

	@Override
	public String criarSQLBuscarCPFsDasPessoasMaioresIdade() {

		return null;
	}

	@Override
	public String criarSQLBuscarNomeSobrenomeDasPessoasPorAnorNascimento(Integer ano) {

		return null;
	}

	@Override
	public String criarSQLBuscarNomeSobrenomeDasPessoasPorEstadoCivil(String estadoCivil) {

		return null;
	}

	@Override
	public String criarSQLBuscarPessoasPorTipoResidencia(String tipoResidencia) {

		return null;
	}

	@Override
	public String criarSQLBuscarPessoasPorTipoContato(String tipoContato) {

		return null;
	}

	@Override
	public String criarSQLBuscarPessoasPorBairro(String bairro) {

		return null;
	}

	@Override
	public String criarSQLBuscarPessoasPorNomeBairroContem(String valor) {

		return null;
	}

	@Override
	public String criarSQLBuscarPessoasPorEstado(String estado) {

		return null;
	}

	@Override
	public String criarSQLBuscarPessoasPorProfissao(String nomeProfissao) {

		return null;
	}

	@Override
	public String criarSQLBuscarPessoasPorProfissaoNomeAreaAtuacaoContem(String valor) {

		return null;
	}

	@Override
	public String criarSQLBuscarPessoasPorSalarioBaseMaiorQue(BigDecimal salarioBase) {

		return null;
	}

	@Override
	public String criarSQLBuscarPessoasPorSalarioBaseMaiorIgual(BigDecimal salarioBase) {

		return null;
	}

	@Override
	public String criarSQLBuscarPessoasPorSalarioBaseEntre(BigDecimal salarioBaseInicio, BigDecimal salarioBaseFim) {

		return null;
	}

	@Override
	public String criarSQLBuscarPessoasPorEscolaridadeConcluida() {

		return null;
	}

	@Override
	public String criarSQLBuscarPessoasPorEscolaridadeAreaAtuacao(String areaAtuacao) {

		return null;
	}

	@Override
	public String criarSQLBuscarPessoasPorEscolaridadeAnoTermino(Integer ano) {

		return null;
	}

	@Override
	public String criarSQLBuscarPessoasPorEscolaridadeQuantidadeSemestre(Integer semestre) {

		return null;
	}

	@Override
	public String criarSQLBuscarPessoasPorProfissaoAreaAtuacaoEscolaridadeConcluido(String areaAtuacao) {

		return null;
	}

	@Override
	public String criarSQLBuscarPessoasPorProfissaoAreaAtuacaoEscolaridadePorSemestre(String areaAtuacao,
			Integer semestre) {

		return null;
	}

	@Override
	public String criarSQLBuscarPessoasPorEstadoCivilProfissaoAreaAtuacaoEscolaridadePorAreaAtuacao(String estadoCivil,
			String areaAtuacaoProfissao, String areaAtuacaoEscolaridade) {

		return null;
	}

	@Override
	public String criarSQLBuscarEnderecoDasPessoasMaioresIdadeEEstadoCivil(String estadoCivil) {

		return null;
	}

	@Override
	public String criarSQLBuscarEnderecoPorTipoEndereco(String tipoEndereco) {

		return null;
	}

	@Override
	public String criarSQLBuscarNomeRuaEnderecoPorCidadePorPessoaSexoConjungeComAnoNascimento(String cidade,
			String sexo, Integer anoNascimentoConjunge) {

		return null;
	}

	@Override
	public String criarSQLBuscarNomeDoConjungeDasPessoasMaioresIdadeEEstadoCivil(String estadoCivil) {

		return null;
	}

	@Override
	public String criarSQLBuscarNomeDoConjungeDasPessoasPorEstadoCivil(List<String> estadoCivil) {

		return null;
	}

	@Override
	public String criarSQLBuscarNomeDoConjungeMaioresDeIdadeDasPessoasPorEstadoCivil(String estadoCivil) {

		return null;
	}

	@Override
	public String criarSQLBuscarContatoPorProfissaoAreaAtuacao(String areaAtuacao) {

		return null;
	}

	@Override
	public String criarSQLBuscarContatoPorProfissaoAreaAtuacaoEnderecoPorEstadoEBairro(String areaAtuacao,
			String estado, String bairro) {

		return null;
	}

	@Override
	public String criarSQLBuscarContatoPorProfissaoAreaAtuacaoEnderecoPorEstadosEBairro(String areaAtuacao,
			List<String> estados, String bairro) {

		return null;
	}

	@Override
	public String criarSQLBuscarContatoPorTipoContato(String tipoContato) {

		return null;
	}

	@Override
	public String criarSQLBuscarContatoPorTiposContato(List<String> tipoContato) {

		return null;
	}

	@Override
	public String criarSQLBuscarEmailPorPessoaAnoNascimentoProfissaoAreaAtuacaoEscolaridadePorAreaAtuacao(
			Integer anoNasicmento, String areaAtuacaoProfissao, String areaAtuacaoEscolaridade) {

		return null;
	}

	@Override
	public String criarSQLBuscarNomeInstituicaoPorPorAreaAtuacao(String areaAtuacaoProfissao) {

		return null;
	}

	@Override
	public String criarSQLBuscarNomePessoasPorProfissaoPorAreaAtuacao(String areaAtuacaoProfissao) {

		return null;
	}

	@Override
	public String criarSQLBuscarNomePessoasPorEscolaridadePorAreaAtuacao(String areaAtuacaoEscolaridade) {

		return null;
	}

	@Override
	public String criarSQLBuscarQuantidadeTotalPessoasPorProfissaoPorAreaAtuacao(String areaAtuacaoProfissao) {

		return null;
	}

	@Override
	public String criarSQLBuscarQuantidadeTotalPessoasPorEscolaridadePorAreaAtuacao(String areaAtuacaoEscolaridade) {

		return null;
	}

	@Override
	public String criarSQLBuscarQuantidadeTotalPessoasMaioresIdade() {

		return null;
	}

	@Override
	public String criarSQLBuscarQuantidadeTotalDasPessoasPorEstadoCivil(String estadoCivil) {

		return null;
	}

	@Override
	public String criarSQLBuscarQuantidadeTotalPessoasPorBairro(String bairro) {

		return null;
	}

	@Override
	public String criarSQLBuscarQuantidadeTotalPessoasPorProfissao(String nomeProfissao) {

		return null;
	}

	@Override
	public String criarSQLBuscarQuantidadeTotalPessoasPorSalarioBaseMaiorIgual(BigDecimal salarioBase) {

		return null;
	}

	@Override
	public String criarSQLBuscarQuantidadeTotalPessoasPorEscolaridadeAreaAtuacao(String areaAtuacao) {

		return null;
	}

	@Override
	public String criarSQLBuscarQuantidadeTotalPessoasPorEscolaridadeQuantidadeSemestre(Integer semestre) {

		return null;
	}

	@Override
	public String criarSQLBuscarQuantidadeTotalPessoasPorProfissaoAreaAtuacaoEscolaridadePorSemestre(String areaAtuacao,
			Integer semestre) {

		return null;
	}

	@Override
	public String criarSQLBuscarQuantidadeTotalEmailPorPessoaAnoNascimentoProfissaoAreaAtuacaoEscolaridadePorAreaAtuacao(
			Integer anoNasicmento, String areaAtuacaoProfissao, String areaAtuacaoEscolaridade) {

		return null;
	}

	@Override
	public String criarSQLBuscarQuantidadeTotalConjugeDasPessoasMaioresIdadeEEstadoCivil(String estadoCivil) {

		return null;
	}

	@Override
	public String criarSQLBuscarQuantidadeTotalContatosPorTipoContato(String tipoContato) {

		return null;
	}

	@Override
	public String criarSQLBuscarQuantidadeTotalPessoasPorEscolaridadeNaoConcluida() {

		return null;
	}

	@Override
	public String criarSQLBuscarQuantidadeTotalPessoasPorBairroPorProfissaoPorAreaAtuacao(String bairro,
			String areaAtuacaoProfissao) {

		return null;
	}

	@Override
	public String criarSQLBuscarQuantidadeTotalContatoPorTiposContato(List<String> tipoContato) {

		return null;
	}

}
