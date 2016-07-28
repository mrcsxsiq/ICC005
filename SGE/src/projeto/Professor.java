package projeto;

public class Professor {

	private int id;
	private String nome;
	private String email;

	public Professor(int id, String nome, String email) {
		this.nome = nome;
		this.email = email;
		this.id = id;
	}

	public Professor(String nome, String email) {
		this(0, nome, email);
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getID() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	public String getEmail() {
		return this.email;
	}

}
