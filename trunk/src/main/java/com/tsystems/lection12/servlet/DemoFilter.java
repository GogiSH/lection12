package com.tsystems.lection12.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DemoFilter implements Filter {

	private FilterConfig config = null;
	private boolean active = Boolean.FALSE;
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		
		String activeParam = config.getInitParameter("active");
		if (activeParam != null) {
			active = (activeParam.toUpperCase().equals("TRUE"));
		}
		
	}


	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if (active) {
			request.setAttribute("studentName", "Default Student");
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		config = null;
	}
}
