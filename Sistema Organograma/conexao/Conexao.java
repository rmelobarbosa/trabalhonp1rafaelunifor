package conexao;

/*
 * TRABALHO DE NP1 - PROFESSOR RAFAEL BARBOSA
 * ALUNOS: FRANCISCO VALMAR, NAT�LIA MACAMBIRA e MARINA GOSSON.
 * Todos os direitos reservados. All right reserved.
 * Proib�da a c�pia parcial ou integral desse trabalho. 
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
	 * M�todo o qual estabecer� uma conex�o com o banco de Dados MySQL.
	 */
	public static Connection getConnection() throws SQLException {

		try {
			Class.forName(driver);
			return DriverManager.getConnection(conexao, usuario, senha);

		} catch (ClassNotFoundException e) {
			System.out
					.println("Erro ao estabelecer uma conex�o com o banco de dados!");
			throw new SQLException(e.getMessage());
		}
	}
}
