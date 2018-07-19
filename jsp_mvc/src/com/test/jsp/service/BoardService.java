package com.test.jsp.service;

import java.util.List;

import com.test.jsp.vo.Board;

public interface BoardService {
	List<Board> getBoardList(Board b);
	boolean insertBoard(Board b);
	boolean deleteBoard(Board b);
	Board getBoard(Board b);
	boolean updateBoard(Board b);
}
