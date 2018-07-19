package com.test.jsp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.test.jsp.dao.UserDAO;
import com.test.jsp.dao.impl.UserDAOImpl;
import com.test.jsp.service.UserService;
import com.test.jsp.vo.UserInfo;

public class UserServiceImpl implements UserService {
	UserDAO udao = new UserDAOImpl();
	private Gson gs = new Gson();
	@Override
	public Map<String,String> login(HttpServletRequest req) {
		String json = req.getParameter("param");
		UserInfo ui = gs.fromJson(json, UserInfo.class);
		ui = udao.login(ui);
		Map<String,String> resultMap = new HashMap<String,String>();
		resultMap.put("msg", "아이디와 비밀번호를 확인해주세요");
		if(ui.getId()!=null) {
			HttpSession hs = req.getSession();
			hs.setAttribute("user", ui);
			resultMap.put("msg", "로그인에 성공하셨습니다!!");
		}
		return resultMap;
	}

	@Override
	public List<UserInfo> getUserList(UserInfo ui) {
		return udao.selectUserList(ui);
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub

	}

	@Override
	public void join() {
		// TODO Auto-generated method stub

	}

	@Override
	public void out() {
		// TODO Auto-generated method stub

	}

}
