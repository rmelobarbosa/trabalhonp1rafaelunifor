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
