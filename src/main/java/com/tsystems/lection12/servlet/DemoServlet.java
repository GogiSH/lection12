package com.tsystems.lection12.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoServlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		System.out.println("Servlet was initialyzed");
	}
	

//	@Override
//	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		System.out.println("Service method was started");
//	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		
//		response.setHeader("Refresh", "5");
		response.setContentType("text/html");
//		response.setContentType("image/jpeg");
		PrintWriter out = response.getWriter();
		
		String studentName = "";
		Date currentDate = new Date(); 
		
		if (request.getParameter("studentName") != null) {
			studentName = request.getParameter("studentName");
		} else if (request.getAttribute("studentName") != null) {
			studentName = (String) request.getAttribute("studentName");
		}
		
		
		out.println("<html> " +
						"<head><title>Demo Servlet</title></head> " +
						"<body> " +
							"<h1>Hello T-Uni Students!</h1> " +
							"<br> " +
							"Today date is " + currentDate +
							"<br> " +
							"Student " + studentName + " is absent! " +
						"<body> " +
					"</html>");
		
	}
}
