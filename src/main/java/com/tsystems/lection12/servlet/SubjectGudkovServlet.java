package com.tsystems.lection12.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
import com.tsystems.lection12.entities.User;
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

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		if (request.getParameter("action") != null) {
			String action = request.getParameter("action").toUpperCase();
			String[] actionTypes = action.split("/");

			int subjectIdFake = Integer.parseInt(actionTypes[2]);
			String actionType = actionTypes[1];
			String name = request.getParameter("name" + subjectIdFake);
			String desc = request.getParameter("description" + subjectIdFake);

			if (actionType.startsWith("DELETE")) {
				System.out.println("delete reached "+name+desc );

				subjectService.deleteSubjectbyName(name);
				
				List<Subject> subjects = subjectService.findAllSubjects();
				if (subjects != null) {
					request.setAttribute("subjects", subjects);
					ServletContext context = getServletContext();
					RequestDispatcher rd = context
							.getRequestDispatcher("/subjectGudkov.jsp");
					rd.forward(request, response);

				}
			}

			if (actionType.startsWith("EDIT")) {

				List<Subject> list = subjectService.getSubjectByName(name);
				System.out.println("edit reached "+name+desc );
				for (Subject subject:list){
					System.out.println(subject);
					subjectService.changeSubjectDesc(subject, desc);
				}
				
				List<Subject> subjects = subjectService.findAllSubjects();
				if (subjects != null) {
					request.setAttribute("subjects", subjects);
					ServletContext context = getServletContext();
					RequestDispatcher rd = context
							.getRequestDispatcher("/subjectGudkov.jsp");
					rd.forward(request, response);

				}
			}

		}

	}

}
