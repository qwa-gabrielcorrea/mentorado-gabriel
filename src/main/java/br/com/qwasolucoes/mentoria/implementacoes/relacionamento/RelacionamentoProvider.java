package br.com.qwasolucoes.mentoria.implementacoes.relacionamento;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.qwasolucoes.mentoria.interfaces.relacionamento.Relacionamentos;
import br.com.qwasolucoes.mentoria.modelagem_dados.Contato;
import br.com.qwasolucoes.mentoria.modelagem_dados.Empresa;
import br.com.qwasolucoes.mentoria.modelagem_dados.Endereco;
import br.com.qwasolucoes.mentoria.modelagem_dados.Pessoa;
import br.com.qwasolucoes.mentoria.modelagem_dados.Profissao;

public class RelacionamentoProvider implements Relacionamentos {

	List<Pessoa> listaPessoas = new ArrayList<>();
	List<Endereco> listaEnderecos = new ArrayList<>();
	List<Contato> listaContatos = new ArrayList<>();
	List<Profissao> listaProfissoes = new ArrayList<>();
	List<Empresa> listaEmpresas = new ArrayList<>();

	String csvPessoas = "Pessoa.csv";
	String csvEnderecos = "Endere�o.csv";
	String csvContatos = "Contato.csv";
	String csvProfissoes = "Profissao.csv";
	String csvEmpresas = "Empresa.csv";

	List<String> todosCsv = new ArrayList<>();

	@Override
	public void iniciar() {

		try {
			leituraCsvPessoas(csvPessoas);
			leituraCsvEnderecos(csvEnderecos);
			leituraCsvContatos(csvContatos);
			leituraCsvProfissoes(csvProfissoes);
			leituraCsvEmpresas(csvEmpresas);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private BufferedReader abrirCsv(String arquivo) throws IOException {
		return new BufferedReader(new FileReader(arquivo));
	}

	@Override
	public List<String> buscarCPFsDasPessoasMaioresIdade() {

		List<String> resultado = new ArrayList<>();

		Integer idade;

		for (Pessoa pessoa : listaPessoas) {
			try {
				idade = converteIdade(pessoa.getDataNascimento());

				if (idade >= 18) {
					resultado.add(pessoa.getCpfCnpj());
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return resultado;
	}

	@Override
	public List<String> buscarNomeSobrenomeDasPessoasPorAnorNascimento(Integer ano) {

		List<String> resultado = new ArrayList<>();

		for (Pessoa pessoa : listaPessoas) {
			if (pessoa.getDataNascimento().contains(ano.toString())) {
				resultado.add(pessoa.getNome() + pessoa.getSobrenome());
			}
		}

		return resultado;
	}

	@Override
	public List<String> buscarNomeSobrenomeDasPessoasPorEstadoCivil(String estadoCivil) {

		List<String> resultado = new ArrayList<>();

		for (Pessoa pessoa : listaPessoas) {
			if (estadoCivil.equals(pessoa.getEstadoCivil())) {
				resultado.add(pessoa.getNome() + pessoa.getSobrenome());
			}
		}

		return resultado;
	}

	@Override
	public List<Pessoa> buscarPessoasPorTipoResidencia(String tipoResidencia) {

		List<Pessoa> resultado = new ArrayList<>();

		for (Endereco endereco : listaEnderecos) {
			if (tipoResidencia.equals(endereco.getTipoEndereço())) {
				for (Pessoa pessoa : listaPessoas) {
					if (endereco.getCpfCnpj().equals(pessoa.getCpfCnpj())) {
						resultado.add(pessoa);
					}
				}
			}
		}

		return resultado;
	}

	@Override
	public List<Pessoa> buscarPessoasPorTipoContato(String tipoContato) {

		List<Pessoa> resultado = new ArrayList<>();

		for (Contato contato : listaContatos) {
			if (tipoContato.equals(contato.getTipo())) {
				for (Pessoa pessoa : listaPessoas) {
					if (contato.getCpfCnpj().equals(pessoa.getCpfCnpj())) {
						resultado.add(pessoa);
					}
				}
			}
		}

		return resultado;
	}

	@Override
	public List<Pessoa> buscarPessoasPorBairro(String bairro) {

		List<Pessoa> resultado = new ArrayList<>();

		for (Endereco endereco : listaEnderecos) {
			if (bairro.equals(endereco.getBairro())) {
				for (Pessoa pessoa : listaPessoas) {
					if (endereco.getCpfCnpj().equals(pessoa.getCpfCnpj())) {
						resultado.add(pessoa);
					}
				}
			}
		}

		return resultado;
	}

	@Override
	public List<Pessoa> buscarPessoasPorNomeBairroContem(String valor) {

		List<Pessoa> resultado = new ArrayList<>();

		for (Endereco endereco : listaEnderecos) {
			if (endereco.getBairro().contains(valor)) {
				for (Pessoa pessoa : listaPessoas) {
					if (endereco.getCpfCnpj().equals(pessoa.getCpfCnpj())) {
						resultado.add(pessoa);
					}
				}
			}
		}

		return resultado;
	}

	@Override
	public List<Pessoa> buscarPessoasPorEstado(String estado) {

		List<Pessoa> resultado = new ArrayList<>();

		for (Endereco endereco : listaEnderecos) {
			if (endereco.getEstado().equals(estado)) {
				for (Pessoa pessoa : listaPessoas) {
					if (endereco.getCpfCnpj().equals(pessoa.getCpfCnpj())) {
						resultado.add(pessoa);
					}
				}
			}
		}

		return resultado;
	}

	@Override
	public List<Pessoa> buscarPessoasPorProfissao(String nomeProfissao) {

		List<Pessoa> resultado = new ArrayList<>();

		for (Empresa empresa : listaEmpresas) {
			for (Profissao profissao : empresa.getProfissao()) {
				if (nomeProfissao.equals(profissao.getNomeProfissao())) {
					for (Pessoa pessoa : listaPessoas) {
						if (pessoa.getCpfCnpj().equals(empresa.getCpfCnpj())) {
							resultado.add(pessoa);
						}
					}
				}
			}
		}

		return resultado;
	}

	@Override
	public List<Pessoa> buscarPessoasPorProfissaoNomeAreaAtuacaoContem(String valor) {

		List<Pessoa> resultado = new ArrayList<>();

		for (Empresa empresa : listaEmpresas) {
			String cpfEmpresa = empresa.getCpfCnpj();

			for (Profissao profissao : empresa.getProfissao()) {
				String codigoProfissao = profissao.getCodigoProfissao();

				for (Profissao profissoes : listaProfissoes) {
					if (profissoes.getCodigoProfissao().equals(codigoProfissao)) {
						boolean contem = profissoes.getNomeProfissao().contains(valor)
								|| profissoes.getAreaAtuação().contains(valor);
						if (contem) {
							for (Pessoa pessoa : listaPessoas) {
								if (pessoa.getCpfCnpj().equals(cpfEmpresa)) {
									if (!resultado.contains(pessoa)) {
										resultado.add(pessoa);
									}
									break;
								}
							}
						}
						break;
					}
				}

			}
		}

		return resultado;
	}

	@Override
	public List<Pessoa> buscarPessoasPorSalarioBaseMaiorQue(BigDecimal salarioBase) {

		List<Pessoa> resultado = new ArrayList<>();

		for (Empresa empresa : listaEmpresas) {

			boolean retornaValor = false;

			for (Profissao profissao : empresa.getProfissao()) {

				BigDecimal salario = new BigDecimal(profissao.getSalarioBase());

				if (salario.compareTo(salarioBase) > 0) {
					retornaValor = true;
					break;
				}
			}
			if (retornaValor) {
				for (Pessoa pessoa : listaPessoas) {
					if (pessoa.getCpfCnpj().equals(empresa.getCpfCnpj())) {
						if (!resultado.contains(pessoa)) {
							resultado.add(pessoa);
						}
					}
				}
			}
		}

		return resultado;
	}

	@Override
	public List<Pessoa> buscarPessoasPorSalarioBaseMaiorIgual(BigDecimal salarioBase) {

		List<Pessoa> resultado = new ArrayList<>();

		for (Empresa empresa : listaEmpresas) {

			boolean retornaValor = false;

			for (Profissao profissao : empresa.getProfissao()) {

				BigDecimal salario = new BigDecimal(profissao.getSalarioBase());

				if (salario.compareTo(salarioBase) <= 0) {
					retornaValor = true;
					break;
				}
			}
			if (retornaValor) {
				for (Pessoa pessoa : listaPessoas) {
					if (pessoa.getCpfCnpj().equals(empresa.getCpfCnpj())) {
						if (!resultado.contains(pessoa)) {
							resultado.add(pessoa);
						}
					}
				}
			}
		}

		return resultado;
	}

	@Override
	public List<Pessoa> buscarPessoasPorSalarioBaseEntre(BigDecimal salarioBaseInicio, BigDecimal salarioBaseFim) {

		List<Pessoa> resultado = new ArrayList<>();

		for (Empresa empresa : listaEmpresas) {

			boolean retornaValor = false;

			for (Profissao profissao : empresa.getProfissao()) {

				BigDecimal salario = new BigDecimal(profissao.getSalarioBase());

				if (salario.compareTo(salarioBaseInicio) < 0 && salario.compareTo(salarioBaseFim) > 0) {
					retornaValor = true;
					break;
				}
			}
			if (retornaValor) {
				for (Pessoa pessoa : listaPessoas) {
					if (pessoa.getCpfCnpj().equals(empresa.getCpfCnpj())) {
						if (!resultado.contains(pessoa)) {
							resultado.add(pessoa);
						}
					}
				}
			}
		}

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

	public Integer converteIdade(String dataNascimento) throws ParseException {

		if (dataNascimento == null || dataNascimento.trim().isEmpty()) {
			return null;
		}

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false); // de acordo com o StackOverFlow, garante que as datas sejam v�lidas

		Date dataFormatada;
		Calendar nascimento = Calendar.getInstance();
		Calendar hoje = Calendar.getInstance();

		try {
			dataFormatada = sdf.parse(dataNascimento);
		} catch (ParseException e) {
			e.getMessage();
			return null;
		}

		nascimento.setTime(dataFormatada);

		Integer idadeConvertida = hoje.get(Calendar.YEAR) - nascimento.get(Calendar.YEAR);

		if (hoje.get(Calendar.MONTH) <= nascimento.get(Calendar.MONTH)) {
			idadeConvertida--;
		}
		return idadeConvertida;
	}

	private void leituraCsvPessoas(String arquivo) throws IOException {
		BufferedReader br = abrirCsv(arquivo);
		String linha;

		while ((linha = br.readLine()) != null) {
			String[] info = linha.split(",");

			Pessoa pessoa = new Pessoa();
			pessoa.setNome(info[0]);
			pessoa.setSobrenome(info[1]);
			pessoa.setDataNascimento(info[2]);
			pessoa.setSexo(info[3]);
			pessoa.setCpfCnpj(info[4]);
			pessoa.setEstadoCivil(info[5]);

			if ("CASADO".equals(pessoa.getEstadoCivil())) {
				Pessoa conjuge = new Pessoa();
				conjuge.setNome(info[6]);
				pessoa.setConjuge(conjuge);
			}

			listaPessoas.add(pessoa);
		}
		br.close();
	}

	private void leituraCsvEnderecos(String arquivo) throws IOException {
		BufferedReader br = abrirCsv(arquivo);
		String linha;

		while ((linha = br.readLine()) != null) {
			String[] info = linha.split(",");

			Endereco endereco = new Endereco();
			endereco.setCpfCnpj(info[0]);
			endereco.setTipoEndereço(info[1]);
			endereco.setPais(info[2]);
			endereco.setRua(info[3]);
			endereco.setNumero(info[4]);
			endereco.setBairro(info[5]);
			endereco.setCidade(info[6]);
			endereco.setEstado(info[7]);
			endereco.setCep(info[8]);
			endereco.setComplementoCep(info[9]);

			listaEnderecos.add(endereco);
		}
		br.close();
	}

	private void leituraCsvContatos(String arquivo) throws IOException {
		BufferedReader br = abrirCsv(arquivo);
		String linha;

		while ((linha = br.readLine()) != null) {
			String[] info = linha.split(",");

			Contato contato = new Contato();
			contato.setCpfCnpj(info[0]);
			contato.setTipo(info[1]);
			contato.setValor(info[2]);

			listaContatos.add(contato);
		}
		br.close();
	}

	private void leituraCsvProfissoes(String arquivo) throws IOException {
		BufferedReader br = abrirCsv(arquivo);
		String linha;

		while ((linha = br.readLine()) != null) {
			String[] info = linha.split(",");

			Profissao profissao = new Profissao();
			profissao.setCodigoProfissao(info[0]);
			profissao.setNomeProfissao(info[1]);
			profissao.setAreaAtuação(info[2]);
			profissao.setSalarioBase(info[3]);

			listaProfissoes.add(profissao);
		}
		br.close();
	}

	private void leituraCsvEmpresas(String arquivo) throws IOException {
		BufferedReader br = abrirCsv(arquivo);
		String linha;

		while ((linha = br.readLine()) != null) {
			String[] info = linha.split(",");

			Empresa empresa = new Empresa();
			empresa.setNome(info[0]);
			empresa.setCodigoProfissao(info[1]);
			empresa.setCpfCnpj(info[2]);

			List<Profissao> profPorEmpresa = new ArrayList<>();
			for (Profissao profissao : listaProfissoes) {
				if (profissao.getCodigoProfissao().equals(info[1])) {
					profPorEmpresa.add(profissao);
				}
			}

			empresa.setProfissao(profPorEmpresa);
			listaEmpresas.add(empresa);
		}
		br.close();
	}
}
