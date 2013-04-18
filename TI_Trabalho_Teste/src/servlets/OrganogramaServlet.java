package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import organograma.No;

import DAO.NoDAO;

/**
 * Servlet implementation class organogramaServlet
 */
@WebServlet("/OrganogramaServlet")
public class OrganogramaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		NoDAO noDao = new NoDAO();
		List<No> noList = (List<No>) noDao.getNos();

		PrintWriter out = response.getWriter();

		RequestDispatcher rd = request
				.getRequestDispatcher("organograma-head.html");
		rd.include(request, response);

		out.println("<!-- ############# MAIN #############-->");
		out.println("<div id='main'>");
		out.println(" <div class='tree'>");

		No raiz = null;
		for (No no : noList) {
			if (no.getNoIdPai() == 0)
				raiz = no;
		}

		out.println(" <ul>");
		montarArvore(raiz, out);
		out.println(" </ul>");

		out.println("</div>");
			
		out.println("</div>");

		rd = request.getRequestDispatcher("organograma-footer.html");
		rd.include(request, response);

	}

	private void montarArvore(No no, PrintWriter out) {

//		out.println(" <li><a href='#'  id ='opener' >" + no.getNome() + "</a>");
		
//		out.println(" <li><a href='abrirJanela()?id="
//				+ no.getIdNo()
//				+ "&nomeNo="
//				+ no.getNome()
//				+ "'>"
//				+ no.getNome()
//				+ "</a>");
		
		out.println(" <li><a href='Organograma2Servlet?idNo="
				+ no.getIdNo()
				+ "&nomeNo="
				+ no.getNome()
				+ " '>"
				+ no.getNome()
				+ "</a>");

		if (no.getFilhos().size() > 0) {
			out.println(" <ul>");

			for (No filho : no.getFilhos())
				montarArvore(filho, out);

			out.println(" </ul>");
		}

		out.println(" </li> ");

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
