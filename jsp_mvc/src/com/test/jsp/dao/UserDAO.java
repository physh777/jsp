package com.test.jsp.dao;

import java.util.List;

import com.test.jsp.vo.UserInfo;

public interface UserDAO {
	public UserInfo login(UserInfo ui);
	public List<UserInfo> selectUserList(UserInfo ui);
	public void logout();
	public void join();
	public void out();

}
