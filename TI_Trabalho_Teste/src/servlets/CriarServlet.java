package servlets;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class CriarServlet
 */
@WebServlet("/CriarServlet")
public class CriarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CriarServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		NoDAO no = new NoDAO();
		no.saveData(new No(request.getParameter("nomeNo"), "", Integer
				.parseInt(request.getParameter("no-pai"))));
		InfoDAO info = new InfoDAO();
		info.saveData(new Info(Integer.parseInt(request.getParameter("ramal")),
				Integer.parseInt(request.getParameter("sala")), request
						.getParameter("representante"), request
						.getParameter("email"), Integer.parseInt(request
						.getParameter("no-pai"))));
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("Ola");
		out.println("</body></html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
