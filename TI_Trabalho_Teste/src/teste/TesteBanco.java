package teste;
import java.sql.Connection;

import organograma.No;

import DAO.NoDAO;

public class TesteBanco {
	Connection connection;

	/*
	 * Método o qual realizará a gravação de um novo nó no banco de dados.
	 */

	public static void main(String[] args) {
		No no = new No("Valmar", "Presidente", 1);
		NoDAO dao = new NoDAO();

		dao.saveData(no);

	}
}
