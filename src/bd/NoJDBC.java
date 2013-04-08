package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class NoJDBC {

	private String driver = "com.mysql.jdbc.Driver";
	private String conexao = "jdbc:mysql://127.0.0.1:3306/mydb";
	private String usuario = "root";
	private String senha = "valmar";
	private Connection connection;
	private Statement statement;

	public void adicionarNo(String nome, String cargo, int posicao) {

		try {
			Class.forName(this.driver);
			connection = DriverManager.getConnection(this.conexao,
					this.usuario, this.senha);
			statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO no (nome, cargo, id_no_pai) "
					+ "VALUES ('" + nome + "', '" + cargo + "', " + posicao
					+ ")");
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {

		}

	}

	public void seache(int id) {
		try {
			Class.forName(this.driver);
			connection = DriverManager.getConnection(this.conexao,
					this.usuario, this.senha);
			statement = connection.createStatement();
			statement.executeUpdate("SELECT from no WHERE id " + id);
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {

		}
	}

	public void deleteFromDB(int id) {
		try {
			Class.forName(this.driver);
			connection = DriverManager.getConnection(this.conexao,
					this.usuario, this.senha);
			statement = connection.createStatement();
			statement.executeUpdate("DELETE FROM no WHERE id = " + id);
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {

		}
	}
}
