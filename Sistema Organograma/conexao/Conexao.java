package conexao;

/*
 * TRABALHO DE NP1 - PROFESSOR RAFAEL BARBOSA
 * ALUNOS: FRANCISCO VALMAR, NATÁLIA MACAMBIRA e MARINA GOSSON.
 * Todos os direitos reservados. All right reserved.
 * Proibída a cópia parcial ou integral desse trabalho. 
 * Total or partial copy of this work is forbidden.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private static String driver = "com.mysql.jdbc.Driver";
	private static String conexao = "jdbc:mysql://127.0.0.1:3306/mydb";
	private static String usuario = "root";
	private static String senha = "valmar";

	/*
	 * Método o qual estabecerá uma conexão com o banco de Dados MySQL.
	 */
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(conexao, usuario, senha);
			return connection;
		} catch (ClassNotFoundException e) {
			System.out
					.println("ERRO: Driver MySQL é inválido!");

		} catch (SQLException e) {
			System.out.println("ERRO:Conexão ao Banco de Dados falhou!");
		} 
		return connection;
	}
}
