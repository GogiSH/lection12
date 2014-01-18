package com.tsystems.lection12.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsystems.lection12.entities.Teacher;
import com.tsystems.lection12.entities.User;
import com.tsystems.lection12.service.TeacherSavchenkoService;
import com.tsystems.lection12.service.UserService;


@WebServlet(name="TeacherSavchenkoServlet", urlPatterns={"/teacherSavchenko"})
public class TeacherSavchenkoServlet extends HttpServlet {
	
	@Inject
	private UserService userService;
	@Inject
	private TeacherSavchenkoService teacherService;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		List<Teacher> teachers = (ArrayList<Teacher>) teacherService.findAllTeachers();
		if (teachers != null){
		
		out.println("<html> " +
						"<body> " +
							"<h1>Teachers Page </h1> " +
							"<br> " +
							"<a href=\"/lection12/teacherSavchenko.jsp\">Edit Teacher table</a> " +
							"<br> " +
							"<table border=1> ");
		out.println(			"<tr> " +
									"<th>first Name</th> " +
									"<th>last Name</th> " +
									"<th>e-mail</th> " +
									"<th>password</th> " +
									"<th>birthday date</th> " +
									"<th>experience</th> " +
								"</tr>");
		for (Teacher teache : teachers) {
			out.println( 		"<tr> " +
									"<td> " + teache.getUser().getFirstName() + " </td> " +
									"<td> " + teache.getUser().getLastName() + " </td> " +
									"<td> " + teache.getUser().getEmail() + " </td> " +
									"<td> " + teache.getUser().getPassword() + " </td> " +
									"<td> " + teache.getUser().getBirthday() + " </td> " +
									"<td> " + teache.getExperience() + " </td> " +
								"</tr>");
		}
		
		out.println(
							"</table> " +
							"<h4>by: Savchenko Alex </h4>"+
						"</body> " +
					"</html>");
		request.setAttribute("teachers", teachers);
		} else {
			out.println("Error. Connection with database not found.");
		}
		
	}
	
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		if (request.getParameter("action") != null) {
			ActionType actionType = ActionType.valueOf(request.getParameter("action").toUpperCase());
			
			String userMail = request.getParameter("email");
			
			User user;
			
			if (userMail != null && !"".equals(userMail)) {
				switch (actionType) {
					case ADD:
						String exp = request.getParameter("experience");
						user = userService.findUserByEmail(userMail);
						Teacher teacher = new Teacher(user);
						teacher.setExperience(Integer.parseInt(exp));
						teacherService.createTeacher(teacher);						
						break;
					case DELETE:
						user = userService.findUserByEmail(userMail);
						teacherService.deleteTeacherByUserId(user.getId());
						//userService.deleteUserById(user.getId());
						break;
					default: break;
				}
			} 
		}
		request.setAttribute("teachers", (ArrayList<Teacher>) teacherService.findAllTeachers());		
		response.sendRedirect("/lection12/teacherSavchenko.jsp");

	}
	


}
