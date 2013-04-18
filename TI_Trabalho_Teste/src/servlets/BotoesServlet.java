package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import organograma.Info;
import organograma.No;

import DAO.InfoDAO;
import DAO.NoDAO;

/**
 * Servlet implementation class BotoesServlet
 */
@WebServlet("/BotoesServlet")
public class BotoesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BotoesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		boolean criarPressed = request.getParameter("criar") != null;
		boolean alterarPressed = request.getParameter("alterar") != null;
		boolean excluirPressed = request.getParameter("excluir") != null;

		// String resp = request.getParameter("acao");
		NoDAO noDao = new NoDAO();
		InfoDAO infoDao = new InfoDAO();

		No noServlet = new No(request.getParameter("nomeNo"), "",
				Integer.parseInt(request.getParameter("no-pai")));

		Info infoServlet = new Info(request.getParameter("representante"),Integer.parseInt(request
				.getParameter("ramal")), request.getParameter("email"), Integer.parseInt(request
				.getParameter("sala")), Integer.parseInt(request.getParameter("id")));

		if (criarPressed) {
			noDao.saveData(noServlet);
			infoDao.saveData(infoServlet);

			request.getRequestDispatcher("AdminServlet").forward(request,
					response);

		}

		if (alterarPressed) {
			// noDao.updateData(noServlet);
			infoDao.updateData(infoServlet);

			request.getRequestDispatcher("AdminServlet").forward(request,
					response);

		}

		if (excluirPressed) {

			// noDao.deleteData(noServlet);
			infoDao.deleteData(infoServlet);

			request.getRequestDispatcher("AdminServlet").forward(request,
					response);

		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
