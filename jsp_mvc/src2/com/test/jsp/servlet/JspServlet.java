package com.test.jsp.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class JspServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		doProc(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		doProc(request,response);
	}
	
	public void doProc(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException {
		String url = request.getRequestURI();
		System.out.println(url);
		url = "/WEB-INF" + url + ".jsp";
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
