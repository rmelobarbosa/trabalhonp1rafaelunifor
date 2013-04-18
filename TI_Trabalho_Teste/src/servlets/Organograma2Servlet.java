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

import organograma.Info;
import organograma.No;

import DAO.InfoDAO;
import DAO.NoDAO;

/**
 * Servlet implementation class Organograma2Servlet
 */
@WebServlet("/Organograma2Servlet")
public class Organograma2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int idno = Integer.parseInt(request.getParameter("idNo"));
		String nomeNo = request.getParameter("nomeNo");

		NoDAO noDao = new NoDAO();
		List<No> noList = (List<No>) noDao.getNos();

		InfoDAO infoDao = new InfoDAO();
		List<Info> infoList = infoDao.geInfos();

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

		out.println("<div id='dialog' title='Detalhes do nó' >");
		for (Info info : infoList) {
			if (info.getIdno_fk() == idno) {
				out.println("<table id='table-editar-no' class='table' align='center'>");
				out.println("<tr>");
				out.println("<td>Nó:</td>");
				out.println("<td>" + nomeNo + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>Representante:</td>");
				out.println("<td>" + info.getRepresentante() + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>Email:</td>");
				out.println("<td>" + info.getEmailRepresentante() + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>Ramal:</td>");
				out.println("<td>" + info.getRamal() + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>Sala:</td>");
				out.println("<td>" + info.getSala() + "</td>");
				out.println("</tr>");
				out.println("</table>");
			}
		}

		out.println("</div>");
		out.println("</div>");

		rd = request.getRequestDispatcher("organograma-footer.html");
		rd.include(request, response);

	}

	private void montarArvore(No no, PrintWriter out) {

		out.println(" <li><a href='Organograma2Servlet?idNo=" + no.getIdNo()
				+ "&nomeNo=" + no.getNome() + "' >"
				+ no.getNome() + "</a>");

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
