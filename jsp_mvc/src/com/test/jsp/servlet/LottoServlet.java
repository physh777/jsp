package com.test.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.test.jsp.service.UserService;
import com.test.jsp.service.impl.UserServiceImpl;
import com.test.jsp.vo.Person;
import com.test.jsp.vo.UserInfo;

public class LottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gs = new Gson();
	private UserService us = new UserServiceImpl();
	
	private void makeLottoList(HttpSession hs) {
		List<Integer> lottoList = new ArrayList<Integer>();
		for(int i=1;i<=6;i++) {
			int num = (int)(Math.random()*45)+1;
			if(lottoList.indexOf(num)!=-1) {
				i--;
				continue;
			}
			lottoList.add(num);
		}
		hs.setAttribute("lottoList", lottoList);
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession();
		if(hs.getAttribute("lottoList")==null) {
			makeLottoList(hs);
		}
		String lottoNums = req.getParameter("lotto");
		Person p = gs.fromJson(lottoNums, Person.class);
		List<UserInfo> userList = us.getUserList(null);
		String json = gs.toJson(userList);
		res.setCharacterEncoding("utf-8");
		PrintWriter pw = res.getWriter();
		pw.print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
