import java.sql.Connection;
import java.sql.SQLException;

import organograma.No;

import com.mysql.jdbc.PreparedStatement;

import conexao.Conexao;


public class TesteBanco {
	Connection connection;
	/*
	 * Método o qual realizará a gravação de um novo nó no banco de dados.
	 */
	public void saveData(No no) {
		try {
			connection = Conexao.getConnection();

			PreparedStatement preparedStatement = null;
			preparedStatement = (PreparedStatement) connection
					.prepareStatement("INSERT INTO no (nome, cargo, id_no_pai) VALUES (?, ?, ?) ");

			preparedStatement.setString(1, no.getNome());
			preparedStatement.setString(2, no.getDescricao());
			preparedStatement.setInt(3, no.getNoIdPai());

			preparedStatement.close();
			connection.close();

		} catch (SQLException e) {
			System.out.println("ERRO: Gravação mal-sucedida.");
		}
		
	
	}
	
	public static void main(String[] args) {
		
	}
}
