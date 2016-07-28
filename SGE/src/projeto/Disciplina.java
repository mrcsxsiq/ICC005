package projeto;
public class Disciplina {
	
	private int professor;
	private String nome;
	private String sigla;
	private String cargaHoraria;
	private String diasSemana;
	private int id;
	
	public Disciplina (int id, int professor, String nome, String sigla, String cargaHoraria, String diasSemana){
		this.professor = professor;
		this.nome = nome;
		this.sigla = sigla;
		this.cargaHoraria = cargaHoraria;
		this.diasSemana = diasSemana;
		this.id = id;
	}
	
	public Disciplina (int professor, String nome, String sigla, String cargaHoraria, String diasSemana){
		this(0, professor, nome, sigla, cargaHoraria, diasSemana);
	}
	
	public void setProfessor (int professor){
		this.professor = professor;
	}
	
	public void setNome (String nome){
		this.nome = nome;
	}
	
	public void setSigla (String sigla){
		this.sigla = sigla;
	}
	
	public void setCargaHoraria (String cargaHoraria){
		this.cargaHoraria = cargaHoraria;
	}
	
	public void setDiasSemana (String diasSemana){
		this.diasSemana = diasSemana;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getProfessor(){
		return this.professor;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public String getSigla(){
		return this.sigla;
	}
	
	public String getCargaHoraria(){
		return this.cargaHoraria;
	}
	
	public String getDiasSemana(){
		return this.diasSemana;
	}

	public int getId() {
		return this.id;
	}

	
}
