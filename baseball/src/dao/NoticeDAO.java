package dao;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import vo.NoticeBean;
import vo.PageInfo;

public class NoticeDAO {
	private static NoticeDAO noticeDAO;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	PageInfo pageinfo = new PageInfo();
	
	
	private NoticeDAO() {
		
	}

	public static NoticeDAO getInstance() {
		if (noticeDAO == null) {
			noticeDAO = new NoticeDAO();
		}
		return noticeDAO;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	 
	public int selectListCount() {
		int listCount= 0;

		try{
			System.out.println("getConnection");
			pstmt = conn.prepareStatement("select count(*) from notice");
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
	
	public ArrayList<NoticeBean> noticeList(int page, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String noticeList = "select notice_no, notice_title, notice_id, notice_readcount, notice_date from notice order by notice_no desc limit ?,10";
		ArrayList<NoticeBean> articleList = new ArrayList<NoticeBean>();
		NoticeBean notice = null;
		int startrow = (page-1) * limit; //읽기 시작할 row 번호..	

		try{
			pstmt = conn.prepareStatement(noticeList);
			pstmt.setInt(1, startrow);
			rs = pstmt.executeQuery();

			while(rs.next()){
				notice = new NoticeBean();
				notice.setNotice_no(rs.getInt("notice_no"));
				notice.setNotice_title(rs.getString("notice_title"));
				notice.setNotice_id(rs.getString("notice_id"));
				notice.setNotice_readcount(rs.getInt("notice_readcount"));
				notice.setNotice_date(rs.getDate("notice_date"));
				articleList.add(notice);
			}

		}catch(Exception ex){
			System.out.println("getNoticeupList 에러 : " + ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return articleList;
	}
	
	public NoticeBean selectArticle(int notice_no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NoticeBean noticeBean = null;

		try{
			pstmt = conn.prepareStatement("select * from notice where notice_no = ?");
			pstmt.setInt(1, notice_no);
			rs= pstmt.executeQuery();

			if(rs.next()){
				noticeBean = new NoticeBean();
				noticeBean.setNotice_no(rs.getInt("notice_no"));
				noticeBean.setNotice_id(rs.getString("notice_id"));
				noticeBean.setNotice_title(rs.getString("notice_title"));
				noticeBean.setNotice_content(rs.getString("notice_content"));
				noticeBean.setNotice_readcount(rs.getInt("notice_readcount"));
				noticeBean.setNotice_date(rs.getDate("notice_date"));
			}
		}catch(Exception ex){
			System.out.println("getDetail 에러 : " + ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return noticeBean;
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
	
	public int insertArticle(NoticeBean noticeBean) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num = 0;
		String sql = "";
		int insertCount = 0;

		try{
			pstmt = conn.prepareStatement("select max(notice_no) from notice");
			rs = pstmt.executeQuery();

			if(rs.next())
				num = rs.getInt(1)+1;
			else
				num=1;

			sql = "insert into notice values(?, ?, ? ,? ,? ,now())";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, noticeBean.getNotice_id());
			pstmt.setString(3, noticeBean.getNotice_title());
			pstmt.setString(4, noticeBean.getNotice_content());
			pstmt.setInt(5, 0);
			
			insertCount = pstmt.executeUpdate();

		}catch(Exception ex){
			System.out.println("noticeInsert 에러 : "+ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return insertCount;
	}
	
	public int updateArticle(NoticeBean article) {
		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql = "update notice set notice_title=?, notice_content=? where notice_no=?";

		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getNotice_title());
			pstmt.setString(2, article.getNotice_content());
			pstmt.setInt(3, article.getNotice_no());
			updateCount = pstmt.executeUpdate();
		}catch(Exception ex){
			System.out.println("sajahuModify 에러 : " + ex);
		}finally{
			close(pstmt);
		}

		return updateCount;
	}
	
	public int deleteArticle(int notice_no) {
		PreparedStatement pstmt = null;
		String noticeDelete = "delete from notice where notice_no=?";
		int deleteCount=0;

		try{
			pstmt = conn.prepareStatement(noticeDelete);
			pstmt.setInt(1, notice_no);
			deleteCount = pstmt.executeUpdate();
			
		}catch(Exception ex){
			System.out.println("noticeDelete 에러 : "+ex);
		}	finally{
			close(pstmt);
		}

		return deleteCount;
	}
	
	public int updateReadCount(int notice_no) {
		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql = "update notice set notice_readcount = notice_readcount+1 where notice_no = ?";

		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, notice_no);
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
		public int selectSearchCount(NoticeBean search) {
			String sql = "select count(*) from notice where notice_title like ?";
			String sql2 = "select count(*) from notice where notice_id like ?";
			int searchCount = 0;

			try {
				if(search.getNotice_option().equals("notice_title")) {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, "%" + search.getNotice_search() + "%");
					rs = pstmt.executeQuery();
					
					if(rs.next()) {
						searchCount = rs.getInt(1);
					}
				} else {
					pstmt = conn.prepareStatement(sql2);
					pstmt.setString(1, "%" + search.getNotice_search() + "%");
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

		public ArrayList<NoticeBean> noticeSearch(int page, int limit, NoticeBean search) {
			String sql = "select * from notice where notice_title like ? order by notice_no desc limit ?, 10";
			String sql2 = "select * from notice where notice_id like ? order by notice_no desc limit ?, 10";
			ArrayList<NoticeBean> noticeSearch = new ArrayList<NoticeBean>();
			NoticeBean searchboard = null;
			
			int startrow = (page - 1) * 10; //읽기 시작할 row 번호..	

			try {
				if(search.getNotice_option().equals("notice_title")) {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, "%" + search.getNotice_search() + "%");
					pstmt.setInt(2, startrow);
					rs = pstmt.executeQuery();

					while(rs.next()) {
						searchboard = new NoticeBean();
						searchboard.setNotice_no(rs.getInt("notice_no"));
						searchboard.setNotice_title(rs.getString("notice_title"));
						searchboard.setNotice_id(rs.getString("notice_id"));
						searchboard.setNotice_readcount(rs.getInt("notice_readcount"));	
						searchboard.setNotice_date(rs.getDate("notice_date"));
						noticeSearch.add(searchboard);
					}
				} else {
					pstmt = conn.prepareStatement(sql2);
					pstmt.setString(1, "%" + search.getNotice_search() + "%");
					pstmt.setInt(2, startrow);
					rs = pstmt.executeQuery();

					while(rs.next()) {
						searchboard = new NoticeBean();
						searchboard.setNotice_no(rs.getInt("notice_no"));
						searchboard.setNotice_title(rs.getString("notice_title"));
						searchboard.setNotice_id(rs.getString("notice_id"));
						searchboard.setNotice_readcount(rs.getInt("notice_readcount"));	
						searchboard.setNotice_date(rs.getDate("notice_date"));
						noticeSearch.add(searchboard);
					}
				}
				
			} catch(Exception ex) {
				System.out.println("noticeupSearch 에러 : " + ex);
			} finally {
				close(rs);
				close(pstmt);
			}
			return noticeSearch;
		}
	
}


