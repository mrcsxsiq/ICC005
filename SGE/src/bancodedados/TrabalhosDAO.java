package bancodedados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import projeto.Professor;
import projeto.Prova;
import projeto.Trabalho;

public class TrabalhosDAO extends BancoDeDados {

	public ArrayList<Trabalho> listarTrabalhos() {

		ArrayList<Trabalho> lista = new ArrayList<>();
		try {
			String sql = "SELECT * FROM TRABALHOS";
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Trabalho t = new Trabalho(rs.getInt("ID"), rs.getInt("DISCIPLINA"), rs.getString("DATAMARCADA"), rs.getString("DATAENTREGA"), rs.getString("OBSERVACOES"));
				lista.add(t);
			}
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}

		return lista;
	}
	
	public Trabalho trabalhoPorCodigo(int idTrabalho) {

		try {
			String sql = "SELECT * FROM TRABALHOS WHERE ID = "+idTrabalho;
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Trabalho t = new Trabalho(rs.getInt("ID"), rs.getInt("DISCIPLINA"), rs.getString("DATAMARCADA"), rs.getString("DATAENTREGA"), rs.getString("OBSERVACOES"));
				return t;
			}
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}

		return null;
	}

	public boolean removerTrabalho(int t) {
		try {
			String sql = "DELETE FROM TRABALHOS WHERE ID = "+t+";";
			Statement st = conexao.createStatement();
			st.executeUpdate(sql);
			return true;
		} catch (SQLException e){
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean cadastrarTrabalho(Trabalho t){
		try {
			String sql = "INSERT INTO TRABALHOS (ID, DISCIPLINA, DATAMARCADA, DATAENTREGA, OBSERVACOES) VALUES ('0','"+t.getDisciplina()+"','"+t.getDataMarcada()+"','"+t.getDataEntrega()+"','"+t.getObservacao()+"');";
			Statement st = conexao.createStatement();
			st.executeUpdate(sql);
			return true;
		} catch (SQLException e){
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean atualizarTrabalho(Trabalho t){
		try {
			String sql = "UPDATE TRABALHOS SET DISCIPLINA = '"+t.getDisciplina()+"', DATAMARCADA = '"+t.getDataMarcada()+"', DATAENTREGA = '"+t.getDataEntrega()+"', OBSERVACOES = '"+t.getObservacao()+"' WHERE ID = '"+t.getId()+"';";
			Statement st = conexao.createStatement();
			st.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
		      System.out.println(e.getMessage());
		      return false; 
		}
	}
	

}
