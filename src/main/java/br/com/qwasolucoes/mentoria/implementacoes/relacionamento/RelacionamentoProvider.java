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
import java.util.List;

import br.com.qwasolucoes.mentoria.interfaces.relacionamento.Relacionamentos;
import br.com.qwasolucoes.mentoria.modelagem_dados.Contato;
import br.com.qwasolucoes.mentoria.modelagem_dados.Empresa;
import br.com.qwasolucoes.mentoria.modelagem_dados.Endereco;
import br.com.qwasolucoes.mentoria.modelagem_dados.Pessoa;
import br.com.qwasolucoes.mentoria.modelagem_dados.Profissao;

public class RelacionamentoProvider implements Relacionamentos{
	
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
		
		
		todosCsv.add(csvPessoas);
		todosCsv.add(csvEnderecos);
		todosCsv.add(csvContatos);
		todosCsv.add(csvProfissoes);
		todosCsv.add(csvProfissoes);
		 
		BufferedReader br = null; 
		String linha = "";
		String divisor = ",";
		
		try 
		{
			for(String arquivo : todosCsv) {
				br = new BufferedReader(new FileReader(arquivo));
				
				if (arquivo.equals(csvPessoas)) {
					while ((linha = br.readLine()) != null) {
						
						Pessoa pessoa = new Pessoa();
						String[] info = linha.split(divisor);
						
						pessoa.setNome(info[0]);
						pessoa.setSobrenome(info[1]);
						pessoa.setDataNascimento(info[2]);
						pessoa.setSexo(info[3]);
						pessoa.setCpfCnpj(info[4]);
						pessoa.setEstadoCivil(info[5]);
						
						if(pessoa.getEstadoCivil().equals("CASADO")) {
							Pessoa conjuge = new Pessoa();
							conjuge.setNome(info[6]);
							pessoa.setConjuge(conjuge);					
						}
						
						listaPessoas.add(pessoa);
					}
				}
				
				if (arquivo.equals(csvEnderecos)) {
					while ((linha = br.readLine()) != null) {
						
						Endereco endereco = new Endereco();
						String[] info = linha.split(divisor);
						
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
				}
				
				if (arquivo.equals(csvContatos)) {
					while ((linha = br.readLine()) != null) {
						
						Contato contato = new Contato();
						String[] info = linha.split(divisor);
						
						contato.setCpfCnpj(info[0]);
						contato.setTipo(info[1]);
						contato.setValor(info[2]);
						
						listaContatos.add(contato);
					}
				}
				
				if (arquivo.equals(csvProfissoes)) {
					while ((linha = br.readLine()) != null) {
						
						Profissao profissao = new Profissao();
						String[] info = linha.split(divisor);
						
						profissao.setCodigoProfissao(info[0]);
						profissao.setNomeProfissao(info[1]);
						profissao.setAreaAtuação(info[2]);
						profissao.setSalarioBase(info[3]);
						
						listaProfissoes.add(profissao);
					}
				}
				
				if (arquivo.equals(csvEmpresas)) {
					while ((linha = br.readLine()) != null) {
						
						Empresa empresa = new Empresa();
						String[] info = linha.split(divisor);
						
						empresa.setNome(info[0]);
						empresa.setCodigoProfissao(info[1]);
						empresa.setCpfCnpj(info[2]);
						empresa.setProfissao(listaProfissoes); //validar

					}
				}
			}
			
		} 
		catch(IOException e) {
			e.printStackTrace();
		}  finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e){
					e.printStackTrace();
				}
			}
		}
				
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
		
		for(Endereco endereco : listaEnderecos) {
			if(tipoResidencia.equals(endereco.getTipoEndereço())) {
				for(Pessoa pessoa : listaPessoas) {
					if(endereco.getCpfCnpj().equals(pessoa.getCpfCnpj())) {
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
		
		for(Contato contato : listaContatos) {
			if(tipoContato.equals(contato.getTipo())) {
				for(Pessoa pessoa : listaPessoas) {
					if(contato.getCpfCnpj().equals(pessoa.getCpfCnpj())) {
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
			if(bairro.equals(endereco.getBairro())) {
				for (Pessoa pessoa : listaPessoas) {
					if(endereco.getCpfCnpj().equals(pessoa.getCpfCnpj())) {
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
		
		for(Endereco endereco : listaEnderecos) {
			if(endereco.getBairro().contains(valor)) {
				for(Pessoa pessoa : listaPessoas) {
					if(endereco.getCpfCnpj().equals(pessoa.getCpfCnpj())) {
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
		
		for(Endereco endereco : listaEnderecos) {
			if(endereco.getEstado().equals(estado)) {
				for(Pessoa pessoa : listaPessoas) {
					if(endereco.getCpfCnpj().equals(pessoa.getCpfCnpj())) {
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
	
	public Integer converteIdade (String dataNascimento) throws ParseException{
		
		if (dataNascimento == null || dataNascimento.trim().isEmpty()) {
			return null;
		}
		
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false); //de acordo com o StackOverFlow, garante que as datas sejam v�lidas

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
        	idadeConvertida --;
        }
        return idadeConvertida; 
    }

}
