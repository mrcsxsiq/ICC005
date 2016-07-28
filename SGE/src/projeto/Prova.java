package projeto;

public class Prova {

	private int id;
	private int disciplina;
	private String dataMarcada;
	private String dataAgendada;
	private String assunto;

	public Prova(int id, int disciplina, String dataMarcada, String dataAgendada,
			String assunto) {
		this.setId(id);
		this.disciplina = disciplina;
		this.dataMarcada = dataMarcada;
		this.dataAgendada = dataAgendada;
		this.assunto = assunto;
	}
	
	public Prova (int disciplina, String dataMarcada, String dataAgendada,
			String assunto) {
		this(0, disciplina, dataMarcada, dataAgendada, assunto);
	}

	public void setDisciplina(int disciplina) {
		this.disciplina = disciplina;
	}

	public void setDataMarcada(String dataMarcada) {
		this.dataMarcada = dataMarcada;
	}

	public void setDataAgendada(String dataAgendada) {
		this.dataAgendada = dataAgendada;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public int getDisciplina() {
		return this.disciplina;
	}

	public String getDataMarcada() {
		return this.dataMarcada;
	}

	public String getDataAgendada() {
		return this.dataAgendada;
	}

	public String getAssunto() {
		return this.assunto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
