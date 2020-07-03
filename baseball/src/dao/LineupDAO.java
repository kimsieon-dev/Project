package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.LineupBean;

public class LineupDAO {
	private static LineupDAO lineupDAO;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private LineupDAO() {
	
		}

	public static LineupDAO getInstance() {
		if (lineupDAO == null) {
			lineupDAO = new LineupDAO();
		}
		return lineupDAO;
	}

	
	
	public String getDate() {
		String SQL = "SELECT NOW()";

		try {

			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public int getNext() { 

		String SQL = "SELECT lineup_no FROM lineup ORDER BY lineup_no DESC";

		try {

			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1) + 1;
			}
			return 1;//첫 번째 게시물인 경우

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1; //데이터베이스 오류
	}

	public int insertArticle(LineupBean lineupBean) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setConnetion(Connection conn) {
		// TODO Auto-generated method stub
		
	}



}


