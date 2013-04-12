package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class organogramaServlet
 */
@WebServlet("/organogramaServlet")
public class organogramaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("organograma").forward(request, response);

		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<div id='main'>");
		out.println("<div class='tree'>");
		out.println("<ul>"); //ul da tree
		out.println("<li><a href='#'>DIRETOR</a>");
		out.println("<ul>"); // abre filhos de dir
		out.println("<li><a href='#'>Administrativo</a>"); // pai diretor
		out.println("<ul>"); // abre filhos de ad
		out.println("<li><a href='#'>Compras</a>"); // pai administrativo
		out.println("</ul>"); //fecha filhos ad
 		out.println("<li><a href='#'>Comercial</a>"); //pai diretor
		out.println("<li><a href='#'>Operacional</a>"); //pai diretor
		out.println("<ul>"); //abre filhos ope
		out.println("<li><a href='#'>Central de Serviços</a>"); //pai Operacional
		out.println("<li><a href='#'>Desenvolvimento</a>"); // pai Operacional
		out.println("</ul>"); //fecha filhos ope
		out.println("</ul>"); // fecha filho dir
		
		out.println("</ul>"); // fecha tree 
		out.println("</body></html>");
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
