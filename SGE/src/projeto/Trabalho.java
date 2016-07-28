package projeto;

public class Trabalho {

	private int id;
	private int disciplina;
	private String dataMarcada;
	private String dataEntrega;
	private String observacao;

	public Trabalho(int id, int disciplina, String dataMarcada,
			String dataEntrega, String observacao) {
		this.id = id;
		this.disciplina = disciplina;
		this.dataMarcada = dataMarcada;
		this.dataEntrega = dataEntrega;
		this.observacao = observacao;
	}

	public Trabalho(int disciplina, String dataMarcada, String dataEntrega,
			String observacao) {
		this(0, disciplina, dataMarcada, dataEntrega, observacao);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(int disciplina) {
		this.disciplina = disciplina;
	}

	public String getDataMarcada() {
		return dataMarcada;
	}

	public void setDataMarcada(String dataMarcada) {
		this.dataMarcada = dataMarcada;
	}

	public String getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}