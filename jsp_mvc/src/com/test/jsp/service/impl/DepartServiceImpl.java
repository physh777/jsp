package com.test.jsp.service.impl;

import java.util.List;

import com.test.jsp.dao.DepartDAO;
import com.test.jsp.dao.impl.DepartDAOImpl;
import com.test.jsp.service.DepartService;
import com.test.jsp.vo.Depart;

public class DepartServiceImpl implements DepartService {
	private DepartDAO ddao = new DepartDAOImpl();
	@Override
	public List<Depart> getDepartList(Depart b) {
		return ddao.selectDepartList(b);
	}

	@Override
	public boolean insertDepart(Depart b) {
		return false;
	}

	@Override
	public boolean deleteDepart(Depart b) {
		return false;
	}

	@Override
	public Depart getDepart(Depart b) {
		return null;
	}

	@Override
	public boolean updateDepart(Depart b) {
		return false;
	}

}
