package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import organograma.Info;

import com.mysql.jdbc.PreparedStatement;

import conexao.Conexao;

public class InfoDAO {
	private Connection connection;

	/*
	 * Método o qual realizará a gravação de uma nova info no banco de dados.
	 */
	public void saveData(Info info) {
		try {
			connection = Conexao.getConnection();

			PreparedStatement preparedStatement = null;
			preparedStatement = (PreparedStatement) connection
					.prepareStatement("INSERT INTO info (representante, ramal, email_representante, sala, idno_fk) VALUES (?, ?, ?, ?, ?) ");

			preparedStatement.setString(1, info.getRepresentante());
			preparedStatement.setInt(2, info.getRamal());
			preparedStatement.setString(3, info.getEmailRepresentante());
			preparedStatement.setInt(4, info.getSala());
			preparedStatement.setInt(5, info.getIdno_fk());

			preparedStatement.execute();
			preparedStatement.close();
			connection.close();

		} catch (SQLException e) {
			System.out.println("ERRO: INFO Gravação mal-sucedida.");
			e.printStackTrace();
		}
	}

	/*
	 * Método o qual atualizará os dados de uma info.
	 */
	public void updateData(Info info) {
		try {
			connection = Conexao.getConnection();

			PreparedStatement preparedStatement = null;
			preparedStatement = (PreparedStatement) connection
					.prepareStatement("UPDATE info SET representante = ?, ramal = ?, email_representante = ?, sala = ?, idno_fk = ?  WHERE id = ? ");

			preparedStatement.setString(1, info.getRepresentante());
			preparedStatement.setInt(2, info.getRamal());
			preparedStatement.setString(3, info.getEmailRepresentante());
			preparedStatement.setInt(4, info.getSala());
			preparedStatement.setInt(5, info.getIdno_fk());
			preparedStatement.setInt(6, info.getIdInfo());

			preparedStatement.close();
			connection.close();

		} catch (SQLException e) {
			System.out.println("ERRO: Atualização mal-sucedida.");
		}
	}

	/*
	 * Método o qual excluirá os dados de uma info.
	 */
	public void deleteData(Info info) {
		try {
			connection = Conexao.getConnection();

			PreparedStatement preparedStatement = null;
			preparedStatement = (PreparedStatement) connection
					.prepareStatement("DELETE FROM info WHERE id = ?");

			preparedStatement.setInt(1, info.getIdInfo());

			preparedStatement.close();
			connection.close();

		} catch (SQLException e) {
			System.out.println("ERRO: Exclusão mal-sucedida.");
		}
	}

	/*
	 * Método o qual excluirá os dados de uma info utlizando os paramentros da
	 * URL.
	 */
	public void deleteData(int idInfo) {
		try {
			connection = Conexao.getConnection();

			PreparedStatement preparedStatement = null;
			preparedStatement = (PreparedStatement) connection
					.prepareStatement("DELETE FROM info WHERE id = ?");

			preparedStatement.setInt(1, idInfo);

			preparedStatement.close();
			connection.close();

		} catch (SQLException e) {
			System.out.println("ERRO: Exclusão mal-sucedida.");
		}
	}

	public Info getInfoById(int idInfo) {
		Info info = null;
		try {
			connection = Conexao.getConnection();

			PreparedStatement preparedStatement = null;
			preparedStatement = (PreparedStatement) connection
					.prepareStatement("SELECT ramal, sala, representante, email_representante, idno_fk FROM info WHERE id = ?");

			preparedStatement.setInt(1, idInfo);

			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();

			info = new Info(resultSet.getInt("ramal"),
					resultSet.getInt("sala"),
					resultSet.getString("representante"),
					resultSet.getString("email_representante"),
					resultSet.getInt("idno_fk"));

			resultSet.close();
			preparedStatement.close();
			connection.close();

		} catch (SQLException e) {
			System.out.println("ERRO: Informação não encontrada.");
		}

		return info;

	}

	/**
	 * Método o qual busca informaçõs de um no por meio de uma chave
	 * estrangeira. idInfo = recebe, como parâmetro, a chave estrangeiro de um
	 * elemento no banco de dados.
	 **/
	public List<Info> getInfoByIdFk(String idInfo) {
		Info info = new Info();
		List<Info> infos = new ArrayList<Info>();
		try {
			connection = Conexao.getConnection();
			int idFK = Integer.parseInt(idInfo); //Convertendo a String em inteiro.

			PreparedStatement preparedStatement = null;
			preparedStatement = (PreparedStatement) connection
					.prepareStatement("SELECT representante, ramal, email_representante, sala FROM info WHERE idno_fk = ?");

			preparedStatement.setInt(1, idFK);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				info = new Info(resultSet.getInt("ramal"),
						resultSet.getInt("sala"),
						resultSet.getString("representante"),
						resultSet.getString("email_representante"));

				infos.add(info);
			}

			resultSet.close();
			preparedStatement.close();
			connection.close();

		} catch (SQLException e) {
			System.out.println("ERRO: Informação não encontrada.");
		}
		
		return infos;
	}

	public List<Info> geInfos() {
		List<Info> infos = new ArrayList<Info>();
		Info info = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = Conexao.getConnection();

			preparedStatement = (PreparedStatement) connection
					.prepareStatement("SELECT * FROM info");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				info = new Info(resultSet.getInt("ramal"),
						resultSet.getInt("sala"),
						resultSet.getString("representante"),
						resultSet.getString("email_representante"),
						resultSet.getInt("idno_fk"));
				infos.add(info);
			}

		} catch (SQLException e) {
			System.out.println("ERRO: Informação não encontrada.");
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return infos;

	}

}
