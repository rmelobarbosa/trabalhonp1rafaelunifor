package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OrganogramaServlet")
public class OrganogramaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();

		printWriter.println("<html>");

		printWriter.println("<head>");
		printWriter
				.println("<<meta http-equiv='Content-Type' content='text/html'; charset=ISO-8859-1");
		printWriter
				.println("<link rel='stylesheet' type = 'text/css' href='css/main.css'/>");
		printWriter.println("<title>Administrador Organograma</title>");
		printWriter.println("</head>");

		printWriter.println("<body>");
		printWriter.println("");
		
		printWriter.println("</body>");

		printWriter.println("</html>");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
