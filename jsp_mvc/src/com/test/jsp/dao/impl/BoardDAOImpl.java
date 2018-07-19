package com.test.jsp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.jsp.common.DBCon;
import com.test.jsp.dao.BoardDAO;
import com.test.jsp.vo.Board;
import com.test.jsp.vo.Board;

public class BoardDAOImpl implements BoardDAO {

	private Connection con;
	@Override
	public List<Board> selectBoardList(Board b) {
		List<Board> boardList = new ArrayList<Board>();
		con = DBCon.getCon();
		try {
			String sql = "select bNum,\r\n" + 
					"bTitle,\r\n" + 
					"bText,\r\n" + 
					"uNum,\r\n" + 
					"bCredat,\r\n" + 
					"bCretim,\r\n" + 
					"ifNull(bModusr,0) as bModusr,\r\n" + 
					"ifNull(bModdat,'-') as bModdat,\r\n" + 
					"ifNull(bModtim,'-') as bModtim,\r\n" + 
					"visible,\r\n" + 
					" u.name from board b,\r\n" + 
					"user_info u where b.uNum = u.num";
			if(b!=null) {
				if(b.getbTitle()!=null) {
					sql += " and bTitle like ?";
				}
				if(b.getbNum()!=0) {
					sql += " and bNum=?";
				}
			}
			PreparedStatement ps = con.prepareStatement(sql);
			if(b!=null) {
				if(b.getbTitle()!=null) {
					ps.setString(1, "%" + b.getbTitle() + "%");
				}
				if(b.getbNum()!=0) {
					ps.setInt(1, b.getbNum());
				}
			}
			ResultSet rs = ps.executeQuery();
			Board board;
			while(rs.next()) {
				board = new Board();
				board.setbCredat(rs.getString("bCredat"));
				board.setbCretim(rs.getString("bCretim"));
				board.setbModdat(rs.getString("bModdat"));
				board.setbModtim(rs.getString("bModtim"));
				board.setbModusr(rs.getInt("bModusr"));
				board.setbNum(rs.getInt("bNum"));
				board.setuNum(rs.getInt("uNum"));
				board.setbTitle(rs.getString("bTitle"));
				board.setbText(rs.getString("bText"));
				board.setVisible(rs.getString("visible").charAt(0));
				board.setUserName(rs.getString("name"));
				boardList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBCon.close();
		}
		return boardList;
	}
	@Override
	public boolean insertBoard(Board b) {
		boolean result = false;
		Connection con = DBCon.getCon();
		try {
			String sql = "insert into board(bTitle, bText, uNum, bCredat, bCretim)";
			sql += "values(?,?,?,date_format(now(),'%Y%m%d'),date_format(now(),'%H%i%s'))";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, b.getbTitle());
			ps.setString(2, b.getbText());
			ps.setInt(3, b.getuNum());
			
			int cnt = ps.executeUpdate();
			if(cnt==1) {
				result = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBCon.close();
		}
		return result;
	}
	@Override
	public boolean deleteBoard(Board b) {
		boolean result = false;
		Connection con = DBCon.getCon();
		try {
			String sql = "delete from board where bNum=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, b.getbNum());
			int cnt = ps.executeUpdate();
			if(cnt==1) {
				result = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBCon.close();
		}
		return result;
	}
	@Override
	public boolean updateBoard(Board b) {
		boolean result = false;
		Connection con = DBCon.getCon();
		try { 
			String sql = "update board set bTitle=?,bText=?,bModusr=?, ";
			sql += " bModdat=date_format(now(),'%Y%m%d'),bModtim=date_format(now(),'%H%i%s')";
			sql += " where bNum=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, b.getbTitle());
			ps.setString(2, b.getbText());
			ps.setInt(3, b.getbModusr());
			ps.setInt(4, b.getbNum());
			int cnt = ps.executeUpdate();
			if(cnt==1) {
				result = true;
			} 
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			DBCon.close();
		}
		return result;
	}

}
