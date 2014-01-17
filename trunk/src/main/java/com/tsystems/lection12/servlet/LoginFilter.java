package com.tsystems.lection12.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@ServletFilter
public class LoginFilter implements Filter {
	
	protected ServletContext servletContext;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		servletContext = filterConfig.getServletContext();	
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse responce,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) responce;
		
//		String name = (String) req.getAttribute("studentName");
//		String pass = (String) req.getAttribute("studentName");
		
		String name = req.getParameter("name");
		String pass = req.getParameter("password");
		
//		String name = (String) req.getSession().getAttribute("name");
//		String pass = (String) req.getSession().getAttribute("password");
		
		if ("admin".equals(name) && "admin".equals(pass)) {
			chain.doFilter(request, responce);
		} else {
			resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);	
		}
	}
	

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
