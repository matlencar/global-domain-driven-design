package br.com.fiap.baze.banco.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionFactory {

	private static Connection conexao;
	
	/**
	 * A conenection factory serve para obter uma conexao com o banco de dados
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	
	public static Connection getConnetion() throws ClassNotFoundException, SQLException {
		if(conexao == null) {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conexao = DriverManager.getConnection("jdbc:oracle:thin:@fiap.com.br:1521:orcl","rm94642","fiap");
			
		}
		return conexao;
	}
}
