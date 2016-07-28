package projeto;

public class Nota {

	private int id;
	private int disciplina;
	private double nota;
	
	public Nota(int id, int disciplina, double nota){
		this.disciplina = disciplina;
		this.nota = nota;
		this.id = id;
	}
	
	public Nota(int disciplina, double nota){
		this(0, disciplina, nota);
	}
	
	public void setDisciplina(int disciplina){
		this.disciplina = disciplina;
	}
	
	public void setNota(double nota){
		this.nota = nota;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getDisciplina(){
		return this.disciplina;
	}
	
	public double getNota(){
		return this.nota;
	}

	public int getId() {
		return id;
	}

}
