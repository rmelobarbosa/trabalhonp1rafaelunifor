package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import organograma.No;
import organograma.Usuario;

import com.mysql.jdbc.PreparedStatement;

import conexao.Conexao;

public class NoDAO {

	private Connection connection;

	/*
	 * M�todo o qual realizar� a grava��o de um novo n� no banco de dados.
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

			preparedStatement.execute();
			preparedStatement.close();
			connection.close();

		} catch (SQLException e) {
			System.out.println("ERRO: Grava��o mal-sucedida.");
		}
	}

	/*
	 * M�todo o qual atualizar� os dados de um N�.
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
			System.out.println("ERRO: Atualiza��o mal-sucedida.");
		}
	}

	/*
	 * M�todo o qual excluir� os dados de um N�.
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
			System.out.println("ERRO: Exclus�o mal-sucedida.");
		}
	}

	/*
	 * M�todo o qual excluir� os dados de um N� utlizando os paramentros da URL.
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
			System.out.println("ERRO: Exclus�o mal-sucedida.");
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

			no = new No(resultSet.getString("nome"),
					resultSet.getString("cargo"), resultSet.getInt("id_no_pai"));

			resultSet.close();
			preparedStatement.close();
			connection.close();

		} catch (SQLException e) {
			System.out.println("ERRO: Informa��o n�o encontrada.");
		}

		return no;

	}

	public No getNos() {
		No no = null;
		try {
			connection = Conexao.getConnection();

			PreparedStatement preparedStatement = null;
			preparedStatement = (PreparedStatement) connection
					.prepareStatement("SELECT * FROM no");

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				no = new No(resultSet.getString("nome"),
						resultSet.getString("cargo"),
						resultSet.getInt("id_no_pai"));
				return no;
			}
			
			resultSet.close();
			preparedStatement.close();
			connection.close();

		} catch (SQLException e) {
			System.out.println("ERRO: Informa��o n�o encontrada.");
		}

		return null;

	}

}