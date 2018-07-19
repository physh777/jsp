package com.test.jsp.dao;

import java.util.List;

import com.test.jsp.vo.Depart;

public interface DepartDAO {
	List<Depart> selectDepartList(Depart b);
	public boolean insertDepart(Depart b);
	boolean deleteDepart(Depart b);
	boolean updateDepart(Depart b);
}
