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
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String nomeUsuario = (String) request.getAttribute("nome");

		NoDAO noDao = new NoDAO();
		List<No> noList = (List<No>) noDao.getNos();

		PrintWriter out = response.getWriter();

		RequestDispatcher rd = request.getRequestDispatcher("admin-head.html");
		rd.include(request, response);

		out.println("<div id='formulario-logout'>");
		out.println("<form action='LogoutServlet' method='post'> Bem-vindo(a) "
				+ nomeUsuario
				+ "! <input type='submit' class='btn-input' name='logout' value='Logout' />");
		out.println("</form>");
		out.println("</div></div>");
		out.println("<!-- ############# MAIN ############# -->");
		out.println("<div id='main'>");
		out.println("<div class='workspace'>");
		out.println("<div class='workspace-left'>");
		out.println("<div id='treeView' class='span1'>");
		out.println("<div class='head'>");
		out.println("<p>Navegador de hierarquia</p>");
		out.println("</div>");
		out.println("<div class='content scroll'>");

		No raiz = null;
		for (No no : noList) {
			if (no.getNoIdPai() == 0)
				raiz = no;
		}

		out.println("<ul id='black-tree' class='treeview'>Escola Saber Crescer");
		montarArvore(raiz, out);
		out.println(" </ul>");
		out.println("</div>");
		out.println("</div>");
		out.println("</div>");

		out.println("<div class='workspace-right'>");
		out.println("<div id='edicao-no' class='span2'>");
		out.println("<div class='head'>");
		out.println("<p>Editor de Nó</p> </div>");
		out.println("<div class='content'>");

		out.println("<form action='BotoesServlet'><table id='table-editar-no' align='center'>");

		out.println("<tr> <td><label><p>Nó-pai:</p></label></td>");

		out.println("<td><select name='no-pai' >");
		for (No no : noList) {
			out.println("<option value=''>" + no.getNome() + "</option>");
		}
		out.println("</select></td>");

		out.println("<tr> <td><label><p>Nome do nó:</p></label></td>");
		out.println("<td><input type='text' name='no' value=''/></td>");

		out.println("<tr><td><label><p>Representante:</p></label></td>");
		out.println("<td><input type='text' name='representante' /></td>");
		out.println("<td><input type='checkbox' name='exibir-representante'/>exibir</td></tr>");

		out.println("<tr><td><label><p>E-mail:</p></label></td>");
		out.println("<td><input type='text' name='email' /></td>");
		out.println("<td><input type='checkbox' name='exibir-email' />exibir</td></tr>");

		out.println("<tr><td><p>Ramal:</p> </label></td>");
		out.println("<td><input type='text' size='4' name='ramal' /></td>");
		out.println("<td><input type='checkbox' name='exibir-ramal' value= '' />exibir</td></tr>");

		out.println("<tr><td><p>Sala:</p> </label></td>");
		out.println("<td><input type='text' size='4' name='sala' /></td>");
		out.println("<td><input type='checkbox' name='exibir-sala' />exibir</td></tr>");

		out.println("</table>");

		rd = request.getRequestDispatcher("admin-footer.html");
		rd.include(request, response);

	}

	private void montarArvore(No no, PrintWriter out) {

		out.println("<li class='expandable'> <div class='hitarea expandable-hitarea'></div> <a href='Admin2Servlet?id="
				+ no.getIdNo()
				+ "&nome="
				+ no.getNome()
				+ "'>"
				+ no.getNome()
				+ "</a>");

		if (no.getFilhos().size() > 0) {
			out.println(" <ul style='display: none;'>");

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
