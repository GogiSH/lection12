package com.tsystems.lection12.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsystems.lection12.entities.User;
import com.tsystems.lection12.service.UserService;

@WebServlet(name="UserServlet", urlPatterns={"/user"})
public class UserServlet extends HttpServlet {
	
	@Inject
	UserService userService;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		List<User> users = (ArrayList<User>) userService.findAllUsers();
		
		out.println("<html> " +
						"<body> " +
							"<h1> User Page </h1> " +
							"<br> " +
							"<a href=\"/lection12/user.jsp\">Edit User table</a> " +
							"<br> " +
							"<table> ");
		out.println(			"<tr> " +
									"<th>First Name</th> " +
									"<th>Last Name</th> " +
									"<th>Email</th> " +
									"<th>password</th> " +
									"<th>Birthday date</th> " +
								"</tr>");
		for (User user : users) {
			out.println( 		"<tr> " +
									"<td> " + user.getFirstName() + " </td> " +
									"<td> " + user.getLastName() + " </td> " +
									"<td> " + user.getEmail() + " </td> " +
									"<td> " + user.getPassword() + " </td> " +
									"<td> " + user.getBirthday() + " </td> " +
								"</tr>");
		}
		
		out.println(
							"</table> " +
						"</body> " +
					"</html>");
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		if (request.getParameter("action") != null) {
			ActionType actionType = ActionType.valueOf(request.getParameter("action").toUpperCase());
			
			String userEmail = request.getParameter("email");
			
			User user;
			
			if (userEmail != null && !"".equals(userEmail)) {
				switch (actionType) {
					case ADD:
						String firstName = request.getParameter("firstName");
						String lastName = request.getParameter("lastName");
						String pass = request.getParameter("pass");
						user = new User(firstName, lastName, userEmail, pass, new Date());
						userService.createUser(user);
						break;
					case DELETE:
						userService.deleteUserByEmail(userEmail);
						break;
					default: break;
				}
			} 
		}
		
//		request.getRequestDispatcher("../user").forward(request, response);
		response.sendRedirect("/lection12/user");
	}

}
