package com.tsystems.lection12.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		if (request.getParameter("action") != null) {
			String action = request.getParameter("action").toUpperCase();
			String[] actionTypes = action.split("/");
			String actionType = actionTypes[0];

			if (actionType.startsWith("DELETE")) {

				Integer subjectId = Integer.valueOf(actionTypes[1]);

				subjectService.deleteSubjectbyId(subjectId);

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

				Integer subjectId = Integer.valueOf(actionTypes[1]);
				String name = request.getParameter("name/" + subjectId);
				String desc = request.getParameter("description/" + subjectId);

				Subject subject = subjectService.getSubjectById(subjectId);
				subjectService.changeSubjectName(subject, name);
				subjectService.changeSubjectDesc(subject, desc);

				List<Subject> subjects = subjectService.findAllSubjects();
				if (subjects != null) {
					request.setAttribute("subjects", subjects);
					ServletContext context = getServletContext();
					RequestDispatcher rd = context
							.getRequestDispatcher("/subjectGudkov.jsp");
					rd.forward(request, response);

				}
			}

			if (actionType.startsWith("ADD")) {

				String name = request.getParameter("name");
				String desc = request.getParameter("description");
				Subject subject = new Subject();
				subject.setName(name);
				subject.setDescription(desc);
				try {
					subjectService.createSubject(subject);
				}
				catch(Exception Ex){
					
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
