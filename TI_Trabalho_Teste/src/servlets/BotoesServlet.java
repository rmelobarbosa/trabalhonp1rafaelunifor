package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.InfoDAO;
import DAO.NoDAO;

/**
 * Servlet implementation class BotoesServlet
 */
@WebServlet("/BotoesServlet")
public class BotoesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String criar = request.getParameter("criar");
		String alterar = request.getParameter("alterar");
		String excluir = request.getParameter("excluir");
		
		NoDAO no = new NoDAO();
		InfoDAO info = new InfoDAO();
	}

	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
