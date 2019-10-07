package app;

import exceptions.DadosTurmaIncompletosException;

public class Turma {

	private char codigo;
	private int numVagas;
	private String descricao;

	public Turma(char codigo, int numVagas, String descricao) throws DadosTurmaIncompletosException {
		if (atributosNulos(codigo, numVagas)) {
			StringBuilder builder = criaBuilder(); 
			criaMensagemException(codigo, numVagas, builder);
			throw new DadosTurmaIncompletosException( builder.toString() );
		}
		this.codigo = codigo; 
		this.numVagas = numVagas;
		this.descricao = descricao;
	}

	private void criaMensagemException(char codigo, int numVagas, StringBuilder builder) {
		builder.append("Dados informados para turma estao incompletos. ");
		builder.append(codigo == 0 ? "Codigo: " + codigo : "");
		builder.append(numVagas <=0 ? "Numero de vagas: " + numVagas : "");
	}

	private StringBuilder criaBuilder() {
		StringBuilder builder = new StringBuilder();
		return builder;
	}

	private boolean atributosNulos(char codigo, int numVagas) {
		return codigo == 0 || numVagas <= 0;
	}

	public static Turma obterTurma(char codigo, int numVagas, String descricao) throws DadosTurmaIncompletosException {
		Turma resposta = null;
		try {
			resposta = new Turma(codigo, numVagas, descricao);
		} catch (DadosTurmaIncompletosException e) {
			throw e;
		}
		return resposta;
	}

	public char getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getNumVagas() {
		return numVagas;
	}

}
