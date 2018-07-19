package com.test.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.test.jsp.service.DepartService;
import com.test.jsp.service.impl.DepartServiceImpl;
import com.test.jsp.vo.Depart;

/**
 * Servlet implementation class DepartServlet
 */
public class DepartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gs = new Gson();
	private DepartService ds = new DepartServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = uri.replace("/depart/", "");
		String param = request.getParameter("param");
		Depart d = null;
		if(param!=null) {
			d = gs.fromJson(param, Depart.class);
		}
		PrintWriter pw = response.getWriter();
		if(cmd.equals("list")) {
			pw.print(gs.toJson(ds.getDepartList(d)));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
