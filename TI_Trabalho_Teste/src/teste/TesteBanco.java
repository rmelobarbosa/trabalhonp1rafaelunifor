package teste;
import java.sql.Connection;

import organograma.No;

import DAO.NoDAO;

public class TesteBanco {
	Connection connection;

	/*
	 * M�todo o qual realizar� a grava��o de um novo n� no banco de dados.
	 */

	public static void main(String[] args) {
		No no = new No("Valmar", "Presidente", 1);
		NoDAO dao = new NoDAO();

		dao.saveData(no);

	}
}
