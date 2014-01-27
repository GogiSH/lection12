package com.tsystems.lection12.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsystems.lection12.entities.Subject;
import com.tsystems.lection12.service.SubjectGudkovService;

@WebServlet(urlPatterns = { "/subjectGudkov" })
public class SubjectGudkovServlet extends HttpServlet {

	@Inject
	SubjectGudkovService subjectService;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		List<Subject> subjects = subjectService.findAllSubjects();
		if (subjects != null) {
			request.setAttribute("subjects", subjects);
			ServletContext context = getServletContext();
			RequestDispatcher rd = context
					.getRequestDispatcher("/subjectGudkov.jsp");
			rd.forward(request, response);

			/*
			 * out.println("<html> " + "<body> " + "<table> "); out.println(
			 * "<tr> " + "<th>Subject description</th> " +
			 * "<th>Subject Name</th> " +
			 * 
			 * "</tr>"); for(Subject subject : subjects){ out.println( "<tr> " +
			 * "<td> " + subject.getDescription() + " </td> " + "<td> " +
			 * subject.getName() + " </td> " + "</tr>"); }
			 * 
			 * out.println( "</table> " + "</body> " + "</html>");
			 */
		}
	}

}
