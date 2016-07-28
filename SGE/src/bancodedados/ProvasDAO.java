package bancodedados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import projeto.Professor;
import projeto.Prova;

public class ProvasDAO extends BancoDeDados {

	public ArrayList<Prova> listarProvas() {

		ArrayList<Prova> lista = new ArrayList<>();
		try {
			String sql = "SELECT * FROM PROVAS";
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Prova p = new Prova(rs.getInt("ID"), rs.getInt("DISCIPLINA"), rs.getString("DATAMARCADA"), rs.getString("DATAAGENDADA"), rs.getString("ASSUNTOS"));
				lista.add(p);
			}
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}

		return lista;
	}
	
	public Prova provaPorCodigo(int idProva) {

		try {
			String sql = "SELECT * FROM PROVAS WHERE ID = "+idProva;
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Prova p = new Prova(rs.getInt("ID"), rs.getInt("DISCIPLINA"), rs.getString("DATAMARCADA"), rs.getString("DATAAGENDADA"), rs.getString("ASSUNTOS"));
				return p;
			}
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}

		return null;
	}

	public boolean removerProva(int p) {
		try {
			String sql = "DELETE FROM PROVAS WHERE ID = "+p+";";
			Statement st = conexao.createStatement();
			st.executeUpdate(sql);
			return true;
		} catch (SQLException e){
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean cadastrarProva(Prova p){
		try {
			String sql = "INSERT INTO PROVAS (ID, DISCIPLINA, DATAMARCADA, DATAAGENDADA, ASSUNTOS) VALUES ('0','"+p.getDisciplina()+"','"+p.getDataMarcada()+"','"+p.getDataAgendada()+"','"+p.getAssunto()+"');";
			Statement st = conexao.createStatement();
			st.executeUpdate(sql);
			return true;
		} catch (SQLException e){
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean atualizarProva(Prova p){
		try {
			String sql = "UPDATE PROVAS SET DISCIPLINA = '"+p.getDisciplina()+"', DATAMARCADA = '"+p.getDataMarcada()+"', DATAAGENDADA = '"+p.getDataAgendada()+"', ASSUNTOS = '"+p.getAssunto()+"' WHERE ID = '"+p.getId()+"';";
			Statement st = conexao.createStatement();
			st.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
		      System.out.println(e.getMessage());
		      return false; 
		}
	}
	

}
