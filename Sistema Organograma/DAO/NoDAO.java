package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import organograma.No;

import com.mysql.jdbc.PreparedStatement;

import conexao.Conexao;

public class NoDAO {

	private Connection connection;

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

	/*
	 * Método o qual atualizará os dados de um Nó.
	 */
	public void updateData(No no) {
		try {
			connection = Conexao.getConnection();

			PreparedStatement preparedStatement = null;
			preparedStatement = (PreparedStatement) connection
					.prepareStatement("UPDATE no SET nome = ?, cargo = ?, id_no_pai = ? WHERE id = ? ");

			preparedStatement.setString(1, no.getNome());
			preparedStatement.setString(2, no.getDescricao());
			preparedStatement.setInt(3, no.getNoIdPai());
			preparedStatement.setInt(4, no.getIdNo());

			preparedStatement.close();
			connection.close();

		} catch (SQLException e) {
			System.out.println("ERRO: Atualização mal-sucedida.");
		}
	}

	/*
	 * Método o qual excluirá os dados de um Nó.
	 */
	public void deleteData(No no) {
		try {
			connection = Conexao.getConnection();

			PreparedStatement preparedStatement = null;
			preparedStatement = (PreparedStatement) connection
					.prepareStatement("DELETE FROM no WHERE id = ?");

			preparedStatement.setInt(1, no.getIdNo());

			preparedStatement.close();
			connection.close();

		} catch (SQLException e) {
			System.out.println("ERRO: Exclusão mal-sucedida.");
		}
	}

	/*
	 * Método o qual excluirá os dados de um Nó utlizando os paramentros da URL.
	 */
	public void deleteData(int id) {
		try {
			connection = Conexao.getConnection();

			PreparedStatement preparedStatement = null;
			preparedStatement = (PreparedStatement) connection
					.prepareStatement("DELETE FROM no WHERE id = ?");

			preparedStatement.setInt(1, id);

			preparedStatement.close();
			connection.close();

		} catch (SQLException e) {
			System.out.println("ERRO: Exclusão mal-sucedida.");
		}
	}

	
	public No getNoById(int id) {
		No no = null;
		try {
			connection = Conexao.getConnection();

			PreparedStatement preparedStatement = null;
			preparedStatement = (PreparedStatement) connection
					.prepareStatement("SELECT nome, cargo FROM no WHERE id = ?");

			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			
			no = new No(resultSet.getInt("id"), resultSet.getString("nome"),
					resultSet.getString("cargo"),
					resultSet.getTimestamp("data_criacao"),
					resultSet.getInt("id_no_pai"));

			resultSet.close();
			preparedStatement.close();
			connection.close();

		} catch (SQLException e) {
			System.out.println("ERRO: Informação não encontrada.");
		}

		return no;

	}

}