package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioDAO {
	private String driver = "com.mysql.jdbc.Driver";
	private String conexao = "jdbc:mysql://127.0.0.1:3306/mydb";
	private String usuario = "root";
	private String senha = "valmar";
	private Connection connection;
	private Statement statement;

	public void search(String login, String Senha) {
		try {
			Class.forName(this.driver);
			connection = DriverManager.getConnection(this.conexao,
					this.usuario, this.senha);
			statement = connection.createStatement();
			statement
					.executeUpdate("SELECT login, senha from no WHERE login = "
							+ login + "' AND senha = '" + senha + "';");
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {

		}
	}
}
