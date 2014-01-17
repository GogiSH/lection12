package com.tsystems.lection12.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="LoginServlet", urlPatterns={"/LoginServlet"})
public class AdminServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.getSession().setAttribute("name", request.getParameter("name"));
		request.getSession().setAttribute("password", request.getParameter("password"));
//		request.setAttribute("name", request.getParameter("name"));
//		request.setAttribute("password", request.getParameter("password"));
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("");
//		requestDispatcher.forward(request, response);
		response.sendRedirect("/lection12/user");
	}

}
