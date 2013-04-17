package organograma;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String retorno = "";

		if (login.equalsIgnoreCase("teste") && senha.equalsIgnoreCase("teste")) {
			retorno = "administrador.jsp";
		} else {
			retorno = "error.jsp";

		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(retorno);
		dispatcher.forward(request, response);
	}
}
