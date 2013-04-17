package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.PreparedStatement;

import organograma.Usuario;

import conexao.Conexao;

public class UsuarioDAO {

	private Connection connection;

	public Usuario getUsuario(String login, String senha) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "SELECT login, nome, senha FROM usuario WHERE login = ? and senha = ?";
		try {
			connection = Conexao.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, senha);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				Usuario usuario = new Usuario();
				usuario.setLogin(resultSet.getString("login"));
				usuario.setNome(resultSet.getString("nome"));
				usuario.setSenha(resultSet.getString("senha"));
				return usuario;
			}

			resultSet.close();
			preparedStatement.close();
			connection.close();

		} catch (SQLException e) {

		}
		return null;

	}
}
