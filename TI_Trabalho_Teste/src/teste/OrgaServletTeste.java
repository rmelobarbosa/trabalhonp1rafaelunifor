package teste;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import organograma.No;

import DAO.NoDAO;

import com.mysql.jdbc.Connection;

import conexao.Conexao;

/**
 * Servlet implementation class OrgaServletTeste
 */
@WebServlet("/OrgaServletTeste")
public class OrgaServletTeste extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<No> nos;
	private NoDAO noDAO;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		nos = new ArrayList<No>();
	
			//nos.add(noDAO.getNos());
			out.println("<html><body>");
			out.println("weee!");
			out.println("</body></html>");
		
		

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
