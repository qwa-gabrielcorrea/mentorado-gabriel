package br.com.qwasolucoes.mentoria.implementacoes.relacionamento;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.qwasolucoes.mentoria.interfaces.relacionamento.Relacionamentos;
import br.com.qwasolucoes.mentoria.modelagem_dados.Contato;
import br.com.qwasolucoes.mentoria.modelagem_dados.Empresa;
import br.com.qwasolucoes.mentoria.modelagem_dados.Endereco;
import br.com.qwasolucoes.mentoria.modelagem_dados.Escolaridade;
import br.com.qwasolucoes.mentoria.modelagem_dados.Instituicao;
import br.com.qwasolucoes.mentoria.modelagem_dados.Pessoa;
import br.com.qwasolucoes.mentoria.modelagem_dados.Profissao;

public class RelacionamentoProvider implements Relacionamentos {

	List<Pessoa> listaPessoas = new ArrayList<>();
	List<Endereco> listaEnderecos = new ArrayList<>();
	List<Contato> listaContatos = new ArrayList<>();
	List<Profissao> listaProfissoes = new ArrayList<>();
	List<Empresa> listaEmpresas = new ArrayList<>();
	List<Escolaridade> listaEscolaridade = new ArrayList<>();
	List<Instituicao> listaInstituicoes = new ArrayList<>();

	String csvPessoas      = "Pessoa.csv";
	String csvEnderecos    = "Endere�o.csv";
	String csvContatos     = "Contato.csv";
	String csvProfissoes   = "Profissao.csv";
	String csvEmpresas     = "Empresa.csv";
	String csvEscolaridade = "Escolaridade.csv";
	String csvInstituicao  = "Instituição de Ensino.csv";

	List<String> todosCsv = new ArrayList<>();

	@Override
	public void iniciar() {

		try {

			leituraCsvPessoas(csvPessoas);
			leituraCsvEnderecos(csvEnderecos);
			leituraCsvContatos(csvContatos);
			leituraCsvProfissoes(csvProfissoes);
			leituraCsvEmpresas(csvEmpresas);
			leituraCsvEscolaridade(csvEscolaridade);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private BufferedReader abrirCsv(String arquivo) throws IOException {

		InputStream input = getClass().getResourceAsStream(arquivo);
		
		if(input == null) {
			throw new IOException("Infelizmente, deu ruim nesse arquivo: " + arquivo);
		}
		
		return new BufferedReader(new InputStreamReader(input));
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

			if (separaAnoData(pessoa.getDataNascimento()) == ano) {
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

		for (Escolaridade escolaridade : listaEscolaridade) {
			if (escolaridade.getConcluido().equals("Sim")) {

				for (Pessoa pessoa : listaPessoas) {
					if (escolaridade.getCpfCnpj().equals(pessoa.getCpfCnpj())) {
						resultado.add(pessoa);
					}
				}
			}
		}

		return resultado;
	}

	@Override
	public List<Pessoa> buscarPessoasPorEscolaridadeAreaAtuacao(String areaAtuacao) {

		List<Pessoa> resultado = new ArrayList<>();

		for (Escolaridade escolaridade : listaEscolaridade) {
			for (Instituicao instituicao : listaInstituicoes) {
				if (instituicao.getCodigo().equals(escolaridade.getCodigoInstituicao())) {
					for (Pessoa pessoa : listaPessoas) {
						if (instituicao.getAreaAtuacao().equals(areaAtuacao)
								&& escolaridade.getCpfCnpj().equals(pessoa.getCpfCnpj())) {
							resultado.add(pessoa);
						}
					}
				}
			}
		}

		return resultado;
	}

	@Override
	public List<Pessoa> buscarPessoasPorEscolaridadeAnoTermino(Integer ano) {

		List<Pessoa> resultado = new ArrayList<>();

		for (Escolaridade escolaridade : listaEscolaridade) {

			if (ano == separaAnoData(escolaridade.getDataTermino())) {
				for (Pessoa pessoa : listaPessoas) {
					if (pessoa.getCpfCnpj().equals(escolaridade.getCpfCnpj())) {
						resultado.add(pessoa);
					}
				}
			}
		}

		return resultado;
	}

	@Override
	public List<Pessoa> buscarPessoasPorEscolaridadeQuantidadeSemestre(Integer semestre) {

		List<Pessoa> resultado = new ArrayList<>();

		for (Escolaridade escolaridade : listaEscolaridade) {
			for (Instituicao instituicao : listaInstituicoes) {
				if (escolaridade.getCodigoInstituicao().equals(instituicao.getCodigo())) {
					Integer qtdeSemestre = Integer.parseInt(instituicao.getQuantidadeSemestre());
					for (Pessoa pessoa : listaPessoas) {
						if (qtdeSemestre.equals(semestre) && escolaridade.getCpfCnpj().equals(pessoa.getCpfCnpj())) {
							resultado.add(pessoa);
						}
					}
				}
			}
		}

		return resultado;
	}

	@Override
	public List<Pessoa> buscarPessoasPorProfissaoAreaAtuacaoEscolaridadeConcluido(String areaAtuacao) {

		List<Pessoa> primeiroParam = buscarPessoasPorProfissaoNomeAreaAtuacaoContem(areaAtuacao);
		List<Pessoa> segundoParam = buscarPessoasPorEscolaridadeConcluida();

		List<Pessoa> resultado = new ArrayList<>(segundoParam);

		resultado.retainAll(primeiroParam);

		return resultado;
	}

	@Override
	public List<Pessoa> buscarPessoasPorProfissaoAreaAtuacaoEscolaridadePorSemestre(String areaAtuacao,
			Integer semestre) {

		List<Pessoa> primeiroParam = buscarPessoasPorProfissaoNomeAreaAtuacaoContem(areaAtuacao);
		List<Pessoa> segundoParam = new ArrayList<>();

		for (Escolaridade escolaridade : listaEscolaridade) {
			Integer semestreAtual = Integer.parseInt(escolaridade.getSemestreAtual());
			if (semestreAtual == semestre) {
				for (Pessoa pessoa : listaPessoas) {
					if (pessoa.getCpfCnpj().equals(escolaridade.getCpfCnpj())) {
						segundoParam.add(pessoa);
					}
				}
			}
		}

		List<Pessoa> resultado = new ArrayList<>(segundoParam);

		resultado.retainAll(primeiroParam);

		return resultado;
	}

	@Override
	public List<Pessoa> buscarPessoasPorEstadoCivilProfissaoAreaAtuacaoEscolaridadePorAreaAtuacao(String estadoCivil,
			String areaAtuacaoProfissao, String areaAtuacaoEscolaridade) {

		List<Pessoa> resultado = new ArrayList<>();
		List<Pessoa> primeiroParam = new ArrayList<>();

		for (Pessoa pessoa : listaPessoas) {
			if (pessoa.getEstadoCivil().equals(estadoCivil)) {
				for (Profissao profissao : listaProfissoes) {
					for (Empresa empresa : listaEmpresas) {
						if (empresa.getCodigoProfissao().equals(profissao.getCodigoProfissao())
								&& pessoa.getCpfCnpj().equals(empresa.getCpfCnpj())) {
							primeiroParam.add(pessoa);
						}
					}
				}
			}
		}

		for (Escolaridade escolaridade : listaEscolaridade) {
			for (Instituicao instituicao : listaInstituicoes) {
				if (escolaridade.getCodigoInstituicao().equals(instituicao.getCodigo())) {
					for (Pessoa pessoa : listaPessoas) {
						if (pessoa.getCpfCnpj().equals(escolaridade.getCpfCnpj())
								&& instituicao.getAreaAtuacao().equals(areaAtuacaoEscolaridade)) {
							resultado.add(pessoa);
						}
					}
				}
			}
		}

		resultado.retainAll(primeiroParam);

		return resultado;
	}

	@Override
	public List<Endereco> buscarEnderecoDasPessoasMaioresIdadeEEstadoCivil(String estadoCivil) {

		List<Endereco> resultado = new ArrayList<>();
		List<Pessoa> listaCpfs = new ArrayList<>();
		List<String> primeiroParam = buscarCPFsDasPessoasMaioresIdade();

		for (String cpf : primeiroParam) {
			for (Pessoa pessoa : listaPessoas) {
				if (pessoa.getCpfCnpj().equals(cpf)) {
					listaCpfs.add(pessoa);
				}
			}
		}

		for (Pessoa pessoa : listaCpfs) {
			if (pessoa.getEstadoCivil().equals(estadoCivil)) {
				for (Endereco endereco : pessoa.getEnderecos()) {
					resultado.add(endereco);
				}
			}
		}

		return resultado;
	}

	@Override
	public List<Endereco> buscarEnderecoPorTipoEndereco(String tipoEndereco) {

		List<Endereco> resultado = new ArrayList<>();

		for (Endereco endereco : listaEnderecos) {
			if (endereco.getTipoEndereço().equals(tipoEndereco)) {
				resultado.add(endereco);
			}
		}

		return resultado;
	}

	@Override
	public List<Endereco> buscarNomeRuaEnderecoPorCidadePorPessoaSexoConjungeComAnoNascimento(String cidade,
			String sexo, Integer anoNascimentoConjunge) {

		List<Endereco> resultado = new ArrayList<>();

		for (Endereco endereco : listaEnderecos) {
			if (endereco.getCidade().equals(cidade)) {
				for (Pessoa pessoa : listaPessoas) {
					if (endereco.getCpfCnpj().equals(pessoa.getCpfCnpj()) && pessoa.getSexo().equals(sexo)) {
						Pessoa conjunge = pessoa.getConjuge();
						if (separaAnoData(conjunge.getDataNascimento()).equals(anoNascimentoConjunge)) {
							resultado.add(endereco);
						}
					}
				}
			}
		}

		return resultado;
	}

	@Override
	public List<String> buscarNomeDoConjungeDasPessoasMaioresIdadeEEstadoCivil(String estadoCivil) {

		List<String> resultado = new ArrayList<>();
		List<String> primeiroParam = buscarCPFsDasPessoasMaioresIdade();

		for (Pessoa pessoa : listaPessoas) {
			if (pessoa.getEstadoCivil().equals(estadoCivil)) {
				Pessoa conjunge = pessoa.getConjuge();
				resultado.add(conjunge.getNome());
			}
		}

		resultado.retainAll(primeiroParam);

		return resultado;
	}

	@Override
	public List<String> buscarNomeDoConjungeDasPessoasPorEstadoCivil(List<String> estadoCivil) {

		List<String> resultado = new ArrayList<>();

		for (Pessoa pessoa : listaPessoas) {
			for (String estado : estadoCivil) {
				if (pessoa.getEstadoCivil().equals(estado)) {
					Pessoa conjunge = pessoa.getConjuge();
					resultado.add(conjunge.getNome());
				}
			}
		}

		return resultado;
	}

	@Override
	public List<String> buscarNomeDoConjungeMaioresDeIdadeDasPessoasPorEstadoCivil(String estadoCivil) {

		List<String> resultado = new ArrayList<>();
		Integer idade;

		for (Pessoa pessoa : listaPessoas) {
			if (pessoa.getEstadoCivil().equals(estadoCivil)) {
				Pessoa conjunge = pessoa.getConjuge();
				try {
					idade = converteIdade(conjunge.getDataNascimento());

					if (idade > -18) {
						resultado.add(conjunge.getNome());
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}

		return resultado;
	}

	@Override
	public List<Contato> buscarContatoPorProfissaoAreaAtuacao(String areaAtuacao) {

		List<Contato> resultado = new ArrayList<>();

		for (Profissao profissao : listaProfissoes) {
			for (Empresa empresa : listaEmpresas) {
				if (profissao.getCodigoProfissao().equals(empresa.getCodigoProfissao())) {
					for (Contato contato : listaContatos) {
						if (contato.getCpfCnpj().equals(empresa.getCpfCnpj())
								&& profissao.getAreaAtuação().equals(areaAtuacao)) {
							resultado.add(contato);
						}
					}
				}
			}
		}

		return resultado;
	}

	@Override
	public List<Contato> buscarContatoPorProfissaoAreaAtuacaoEnderecoPorEstadoEBairro(String areaAtuacao, String estado,
			String bairro) {

		List<Contato> primeiroParam = buscarContatoPorProfissaoAreaAtuacao(areaAtuacao);
		List<Contato> resultado = new ArrayList<>();

		for (Contato contato : listaContatos) {
			for (Pessoa pessoa : listaPessoas) {
				if (contato.getCpfCnpj().equals(pessoa.getCpfCnpj())) {
					for (Endereco endereco : pessoa.getEnderecos()) {
						if (endereco.getEstado().equals(estado) && endereco.getBairro().equals(bairro)) {
							resultado.add(contato);
						}
					}
				}
			}
		}

		resultado.retainAll(primeiroParam);

		return resultado;
	}

	@Override
	public List<Contato> buscarContatoPorProfissaoAreaAtuacaoEnderecoPorEstadosEBairro(String areaAtuacao,
			List<String> estados, String bairro) {

		List<Contato> resultado = new ArrayList<>();
		List<Contato> primeiroParam = new ArrayList<>();

		for (Profissao profissao : listaProfissoes) {
			for (Empresa empresa : listaEmpresas) {
				if (profissao.getCodigoProfissao().equals(empresa.getCodigoProfissao())) {
					for (Pessoa pessoa : listaPessoas) {
						if (pessoa.getCpfCnpj().equals(empresa.getCpfCnpj())) {
							for (Contato contato : listaContatos) {
								if (contato.getCpfCnpj().equals(pessoa.getCpfCnpj())
										&& profissao.getAreaAtuação().equals(areaAtuacao)) {
									primeiroParam.add(contato);
								}
							}
						}
					}
				}
			}
		}

		for (Endereco endereco : listaEnderecos) {
			for (Pessoa pessoa : listaPessoas) {
				if (endereco.getCpfCnpj().equals(pessoa.getCpfCnpj())) {
					for (String estado : estados) {
						if (endereco.getEstado().equals(estado) && endereco.getBairro().equals(bairro)) {
							for (Contato contato : listaContatos) {
								if (contato.getCpfCnpj().equals(pessoa.getCpfCnpj())) {
									resultado.add(contato);
								}
							}
						}
					}
				}
			}
		}

		resultado.retainAll(primeiroParam);

		return resultado;
	}

	@Override
	public List<Contato> buscarContatoPorTipoContato(String tipoContato) {

		List<Contato> resultado = new ArrayList<>();

		for (Contato contato : listaContatos) {
			if (contato.getTipo().equals(tipoContato)) {
				resultado.add(contato);
			}
		}

		return resultado;
	}

	@Override
	public List<Contato> buscarContatoPorTiposContato(List<String> tipoContato) {

		List<Contato> resultado = new ArrayList<>();

		for (Contato contato : listaContatos) {
			for (String tipo : tipoContato) {
				if (contato.getTipo().equals(tipo)) {
					resultado.add(contato);
				}
			}
		}

		return resultado;
	}

	@Override
	public List<String> buscarEmailPorPessoaAnoNascimentoProfissaoAreaAtuacaoEscolaridadePorAreaAtuacao(
			Integer anoNasicmento, String areaAtuacaoProfissao, String areaAtuacaoEscolaridade) {

		List<String> resultado = new ArrayList<>();
		List<String> primeiroParam = new ArrayList<>();
		List<String> segundoParam = new ArrayList<>();

		for (Contato contato : listaContatos) {
			for (Pessoa pessoa : listaPessoas) {
				if (separaAnoData(pessoa.getDataNascimento()).equals(anoNasicmento)
						&& contato.getCpfCnpj().equals(pessoa.getCpfCnpj())) {
					primeiroParam.add(contato.getValor());
				}
			}
		}

		for (Profissao profissao : listaProfissoes) {
			for (Empresa empresa : listaEmpresas) {
				if (profissao.getCodigoProfissao().equals(empresa.getCodigoProfissao())) {
					for (Pessoa pessoa : listaPessoas) {
						if (pessoa.getCpfCnpj().equals(empresa.getCpfCnpj())) {
							for (Contato contato : listaContatos) {
								if (contato.getCpfCnpj().equals(pessoa.getCpfCnpj())
										&& profissao.getAreaAtuação().equals(areaAtuacaoProfissao)) {
									segundoParam.add(contato.getValor());
								}
							}
						}
					}
				}
			}
		}

		segundoParam.retainAll(primeiroParam);

		for (Escolaridade escolaridade : listaEscolaridade) {
			for (Instituicao instituicao : listaInstituicoes) {
				if (instituicao.getCodigo().equals(escolaridade.getCodigoInstituicao())) {
					for (Pessoa pessoa : listaPessoas) {
						if (pessoa.getCpfCnpj().equals(escolaridade.getCpfCnpj())) {
							for (Contato contato : listaContatos) {
								if (contato.getCpfCnpj().equals(pessoa.getCpfCnpj())
										&& instituicao.getAreaAtuacao().equals(areaAtuacaoEscolaridade)) {
									resultado.add(contato.getValor());
								}
							}
						}
					}
				}
			}
		}

		resultado.retainAll(segundoParam);

		return resultado;
	}

	@Override
	public List<String> buscarNomeInstituicaoPorPorAreaAtuacao(String areaAtuacaoProfissao) {

		List<String> resultado = new ArrayList<>();

		for (Instituicao instituicao : listaInstituicoes) {
			for (Profissao profissao : listaProfissoes) {
				if (profissao.getAreaAtuação().equals(areaAtuacaoProfissao)
						&& profissao.getAreaAtuação().equals(instituicao.getAreaAtuacao())) {
					resultado.add(instituicao.getNome());
				}
			}
		}

		return resultado;
	}

	@Override
	public List<String> buscarNomePessoasPorProfissaoPorAreaAtuacao(String areaAtuacaoProfissao) {

		List<String> resultado = new ArrayList<>();

		for (Profissao profissao : listaProfissoes) {
			for (Empresa empresa : listaEmpresas) {
				if (profissao.getCodigoProfissao().equals(empresa.getCodigoProfissao())) {
					for (Pessoa pessoa : listaPessoas) {
						if (pessoa.getCpfCnpj().equals(profissao.getAreaAtuação())) {
							resultado.add(pessoa.getNome());
						}
					}
				}
			}
		}

		return resultado;
	}

	@Override
	public List<String> buscarNomePessoasPorEscolaridadePorAreaAtuacao(String areaAtuacaoEscolaridade) {

		List<String> resultado = new ArrayList<>();

		for (Escolaridade escolaridade : listaEscolaridade) {
			for (Instituicao instituicao : listaInstituicoes) {
				if (escolaridade.getCodigoInstituicao().equals(instituicao.getCodigo())) {
					for (Pessoa pessoa : listaPessoas) {
						if (instituicao.getAreaAtuacao().equals(areaAtuacaoEscolaridade)) {
							resultado.add(pessoa.getNome());
						}
					}
				}
			}
		}

		return resultado;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorProfissaoPorAreaAtuacao(String areaAtuacaoProfissao) {

		Integer resultado = 0;

		for (Profissao profissao : listaProfissoes) {
			for (Empresa empresa : listaEmpresas) {
				if (profissao.getCodigoProfissao().equals(empresa.getCodigoProfissao())) {
					for (Pessoa pessoa : listaPessoas) {
						if (pessoa.getCpfCnpj().equals(empresa.getCpfCnpj())) {
							resultado++;
						}
					}
				}
			}
		}

		return resultado;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorEscolaridadePorAreaAtuacao(String areaAtuacaoEscolaridade) {

		Integer resultado = 0;

		for (Escolaridade escolaridade : listaEscolaridade) {
			for (Instituicao instituicao : listaInstituicoes) {
				if (escolaridade.getCodigoInstituicao().equals(instituicao.getCodigo())) {
					for (Pessoa pessoa : listaPessoas) {
						if (pessoa.getCpfCnpj().equals(escolaridade.getCpfCnpj())
								&& instituicao.getAreaAtuacao().equals(areaAtuacaoEscolaridade)) {
							resultado++;
						}
					}
				}
			}
		}

		return resultado;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasMaioresIdade() {

		Integer resultado = 0;

		for (String qtde : buscarCPFsDasPessoasMaioresIdade()) {
			resultado++;
		}

		return resultado;
	}

	@Override
	public Integer buscarQuantidadeTotalDasPessoasPorEstadoCivil(String estadoCivil) {

		Integer resultado = 0;

		for (Pessoa pessoa : listaPessoas) {
			if (pessoa.getEstadoCivil().equals(estadoCivil)) {
				resultado++;
			}
		}

		return resultado;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorBairro(String bairro) {

		Integer resultado = 0;

		for (Endereco endereco : listaEnderecos) {
			for (Pessoa pessoa : listaPessoas) {
				if (pessoa.getCpfCnpj().equals(endereco.getCpfCnpj()) && endereco.getBairro().equals(bairro)) {
					resultado++;
				}
			}
		}

		return resultado;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorProfissao(String nomeProfissao) {

		Integer resultado = 0;

		for (Pessoa pessoa : listaPessoas) {
			for (Profissao profissao : listaProfissoes) {
				for (Empresa empresa : listaEmpresas) {
					if (profissao.getNomeProfissao().equals(nomeProfissao)
							&& pessoa.getCpfCnpj().equals(empresa.getCpfCnpj())
							&& profissao.getCodigoProfissao().equals(empresa.getCodigoProfissao())) {
						resultado++;
					}
				}
			}
		}

		return resultado;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorSalarioBaseMaiorIgual(BigDecimal salarioBase) {

		Integer resultado = 0;

		for (Empresa empresa : listaEmpresas) {

			boolean retornaValor = false;
			for (Profissao profissao : listaProfissoes) {

				BigDecimal salario = new BigDecimal(profissao.getSalarioBase());

				if (salario.compareTo(salarioBase) >= 0) {
					retornaValor = true;
					break;
				}
			}
			if (retornaValor) {
				for (Pessoa pessoa : listaPessoas) {
					if (pessoa.getCpfCnpj().equals(empresa.getCpfCnpj())) {
						resultado++;
					}
				}
			}
		}

		return resultado;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorEscolaridadeAreaAtuacao(String areaAtuacao) {

		Integer resultado = 0;

		for (Escolaridade escolaridade : listaEscolaridade) {
			for (Instituicao instituicao : listaInstituicoes) {
				if (escolaridade.getCodigoInstituicao().equals(instituicao.getCodigo())) {
					for (Pessoa pessoa : listaPessoas) {
						if (pessoa.getCpfCnpj().equals(escolaridade.getCpfCnpj())
								&& instituicao.getAreaAtuacao().equals(areaAtuacao)) {
							resultado++;
						}
					}
				}
			}
		}

		return resultado;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorEscolaridadeQuantidadeSemestre(Integer semestre) {

		Integer resultado = 0;

		for (Escolaridade escolaridade : listaEscolaridade) {
			for (Instituicao instituicao : listaInstituicoes) {
				if (escolaridade.getCodigoInstituicao().equals(instituicao.getCodigo())) {
					for (Pessoa pessoa : listaPessoas) {
						Integer qtdeSemestre = Integer.parseInt(instituicao.getQuantidadeSemestre());
						if (pessoa.getCpfCnpj().equals(escolaridade.getCpfCnpj()) && qtdeSemestre.equals(semestre)) {
							resultado++;
						}
					}
				}
			}
		}

		return resultado;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorProfissaoAreaAtuacaoEscolaridadePorSemestre(String areaAtuacao,
			Integer semestre) {

		Integer resultado = 0;
		List<Pessoa> primeiroParam = new ArrayList<>();
		List<Pessoa> segundoParam = new ArrayList<>();

		for (Profissao profissao : listaProfissoes) {
			for (Empresa empresa : listaEmpresas) {
				if (profissao.getCodigoProfissao().equals(empresa.getCodigoProfissao())) {
					for (Pessoa pessoa : listaPessoas) {
						if (pessoa.getCpfCnpj().equals(empresa.getCpfCnpj())
								&& profissao.getAreaAtuação().equals(areaAtuacao)) {
							primeiroParam.add(pessoa);
						}
					}
				}
			}
		}

		for (Escolaridade escolaridade : listaEscolaridade) {
			for (Instituicao instituicao : listaInstituicoes) {
				if (escolaridade.getCodigoInstituicao().endsWith(instituicao.getCodigo())) {
					for (Pessoa pessoa : listaPessoas) {
						Integer semestreAtual = Integer.parseInt(escolaridade.getSemestreAtual());
						if (pessoa.getCpfCnpj().equals(escolaridade.getCpfCnpj()) && semestreAtual.equals(semestre)) {
							segundoParam.add(pessoa);
						}
					}
				}
			}
		}

		segundoParam.retainAll(primeiroParam);

		for (Pessoa pessoa : segundoParam) {
			resultado++;
		}

		return resultado;
	}

	@Override
	public Integer buscarQuantidadeTotalEmailPorPessoaAnoNascimentoProfissaoAreaAtuacaoEscolaridadePorAreaAtuacao(
			Integer anoNasicmento, String areaAtuacaoProfissao, String areaAtuacaoEscolaridade) {

		Integer resultado = 0;
		List<String> primeiroParam = new ArrayList<>();
		List<String> segundoParam = new ArrayList<>();
		List<String> terceiroParam = new ArrayList<>();

		for (Pessoa pessoa : listaPessoas) {
			if (separaAnoData(pessoa.getDataNascimento()).equals(anoNasicmento)) {
				for (Contato contato : listaContatos) {
					if (contato.getCpfCnpj().equals(pessoa.getCpfCnpj())) {
						primeiroParam.add(contato.getValor());
					}
				}
			}
		}

		for (Profissao profissao : listaProfissoes) {
			for (Empresa empresa : listaEmpresas) {
				if (profissao.getCodigoProfissao().equals(empresa.getCodigoProfissao())) {
					for (Pessoa pessoa : listaPessoas) {
						if (pessoa.getCpfCnpj().equals(empresa.getCpfCnpj())
								&& profissao.getAreaAtuação().equals(areaAtuacaoProfissao)) {
							for (Contato contato : listaContatos) {
								if (contato.getCpfCnpj().equals(pessoa.getCpfCnpj())) {
									segundoParam.add(contato.getValor());
								}
							}
						}
					}
				}
			}
		}

		segundoParam.retainAll(primeiroParam);

		for (Escolaridade escolaridade : listaEscolaridade) {
			for (Instituicao instituicao : listaInstituicoes) {
				if (escolaridade.getCodigoInstituicao().equals(instituicao.getCodigo())) {
					for (Pessoa pessoa : listaPessoas) {
						if (pessoa.getCpfCnpj().equals(escolaridade.getCpfCnpj())
								&& instituicao.getAreaAtuacao().equals(areaAtuacaoEscolaridade)) {
							for (Contato contato : listaContatos) {
								if (contato.getCpfCnpj().equals(pessoa.getCpfCnpj())) {
									terceiroParam.add(contato.getValor());
								}
							}
						}
					}
				}
			}
		}

		terceiroParam.retainAll(segundoParam);

		for (String contato : terceiroParam) {
			resultado++;
		}

		return resultado;
	}

	@Override
	public Integer buscarQuantidadeTotalConjugeDasPessoasMaioresIdadeEEstadoCivil(String estadoCivil) {

		Integer resultado = 0;
		Integer idade;

		try {

			for (Pessoa pessoa : listaPessoas) {
				if (pessoa.getEstadoCivil().equals(estadoCivil)) {
					idade = converteIdade(pessoa.getDataNascimento());
					if (idade >= 18 && pessoa.getConjuge() != null) {
						resultado++;
					}
				}
			}

		} catch (ParseException e) {
			e.getMessage();
		}

		return resultado;
	}

	@Override
	public Integer buscarQuantidadeTotalContatosPorTipoContato(String tipoContato) {

		Integer resultado = 0;

		for (Contato contato : listaContatos) {
			if (contato.getTipo().equals(tipoContato)) {
				resultado++;
			}
		}

		return resultado;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorEscolaridadeNaoConcluida() {

		Integer resultado = 0;

		for (Escolaridade escolaridade : listaEscolaridade) {
			for (Pessoa pessoa : listaPessoas) {
				if (escolaridade.getCpfCnpj().equals(pessoa.getCpfCnpj())) {
					if (escolaridade.getConcluido().contains("S")) {
						resultado++;
					}
				}
			}
		}

		return resultado;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorBairroPorProfissaoPorAreaAtuacao(String bairro,
			String areaAtuacaoProfissao) {

		Integer resultado = 0;
		List<Pessoa> primeiroParam = new ArrayList<>();
		List<Pessoa> segundoParam = new ArrayList<>();
		
		for(Endereco endereco : listaEnderecos) {
			for(Pessoa pessoa : listaPessoas) {
				if(pessoa.getCpfCnpj().equals(endereco.getCpfCnpj()) && endereco.getBairro().equals(bairro)) {
					primeiroParam.add(pessoa);
				}
			}
		}
		
		for(Profissao profissao : listaProfissoes) {
			for(Empresa empresa : listaEmpresas) {
				if(profissao.getCodigoProfissao().equals(empresa.getCodigoProfissao())) {
					for(Pessoa pessoa : listaPessoas) {
						if(pessoa.getCpfCnpj().equals(empresa.getCpfCnpj()) && profissao.getAreaAtuação().equals(areaAtuacaoProfissao)) {
							segundoParam.add(pessoa);
						}
					}
				}
			}
		}
		
		segundoParam.retainAll(primeiroParam);
		
		for(Pessoa pessoa : listaPessoas) {
			resultado++;
		}

		return resultado;
	}

	@Override
	public Integer buscarQuantidadeTotalContatoPorTiposContato(List<String> tipoContato) {

		Integer resultado = 0;

		for (Contato contato : listaContatos) {
			for (String tipo : tipoContato) {
				if (contato.getTipo().equals(tipo)) {
					resultado++;
				}
			}
		}

		return resultado;
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
				Pessoa conjunge = new Pessoa();
				conjunge.setNome(info[6]);
				pessoa.setConjuge(conjunge);
			}

			List<Endereco> enderecoPorPessoa = new ArrayList<>();

			for (Endereco endereco : listaEnderecos) {
				if (pessoa.getCpfCnpj().equals(info[4])) {
					enderecoPorPessoa.add(endereco);
				}
			}

			pessoa.setEnderecos(enderecoPorPessoa);

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

	private void leituraCsvEscolaridade(String arquivo) throws IOException {
		BufferedReader br = abrirCsv(arquivo);
		String linha;

		while ((linha = br.readLine()) != null) {
			String[] info = linha.split(",");

			Escolaridade escolaridade = new Escolaridade();
			escolaridade.setCpfCnpj(info[0]);
			escolaridade.setCodigoInstituicao(info[1]);
			escolaridade.setConcluido(info[2]);
			escolaridade.setDataTermino(info[3]);
			escolaridade.setSemestreAtual(info[4]);

			List<Instituicao> escolaPorInstituicao = new ArrayList<>();
			for (Instituicao instituicao : listaInstituicoes) {
				if (instituicao.getCodigo().equals(info[1])) {
					escolaPorInstituicao.add(instituicao);
				}
			}

			escolaridade.setInstituicao(escolaPorInstituicao);
			listaEscolaridade.add(escolaridade);

		}
		br.close();

	}

	public Integer separaAnoData(String dataCompleta) {

		int limiteInicio = 6;
		int limiteFim = 10;
		String cortaData = dataCompleta.substring(limiteInicio, limiteFim);

		return Integer.parseInt(cortaData);
	}
}
