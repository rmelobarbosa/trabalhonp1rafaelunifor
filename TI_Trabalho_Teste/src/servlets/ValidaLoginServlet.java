package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import organograma.Usuario;

import DAO.UsuarioDAO;

@WebServlet("/ValidaLoginServlet")
public class ValidaLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Método o qual verifica se o usuário e senha informados pelo usuário
	 * existe.
	 * 
	 * @return se existir, uma ssession validada e o encaminha para página de
	 *         edição dos nós.
	 * @return caso não existe, a session mé invalidada e o usuário é
	 *         encaminhado para uma página de erro.
	 * @throws Dispara
	 *             erro de entrada e saída bem como erro no tratamento do
	 *             request ou response do Servlet.
	 * 
	 * */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Usuario usuario = null;
		String login = request.getParameter("login").toLowerCase();
		String senha = request.getParameter("senha").toLowerCase();

		try {
			UsuarioDAO dao = new UsuarioDAO();
			usuario = dao.getUsuario(login, senha);
		} catch (Exception e) {

		}

		if (usuario == null) {
			session.invalidate();
			request.getRequestDispatcher("erro.html")
					.forward(request, response);

		} else {
			session.setAttribute("usuario", usuario);
			request.setAttribute("nome", usuario.getNome());

			request.getRequestDispatcher("AdminServlet").forward(request,
					response);

		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
