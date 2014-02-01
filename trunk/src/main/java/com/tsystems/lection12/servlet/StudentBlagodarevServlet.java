package com.tsystems.lection12.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

import com.tsystems.lection12.entities.Student;
import com.tsystems.lection12.entities.User;
import com.tsystems.lection12.service.StudentBlagodarevService;
import com.tsystems.lection12.service.UserService;

@WebServlet(name = "studentBlagodarevServlet", urlPatterns = { "/studentBlagodarev" })
public class StudentBlagodarevServlet extends HttpServlet {

	@Inject
	private StudentBlagodarevService studentService;

	@Inject
	private UserService userService;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("test/html");

		List<Student> students = (ArrayList<Student>) studentService
				.findAllStudents();
		request.setAttribute("students", students);
		RequestDispatcher reDispatcher = request
				.getRequestDispatcher("/studentBlagodarev.jsp");
		reDispatcher.forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("action") != null) {
			ActionType actionType = ActionType.valueOf(request.getParameter(
					"action").toUpperCase());

			

			switch (actionType) {
			case ADD:
				User dummyUser = userService.findUserByEmail("JSP Blagodarev@gmail.com");
				if (dummyUser == null) {
					dummyUser = generateUser();
					userService.createUser(dummyUser);
				}
				Student student = new Student(dummyUser);

				student.setStudentNo(request.getParameter("studentNo"));
				
				studentService.createStudent(student);
				refresh(request, response);
				break;
			case DELETE:
				String studentNo = request.getParameter("studentNo");
				studentService.deleteStudentByStudentNo(studentNo);
				refresh(request, response);
				break;
			case SEARCH:
				refresh(request, response);
			default:
				break;
			}

		}
	}

	private void refresh(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		studentService.findAllStudents();
		List<Student> students = (ArrayList<Student>) studentService.findAllStudents();
		request.setAttribute("students", students);
		ServletContext context = getServletContext();
		RequestDispatcher reDispatcher = context
				.getRequestDispatcher("/studentBlagodarev.jsp");
		reDispatcher.forward(request, response);
	}

	private User generateUser() {
		User user = new User();
		user.setFirstName("JSP Sergey");
		user.setLastName("JSP Blagodarev");
		user.setEmail("JSP Blagodarev@gmail.com");
		user.setPassword("JSP 12345");
		user.setBirthday(new Date());
		return user;
	}

}
