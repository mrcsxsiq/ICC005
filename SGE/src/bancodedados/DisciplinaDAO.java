package bancodedados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import projeto.Disciplina;

public class DisciplinaDAO extends BancoDeDados {

	public ArrayList<Disciplina> listarDisciplinas() {

		ArrayList<Disciplina> lista = new ArrayList<>();
		try {
			String sql = "SELECT * FROM DISCIPLINAS";
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Disciplina p = new Disciplina(rs.getInt("ID"),
						rs.getInt("PROFESSOR"), rs.getString("NOME"),
						rs.getString("SIGLA"), rs.getString("CARGAHORARIA"),
						rs.getString("DIASSEMANA"));
				lista.add(p);
			}
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}

		return lista;
	}
	
	public Disciplina disciplinaPorCodigo (int codigo){
		try {
			String sql = "SELECT * FROM DISCIPLINAS WHERE ID = "+codigo;
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Disciplina d = new Disciplina(rs.getInt("ID"),
						rs.getInt("PROFESSOR"), rs.getString("NOME"),
						rs.getString("SIGLA"), rs.getString("CARGAHORARIA"),
						rs.getString("DIASSEMANA"));
				return d;
			}
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			return null;
		}
		return null;
	}
	
	public Disciplina disciplinaPorNome (String nome){
		try {
			String sql = "SELECT * FROM DISCIPLINAS WHERE NOME = '"+nome+"';";
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Disciplina d = new Disciplina(rs.getInt("ID"),
						rs.getInt("PROFESSOR"), rs.getString("NOME"),
						rs.getString("SIGLA"), rs.getString("CARGAHORARIA"),
						rs.getString("DIASSEMANA"));
				return d;
			}
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			return null;
		}
		return null;
	}

	public String disciplinaProfessor(int idProfessor) {
		try {
			String sql = "SELECT * FROM PROFESSOR WHERE ID = " + idProfessor + ";";
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				return rs.getString("NOME");
			}
			return null;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public boolean removerDisciplina(int d) {
		try {
			String sql1 = "DELETE FROM DISCIPLINAS WHERE ID = " + d + ";";
			String sql2 = "DELETE FROM NOTAS WHERE DISCIPLINA = " + d + ";";
			String sql3 = "DELETE FROM PROVAS WHERE DISCIPLINA = " + d + ";";
			String sql4 = "DELETE FROM TRABALHOS WHERE DISCIPLINA = " + d + ";";
			Statement st = conexao.createStatement();
			st.executeUpdate(sql1);
			st.executeUpdate(sql2);
			st.executeUpdate(sql3);
			st.executeUpdate(sql4);
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}

	public boolean cadastrarDisciplina(Disciplina d) {
		try {
			String sql = 
					"INSERT INTO DISCIPLINAS (ID, NOME, SIGLA, CARGAHORARIA, DIASSEMANA, PROFESSOR) " +
					"VALUES ('"+d.getId()+"','"
					+d.getNome()+"','"
					+d.getSigla()+"','"
					+d.getCargaHoraria()+"','"
					+d.getDiasSemana()+"','"
					+d.getProfessor()+"');";
			Statement st = conexao.createStatement();
			st.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean atualizarDisciplina(Disciplina d) {
		try {
			String sql = 
			"UPDATE DISCIPLINAS SET NOME = '"+d.getNome()+"', SIGLA = '"+d.getSigla()+"', CARGAHORARIA = '"+d.getCargaHoraria()+"', DIASSEMANA = '"+d.getDiasSemana()+"', PROFESSOR = '"+d.getProfessor()+"' WHERE ID = '"+d.getId()+"' ;";
			Statement st = conexao.createStatement();
			st.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

}
