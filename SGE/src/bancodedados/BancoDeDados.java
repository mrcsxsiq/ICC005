package bancodedados;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class BancoDeDados {
	
	static String url = "jdbc:mysql://localhost:3306/SGE";
	static String user = "root";
	static String pass = "";
	static Connection conexao = null;

	
	public boolean conecta(){
		try {
			conexao = DriverManager.getConnection(url, user, pass);
			return true;
		} catch (SQLException e){
			System.out.println(e.getMessage());
			return false;
		}
	}

	public  boolean desconecta(){
		try {
			conexao.close();
			return true;
		} catch (SQLException e){
			System.out.println(e.getMessage());
			return false;
		}
	}

}