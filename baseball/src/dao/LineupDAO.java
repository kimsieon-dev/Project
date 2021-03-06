package dao;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import vo.LineupBean;
import vo.PageInfo;

public class LineupDAO {
	private static LineupDAO lineupDAO;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	PageInfo pageinfo = new PageInfo();
	
	private LineupDAO() {
		
	}

	public static LineupDAO getInstance() {
		if (lineupDAO == null) {
			lineupDAO = new LineupDAO();
		}
		return lineupDAO;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	 
	public int selectListCount() {
		int listCount= 0;

		try{
			System.out.println("getConnection");
			pstmt = conn.prepareStatement("select count(*) from lineup");
			rs = pstmt.executeQuery();

			if(rs.next()){
				listCount = rs.getInt(1);
			}
		}catch(Exception ex){
			System.out.println("getListCount 에러: " + ex);			
		}finally{
			close(rs);
			close(pstmt);
		}

		return listCount;
	}
	
	public ArrayList<LineupBean> lineupList(int page, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String lineupList = "select lineup_no, lineup_title, lineup_id, lineup_readcount, lineup_date from lineup order by lineup_no desc limit ?,10";
		ArrayList<LineupBean> articleList = new ArrayList<LineupBean>();
		LineupBean lineup = null;
		int startrow = (page-1) * limit; //읽기 시작할 row 번호..	

		try{
			pstmt = conn.prepareStatement(lineupList);
			pstmt.setInt(1, startrow);
			rs = pstmt.executeQuery();

			while(rs.next()){
				lineup = new LineupBean();
				lineup.setLineup_no(rs.getInt("lineup_no"));
				lineup.setLineup_title(rs.getString("lineup_title"));
				lineup.setLineup_id(rs.getString("lineup_id"));
				lineup.setLineup_readcount(rs.getInt("lineup_readcount"));
				lineup.setLineup_date(rs.getDate("lineup_date"));
				articleList.add(lineup);
			}

		}catch(Exception ex){
			System.out.println("getLineupList 에러 : " + ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return articleList;
	}
	
	public LineupBean selectArticle(int lineup_no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LineupBean lineupBean = null;

		try{
			pstmt = conn.prepareStatement("select * from lineup where lineup_no = ?");
			pstmt.setInt(1, lineup_no);
			rs= pstmt.executeQuery();

			if(rs.next()){
				lineupBean = new LineupBean();
				lineupBean.setLineup_no(rs.getInt("lineup_no"));
				lineupBean.setLineup_id(rs.getString("lineup_id"));
				lineupBean.setLineup_title(rs.getString("lineup_title"));
				lineupBean.setLineup_vs(rs.getString("lineup_vs"));
				lineupBean.setLineup_pit(rs.getString("lineup_pit"));
				lineupBean.setLineup_bat1(rs.getString("lineup_bat1"));
				lineupBean.setLineup_bat2(rs.getString("lineup_bat2"));
				lineupBean.setLineup_bat3(rs.getString("lineup_bat3"));
				lineupBean.setLineup_bat4(rs.getString("lineup_bat4"));
				lineupBean.setLineup_bat5(rs.getString("lineup_bat5"));
				lineupBean.setLineup_bat6(rs.getString("lineup_bat6"));
				lineupBean.setLineup_bat7(rs.getString("lineup_bat7"));
				lineupBean.setLineup_bat8(rs.getString("lineup_bat8"));
				lineupBean.setLineup_bat9(rs.getString("lineup_bat9"));
				lineupBean.setLineup_readcount(rs.getInt("lineup_readcount"));
				lineupBean.setLineup_date(rs.getDate("lineup_date"));
			}
		}catch(Exception ex){
			System.out.println("getDetail 에러 : " + ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return lineupBean;
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
	
	public int insertArticle(LineupBean article) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num = 0;
		String sql = "";
		int insertCount = 0;

		try{
			pstmt = conn.prepareStatement("select max(lineup_no) from lineup");
			rs = pstmt.executeQuery();

			if(rs.next())
				num = rs.getInt(1)+1;
			else
				num=1;

			sql = "insert into lineup values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,now())";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, article.getLineup_id());
			pstmt.setString(3, article.getLineup_title());
			pstmt.setString(4, article.getLineup_vs());
			pstmt.setString(5, article.getLineup_pit());
			pstmt.setString(6, article.getLineup_bat1());
			pstmt.setString(7, article.getLineup_bat2());
			pstmt.setString(8, article.getLineup_bat3());
			pstmt.setString(9, article.getLineup_bat4());
			pstmt.setString(10, article.getLineup_bat5());
			pstmt.setString(11, article.getLineup_bat6());
			pstmt.setString(12, article.getLineup_bat7());
			pstmt.setString(13, article.getLineup_bat8());
			pstmt.setString(14, article.getLineup_bat9());
			pstmt.setInt(15, 0);
			
			insertCount = pstmt.executeUpdate();

		}catch(Exception ex){
			System.out.println("lineupInsert 에러 : "+ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return insertCount;
	}
	
	public int updateArticle(LineupBean article) {
		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql = "update lineup set lineup_title=?,lineup_vs=?,lineup_pit=?,lineup_bat1=?,lineup_bat2=?,lineup_bat3=?,lineup_bat4=?,lineup_bat5=?,lineup_bat6=?,lineup_bat7=?,lineup_bat8=?,lineup_bat9=? where lineup_no=?";

		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getLineup_title());
			pstmt.setString(2, article.getLineup_vs());
			pstmt.setString(3, article.getLineup_pit());
			pstmt.setString(4, article.getLineup_bat1());
			pstmt.setString(5, article.getLineup_bat2());
			pstmt.setString(6, article.getLineup_bat3());
			pstmt.setString(7, article.getLineup_bat4());
			pstmt.setString(8, article.getLineup_bat5());
			pstmt.setString(9, article.getLineup_bat6());
			pstmt.setString(10, article.getLineup_bat7());
			pstmt.setString(11, article.getLineup_bat8());
			pstmt.setString(12, article.getLineup_bat9());
			pstmt.setInt(13, article.getLineup_no());
			updateCount = pstmt.executeUpdate();
		}catch(Exception ex){
			System.out.println("lineupModify 에러 : " + ex);
		}finally{
			close(pstmt);
		}

		return updateCount;
	}
	
	public int deleteArticle(int lineup_no) {
		PreparedStatement pstmt = null;
		String lineupDelete = "delete from lineup where lineup_no=?";
		int deleteCount=0;

		try{
			pstmt = conn.prepareStatement(lineupDelete);
			pstmt.setInt(1, lineup_no);
			deleteCount = pstmt.executeUpdate();
			
		}catch(Exception ex){
			System.out.println("lineupDelete 에러 : "+ex);
		}	finally{
			close(pstmt);
		}

		return deleteCount;
	}
	
	public int updateReadCount(int lineup_no) {
		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql = "update lineup set lineup_readcount = lineup_readcount+1 where lineup_no = ?";

		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lineup_no);
			updateCount = pstmt.executeUpdate();
		}catch(SQLException ex){
			System.out.println("updateReadCount 에러 : "+ex);
		}
		finally{
			close(pstmt);

		}

		return updateCount;
	}
	
	// 검색
	public int selectSearchCount(LineupBean search) {
		String sql = "select count(*) from lineup where lineup_title like ?";
		String sql2 = "select count(*) from lineup where lineup_id like ?";
		int searchCount = 0;

		try {
			if(search.getLineup_option().equals("lineup_title")) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + search.getLineup_search() + "%");
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					searchCount = rs.getInt(1);
				}
			} else {
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, "%" + search.getLineup_search() + "%");
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					searchCount = rs.getInt(1);
				}
			}
		} catch(Exception ex) {
			System.out.println("searchCount 에러: " + ex);			
		} finally {
			close(rs);
			close(pstmt);
		}
		return searchCount;
	}
	
	public int totalBlock() {	// 전체 블록의 수
		if(selectListCount() % (pageinfo.getWidthBlock() * pageinfo.getPageRows()) > 0) {
			return selectListCount() / (pageinfo.getWidthBlock() * pageinfo.getPageRows()) + 1;
		}
		return selectListCount() / (pageinfo.getWidthBlock() * pageinfo.getPageRows());
	}
	
	public int currentBlock(int nowpage) {		// 현재 블럭의 수
		if(nowpage % pageinfo.getWidthBlock() > 0) {
			return nowpage / pageinfo.getWidthBlock() + 1;
		}
		return nowpage / pageinfo.getWidthBlock();
	}
	
	public int totalPage() {		// 전체 페이지 수를 계산하는 메소드
		if(selectListCount() % pageinfo.getPageRows() > 0) {
			return selectListCount() / pageinfo.getPageRows() + 1;
		}
		return selectListCount() / pageinfo.getPageRows();
	}

	public ArrayList<LineupBean> lineupSearch(int page, int limit, LineupBean search) {
		String sql = "select * from lineup where lineup_title like ? order by lineup_no desc limit ?, 10";
		String sql2 = "select * from lineup where lineup_id like ? order by lineup_no desc limit ?, 10";
		ArrayList<LineupBean> lineupSearch = new ArrayList<LineupBean>();
		LineupBean searchboard = null;
		
		int startrow = (page - 1) * 10; //읽기 시작할 row 번호..	

		try {
			if(search.getLineup_option().equals("lineup_title")) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + search.getLineup_search() + "%");
				pstmt.setInt(2, startrow);
				rs = pstmt.executeQuery();

				while(rs.next()) {
					searchboard = new LineupBean();
					searchboard.setLineup_no(rs.getInt("lineup_no"));
					searchboard.setLineup_title(rs.getString("lineup_title"));
					searchboard.setLineup_id(rs.getString("lineup_id"));
					searchboard.setLineup_readcount(rs.getInt("lineup_readcount"));	
					searchboard.setLineup_date(rs.getDate("lineup_date"));
					lineupSearch.add(searchboard);
				}
			} else {
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, "%" + search.getLineup_search() + "%");
				pstmt.setInt(2, startrow);
				rs = pstmt.executeQuery();

				while(rs.next()) {
					searchboard = new LineupBean();
					searchboard.setLineup_no(rs.getInt("lineup_no"));
					searchboard.setLineup_title(rs.getString("lineup_title"));
					searchboard.setLineup_id(rs.getString("lineup_id"));
					searchboard.setLineup_readcount(rs.getInt("lineup_readcount"));	
					searchboard.setLineup_date(rs.getDate("lineup_date"));
					lineupSearch.add(searchboard);
				}
			}
			
		} catch(Exception ex) {
			System.out.println("lineupSearch 에러 : " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}
		return lineupSearch;
	}

	
	
}


