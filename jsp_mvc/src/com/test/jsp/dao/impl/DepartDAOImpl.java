package com.test.jsp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.test.jsp.common.DBCon;
import com.test.jsp.dao.DepartDAO;
import com.test.jsp.vo.Depart;

public class DepartDAOImpl implements DepartDAO {
	private Connection con;
	@Override
	public List<Depart> selectDepartList(Depart b) {
		List<Depart> dList = new ArrayList<Depart>();
		try {
			con = DBCon.getCon();
			String sql = "select * from depart";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Depart d = new Depart();
				d.setCnt(rs.getInt("cnt"));
				d.setDpDesc(rs.getString("dpDesc"));
				d.setDpName(rs.getString("dpName"));
				d.setDpNum(rs.getInt("dpNum"));
				d.setVisible(rs.getString("visible"));
				dList.add(d);
			}
		}catch(Exception e) {
		}finally {
			DBCon.close();
		}
		return dList;
	}

	@Override
	public boolean insertDepart(Depart b) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteDepart(Depart b) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateDepart(Depart b) {
		// TODO Auto-generated method stub
		return false;
	}

}
