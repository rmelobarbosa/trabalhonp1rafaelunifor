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
 * Servlet implementation class AdminServlet
 */
@WebServlet("/Admin2Servlet")
public class Admin2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InfoDAO infoDao;
	private NoDAO noDao;
	private List<No> noList;
	private List<Info> infoList;
	private PrintWriter out;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String nomeUsuario = (String) request.getAttribute("nome");
		String nomeNo = request.getParameter("nome");
		String idNo = request.getParameter("id");

		infoDao = new InfoDAO();
		infoList = infoDao.getInfoByIdFk(idNo);

		noDao = new NoDAO();
		noList = noDao.getNos();

		out = response.getWriter();

		/*
		 * Importa do o layout do admin-head.html
		 */
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

		/* Constroi a �rvore de n�s na div "Navegador de Hierarquia". */
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
		out.println("<p>Editor de N�</p> </div>");
		out.println("<div class='content'>");

		out.println("<form action='BotoesServlet'><table id='table-editar-no' align='center'>");

		out.println("<tr> <td><label><p>N�-pai:</p></label></td>");
		out.println("<td><select name='no-pai' >");
		/**
		 *  Controi o menu da setor N�-pai na div "Editor de N�" */
		for (No no : noList) {
			out.println("<option value='"+no.getNoIdPai()+"'>" + no.getNome() + "</option>");
		}
		out.println("</select></td>");

		/**
		 * Pega por par�metro ID_FK (na tabela infos do banco de dados) do n� e
		 * o nome do n� por par�metro inicialmente passado pelo Servlet
		 * "AdminServlet", ap�s este servlet ser carregado pela primeira vez,
		 * ele ficar� se chamando a medida que o usu�rio clica nos links na div
		 * "Navegador de Hierarquias".
		 */
		for (Info i : infoList) {
			out.println("<tr> <td><label><p>Nome do n�:</p></label></td>");
			out.println("<td><input type='text' name='no' value='" + nomeNo
					+ "'/></td>");

			out.println("<tr><td><label><p>Representante:</p></label></td>");
			out.println("<td><input type='text' name='representante' value='"
					+ i.getRepresentante() + "' /></td>");
			out.println("<td><input type='checkbox' name='exibir-representante'/>exibir</td></tr>");

			out.println("<tr><td><label><p>E-mail:</p></label></td>");
			out.println("<td><input type='text' name='email' value='"
					+ i.getEmailRepresentante() + "' /></td>");
			out.println("<td><input type='checkbox' name='exibir-email' />exibir</td></tr>");

			out.println("<tr><td><p>Ramal:</p> </label></td>");
			out.println("<td><input type='text' size='4' name='ramal' value='"
					+ i.getRamal() + "' /></td>");
			out.println("<td><input type='checkbox' name='exibir-ramal' />exibir</td></tr>");

			out.println("<tr><td><p>Sala:</p> </label></td>");
			out.println("<td><input type='text' size='4' name='sala' value='"
					+ i.getSala() + "' /></td>");
			out.println("<td><input type='checkbox' name='exibir-sala' />exibir</td></tr>");
		}
		out.println("</table>");

		rd = request.getRequestDispatcher("admin-footer.html");
		rd.include(request, response);

	}

	/**
	 * M�todo o qual � respons�vel pela montagem efetiva da �rvore por meio
	 * recursivo.
	 * **/
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
