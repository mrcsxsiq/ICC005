package bancodedados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import projeto.Professor;

public class ProfessorDAO extends BancoDeDados {

	public ArrayList<Professor> listarProfessor() {

		ArrayList<Professor> lista = new ArrayList<>();
		try {
			String sql = "SELECT * FROM PROFESSOR";
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Professor p = new Professor(rs.getInt("ID"),rs.getString("NOME"), rs.getString("EMAIL"));
				lista.add(p);
			}
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}

		return lista;
	}
	
	public Professor professoPorCodigo(int idProfessor) {

		try {
			String sql = "SELECT * FROM PROFESSOR WHERE ID = "+idProfessor;
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Professor p = new Professor(rs.getInt("ID"),rs.getString("NOME"), rs.getString("EMAIL"));
				return p;
			}
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}

		return null;
	}
	
	public Professor professoPorNome(String nome) {

		try {
			String sql = "SELECT * FROM PROFESSOR WHERE NOME = '"+nome+"';";
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Professor p = new Professor(rs.getInt("ID"),rs.getString("NOME"), rs.getString("EMAIL"));
				return p;
			}
		} catch (SQLException e) {
		}

		return null;
	}
	
	public boolean removerProfessor(int p) {
		try {
			String sql = "DELETE FROM PROFESSOR WHERE ID = "+p+";";
			Statement st = conexao.createStatement();
			st.executeUpdate(sql);
			return true;
		} catch (SQLException e){
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean cadastrarProfessor(Professor p){
		try {
			String sql = "INSERT INTO PROFESSOR (ID, NOME, EMAIL) VALUES ('0','"+p.getNome()+"','"+p.getEmail()+"');";
			Statement st = conexao.createStatement();
			st.executeUpdate(sql);
			return true;
		} catch (SQLException e){
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean atualizarProfessor(Professor p){
		try {
			String sql = "UPDATE PROFESSOR SET NOME = '"+p.getNome()+"', EMAIL = '"+p.getEmail()+"' WHERE ID = '"+p.getID()+"';";
			Statement st = conexao.createStatement();
			st.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
		      System.out.println(e.getMessage());
		      return false; 
		}
	}
	
}
