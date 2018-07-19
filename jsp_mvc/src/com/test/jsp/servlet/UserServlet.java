package com.test.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.test.jsp.service.UserService;
import com.test.jsp.service.impl.UserServiceImpl;
import com.test.jsp.vo.UserInfo;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService us = new UserServiceImpl();
	private Gson gs = new Gson();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		String cmd = req.getParameter("cmd");
		String uri = req.getRequestURI();
		System.out.println("cmd : " + cmd);
		System.out.println("uri : " + uri);
		PrintWriter pw = res.getWriter();
		UserInfo ui = null;
		String param = req.getParameter("param");
		
		if(param!=null) {
			ui = gs.fromJson(param, UserInfo.class);
		}
		if(cmd.equals("list")) {
			List<UserInfo> userList = us.getUserList(ui);
			String json = gs.toJson(userList);
			pw.write(json);
		}else if(cmd.equals("join")) {
			us.join();
		}else if(cmd.equals("login")) {
			Map<String,String> resultMap = us.login(req);
			String json = gs.toJson(resultMap);
			pw.write(json);
		}else if(cmd.equals("logout")) {
			us.logout();
		}else if(cmd.equals("out")) {
			us.out();
		}else if(cmd.equals("color")) {
			Map<String,String> map = new HashMap<String,String>();
			map.put("color", "red");
			String json = gs.toJson(map);
			pw.write(json);
		}
//		RequestDispatcher rd = req.getRequestDispatcher("/views"+uri);
//		rd.forward(req, res);
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		doGet(req, res);
	}
}
