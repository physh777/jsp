package com.test.jsp.service;

import java.util.List;

import com.test.jsp.vo.Depart;

public interface DepartService {
	List<Depart> getDepartList(Depart b);
	boolean insertDepart(Depart b);
	boolean deleteDepart(Depart b);
	Depart getDepart(Depart b);
	boolean updateDepart(Depart b);
}
