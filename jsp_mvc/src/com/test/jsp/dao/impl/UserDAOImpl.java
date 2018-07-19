package com.test.jsp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.jsp.common.DBCon;
import com.test.jsp.dao.UserDAO;
import com.test.jsp.vo.UserInfo;

public class UserDAOImpl implements UserDAO {
	private Connection con;
	@Override
	public UserInfo login(UserInfo ui) {
		con = DBCon.getCon();
		try {
			PreparedStatement ps = con.prepareStatement("select * from user_info where id=? and pwd=?");
			ps.setString(1, ui.getId());
			ps.setString(2, ui.getPwd());
			ResultSet rs = ps.executeQuery();
			ui = new UserInfo();
			while(rs.next()) {
				ui.setAddress(rs.getString("address"));
				ui.setHobby(rs.getString("hobby"));
				ui.setId(rs.getString("id"));
				ui.setName(rs.getString("name"));
				ui.setNum(rs.getInt("num"));
				ui.setPwd(rs.getString("pwd"));
				ui.setTrans(rs.getString("trans"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBCon.close();
		}
		return ui;
	}

	@Override
	public List<UserInfo> selectUserList(UserInfo u) {
		List<UserInfo> userList = new ArrayList<UserInfo>();
		con = DBCon.getCon();
		try {
			String sql = "select * from user_info";
			if(u!=null) {
				if(u.getDpNum()!=0) {
					sql += " where dpNum=?";
				}
			}
			PreparedStatement ps = con.prepareStatement(sql);
			if(u!=null) {
				if(u.getDpNum()!=0) {
					ps.setInt(1, u.getDpNum());
				}
			}
			ResultSet rs = ps.executeQuery();
			UserInfo ui;
			while(rs.next()) {
				ui = new UserInfo();
				ui.setAddress(rs.getString("address"));
				ui.setHobby(rs.getString("hobby"));
				ui.setId(rs.getString("id"));
				ui.setName(rs.getString("name"));
				ui.setNum(rs.getInt("num"));
				ui.setPwd(rs.getString("pwd"));
				ui.setTrans(rs.getString("trans"));
				ui.setDpNum(rs.getInt("dpNum"));
				userList.add(ui);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBCon.close();
		}
		return userList;
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
