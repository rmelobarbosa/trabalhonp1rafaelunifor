package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import organograma.No;

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
					.prepareStatement("INSERT INTO no (nome, descricao, no_id_pai) VALUES (?, ?, ?) ");

			preparedStatement.setString(1, no.getNome());
			preparedStatement.setString(2, no.getDescricao());
			preparedStatement.setInt(3, no.getNoIdPai());

			preparedStatement.execute();
			preparedStatement.close();
			connection.close();

		} catch (SQLException e) {
			System.out.println("ERRO: NO Grava��o mal-sucedida.");
			
			e.printStackTrace();
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
					.prepareStatement("UPDATE no SET nome = ?, descricao = ?, id_no_pai = ? WHERE id = ? ");

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
					.prepareStatement("SELECT nome, descricao FROM no WHERE id = ?");

			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();

			no = new No(resultSet.getString("nome"),
					resultSet.getString("descricao"), resultSet.getInt("id_no_pai"));

			resultSet.close();
			preparedStatement.close();
			connection.close();

		} catch (SQLException e) {
			System.out.println("ERRO: Informa��o n�o encontrada.");
		}

		return no;

	}

	public List<No> getNos() {
		List<No> nos = new ArrayList<No>();
		No no = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = Conexao.getConnection();

			preparedStatement = (PreparedStatement) connection
					.prepareStatement("SELECT * FROM no");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				no = new No(resultSet.getInt("idno"),resultSet.getString("nome"),
						resultSet.getString("descricao"),
						resultSet.getInt("no_id_pai"));
				nos.add(no);
			}
			
			for (No n : nos) {
				n.setFilhos(obterFilhos(n.getIdNo(), nos));
			}
			
			

		} catch (SQLException e) {
			System.out.println("ERRO: Informa��o n�o encontrada.");
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return nos;

	}
	
	private List<No> obterFilhos(int noPai, List<No> todos) {
		List<No> filhos = new ArrayList<No>();
		
		for (No n : todos) {
			if (n.getNoIdPai() == noPai) {
				filhos.add(n);
			}
		}
		
		return filhos;
	}
	
}