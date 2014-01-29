package com.tsystems.lection12.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsystems.lection12.entities.Student;
import com.tsystems.lection12.entities.User;
import com.tsystems.lection12.service.StudentKobylkinService;
import com.tsystems.lection12.service.UserService;

@WebServlet(name = "StudentKobylkinServlet", urlPatterns = { "/studentKobylkin" })
public class StudentKobylkinServlet extends HttpServlet {
	@Inject
	private UserService userService;
	@Inject
	private StudentKobylkinService studentService;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		List<Student> students = studentService.findAllStudents();
		if (students != null) {

			out.println("<html> "
					+ "<body> "
					+ "<br> "
					+ "<a href=\"/lection12/studentKobylkin.jsp\">Edit Student table</a> "
					+ "<br> " + "<table border=1> ");
			out.println("<tr> " + "<th>Student Number</th> "
					+ "<th>First Name</th> " + "<th>Last Name</th> "
					+ "<th>Email</th> " + "</tr>");
			for (Student student : students) {
				out.println("<tr> " + "<td> " + student.getStudentNo()
						+ " </td> " + "<td> "
						+ student.getUser().getFirstName() + " </td> "
						+ "<td> " + student.getUser().getLastName() + " </td> "
						+ "<td> " + student.getUser().getEmail() + " </td> "
						+ "</tr>");
			}

			out.println("</table> " + "</body> " + "</html>");
			request.setAttribute("students", students);
		} else {
			out.println("Error. Connection with database not found.");
		}

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("action") != null) {
			ActionType actionType = ActionType.valueOf(request.getParameter(
					"action").toUpperCase());

			String userMail = request.getParameter("email");

			User user;

			if (userMail != null && !"".equals(userMail)) {
				switch (actionType) {
				case ADD:
					String exp = request.getParameter("studentNumber");
					user = userService.findUserByEmail(userMail);
					Student student = new Student(user);
					student.setStudentNo(exp);
					studentService.createStudent(student);
					break;
				case DELETE:
					String exp1 = request.getParameter("studentNumber");
					user = userService.findUserByEmail(userMail);
					studentService.deleteStudent(studentService
							.findStudentByStudentNo(exp1));
					break;
				default:
					break;
				}
			}
		}
		request.setAttribute("students", studentService.findAllStudents());
		response.sendRedirect("/lection12/studentKobylkin.jsp");

	}

}
