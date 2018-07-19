package com.test.jsp.dao;

import java.util.List;

import com.test.jsp.vo.Board;

public interface BoardDAO {
	List<Board> selectBoardList(Board b);
	public boolean insertBoard(Board b);
	boolean deleteBoard(Board b);
	boolean updateBoard(Board b);
}
