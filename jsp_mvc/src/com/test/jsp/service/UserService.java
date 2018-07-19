package com.test.jsp.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.test.jsp.vo.UserInfo;

public interface UserService {
	public Map<String,String> login(HttpServletRequest req);
	public List<UserInfo> getUserList(UserInfo ui);
	public void logout();
	public void join();
	public void out();
}
