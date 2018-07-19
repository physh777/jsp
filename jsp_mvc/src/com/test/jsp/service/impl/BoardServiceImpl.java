package com.test.jsp.service.impl;

import java.util.List;

import com.test.jsp.dao.BoardDAO;
import com.test.jsp.dao.impl.BoardDAOImpl;
import com.test.jsp.service.BoardService;
import com.test.jsp.vo.Board;

public class BoardServiceImpl implements BoardService {
	private BoardDAO bdao = new BoardDAOImpl();
	@Override
	public List<Board> getBoardList(Board b) {
		return bdao.selectBoardList(b);
	}
	@Override
	public boolean insertBoard(Board b) {
		return bdao.insertBoard(b);
	}
	@Override
	public Board getBoard(Board b) {
		return bdao.selectBoardList(b).get(0);
	}
	@Override
	public boolean deleteBoard(Board b) {
		// TODO Auto-generated method stub
		return bdao.deleteBoard(b);
	}
	@Override
	public boolean updateBoard(Board b) {
		return bdao.updateBoard(b);
	}
}
