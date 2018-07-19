package com.test.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.test.jsp.service.BoardService;
import com.test.jsp.service.impl.BoardServiceImpl;
import com.test.jsp.vo.Board;
import com.test.jsp.vo.UserInfo;

public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Gson gs = new Gson();
    private BoardService bs = new BoardServiceImpl();
    
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html charset=utf-8");
		res.setCharacterEncoding("utf-8");
		String uri = req.getRequestURI();
		String cmd = uri.replace("/board/","");
		PrintWriter pw = res.getWriter();
		
		String param = req.getParameter("param");
		Board b = null;
		if(param!=null) {
			b = gs.fromJson(param,Board.class);
		}
		
		if(cmd.equals("list")) {
			List<Board> bList = bs.getBoardList(b);
			String str = gs.toJson(bList);
			pw.write(str);
		}else if(cmd.equals("write")) {
			HttpSession hs = req.getSession();
			UserInfo ui = (UserInfo)hs.getAttribute("user");
			b.setuNum(ui.getNum());
			boolean result = bs.insertBoard(b);
			HashMap<String,String> reMap = new HashMap<String,String>();
			reMap.put("msg", "게시판 입력이 실패했어요");
			if(result) {
				reMap.put("msg","게시물 입력이 성공하였습니다.");
			}
			reMap.put("result",result+"");
			pw.write(gs.toJson(reMap));
		}else if(cmd.equals("view")) {
			b = bs.getBoard(b);
			pw.write(gs.toJson(b));
		}else if(cmd.equals("delete")) {
			boolean result = bs.deleteBoard(b);
			HashMap<String,String> reMap = new HashMap<String,String>();
			reMap.put("msg", "게시물 삭제가 실패하였습니다.");
			if(result) {
				reMap.put("msg","게시물 삭제가 성공하였습니다.");
			}
			reMap.put("result",result+"");
			pw.write(gs.toJson(reMap));
		}else if(cmd.equals("update")) {
			HttpSession hs = req.getSession();
			UserInfo ui = (UserInfo)hs.getAttribute("user");
			b.setbModusr(ui.getNum());
			boolean result = bs.updateBoard(b);
			HashMap<String,String> reMap = new HashMap<String,String>();
			reMap.put("msg", "게시물 수정이 실패하였습니다.");
			if(result) {
				reMap.put("msg","게시물 수정이 성공하였습니다.");
			}
			reMap.put("result",result+"");
			pw.write(gs.toJson(reMap));
		}
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		doGet(req, res);
	}

}
