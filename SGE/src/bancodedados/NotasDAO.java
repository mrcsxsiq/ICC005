package bancodedados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import projeto.Nota;
import projeto.Professor;

public class NotasDAO extends BancoDeDados {

	public ArrayList<Nota> listarNotas() {

		ArrayList<Nota> lista = new ArrayList<>();
		try {
			String sql = "SELECT * FROM NOTAS";
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Nota n = new Nota(rs.getInt("ID"),rs.getInt("DISCIPLINA"), rs.getDouble("NOTA"));
				lista.add(n);
			}
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}

		return lista;
	}
	

	
	public boolean removerNota(int n) {
		try {
			String sql = "DELETE FROM NOTAS WHERE ID = "+n+";";
			Statement st = conexao.createStatement();
			st.executeUpdate(sql);
			return true;
		} catch (SQLException e){
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean cadastrarNota(Nota n){
		try {
			String sql = "INSERT INTO NOTAS (ID, DISCIPLINA, NOTA) VALUES ('0','"+n.getDisciplina()+"','"+n.getNota()+"');";
			Statement st = conexao.createStatement();
			st.executeUpdate(sql);
			return true;
		} catch (SQLException e){
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public Nota notaPorCodigo(int idNota) {

		try {
			String sql = "SELECT * FROM NOTAS WHERE ID = "+idNota;
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Nota n = new Nota(rs.getInt("ID"),rs.getInt("DISCIPLINA"), rs.getDouble("NOTA"));
				return n;
			}
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}

		return null;
	}
	public boolean atualizarNota(Nota n){
		try {
			String sql = "UPDATE NOTAS SET DISCIPLINA = '"+n.getDisciplina()+"', NOTA = '"+n.getNota()+"' WHERE ID = '"+n.getId()+"';";
			Statement st = conexao.createStatement();
			st.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
		      System.out.println(e.getMessage());
		      return false; 
		}
	}

}
