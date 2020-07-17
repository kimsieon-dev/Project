package dao;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import vo.LineupBean;
import vo.SajahuBean;

public class SajahuDAO {
	private static SajahuDAO sajahuDAO;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private SajahuDAO() {
		
	}

	public static SajahuDAO getInstance() {
		if (sajahuDAO == null) {
			sajahuDAO = new SajahuDAO();
		}
		return sajahuDAO;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	 
	public int selectListCount() {
		int listCount= 0;

		try{
			System.out.println("getConnection");
			pstmt = conn.prepareStatement("select count(*) from sajahu");
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
	
	public ArrayList<SajahuBean> sajahuList(int page, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sajahuList = "select sajahu_no, sajahu_title, sajahu_id, sajahu_readcount, sajahu_date from sajahu order by sajahu_no desc limit ?,10";
		ArrayList<SajahuBean> articleList = new ArrayList<SajahuBean>();
		SajahuBean sajahu = null;
		int startrow = (page-1) * limit; //읽기 시작할 row 번호..	

		try{
			pstmt = conn.prepareStatement(sajahuList);
			pstmt.setInt(1, startrow);
			rs = pstmt.executeQuery();

			while(rs.next()){
				sajahu = new SajahuBean();
				sajahu.setSajahu_no(rs.getInt("sajahu_no"));
				sajahu.setSajahu_title(rs.getString("sajahu_title"));
				sajahu.setSajahu_id(rs.getString("sajahu_id"));
				sajahu.setSajahu_readcount(rs.getInt("sajahu_readcount"));
				sajahu.setSajahu_date(rs.getDate("sajahu_date"));
				articleList.add(sajahu);
			}

		}catch(Exception ex){
			System.out.println("getLineupList 에러 : " + ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return articleList;
	}
	
	public SajahuBean selectArticle(int sajahu_no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SajahuBean sajahuBean = null;

		try{
			pstmt = conn.prepareStatement("select * from sajahu where sajahu_no = ?");
			pstmt.setInt(1, sajahu_no);
			rs= pstmt.executeQuery();

			if(rs.next()){
				sajahuBean = new SajahuBean();
				sajahuBean.setSajahu_no(rs.getInt("sajahu_no"));
				sajahuBean.setSajahu_id(rs.getString("sajahu_id"));
				sajahuBean.setSajahu_title(rs.getString("sajahu_title"));
				sajahuBean.setSajahu_content(rs.getString("sajahu_content"));
				sajahuBean.setSajahu_readcount(rs.getInt("sajahu_readcount"));
				sajahuBean.setSajahu_date(rs.getDate("sajahu_date"));
			}
		}catch(Exception ex){
			System.out.println("getDetail 에러 : " + ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return sajahuBean;
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
	
	public int insertArticle(SajahuBean sajahuBean) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num = 0;
		String sql = "";
		int insertCount = 0;

		try{
			pstmt = conn.prepareStatement("select max(sajahu_no) from sajahu");
			rs = pstmt.executeQuery();

			if(rs.next())
				num = rs.getInt(1)+1;
			else
				num=1;

			sql = "insert into sajahu values(?, ?, ? ,? ,? ,now())";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, sajahuBean.getSajahu_id());
			pstmt.setString(3, sajahuBean.getSajahu_title());
			pstmt.setString(4, sajahuBean.getSajahu_content());
			pstmt.setInt(5, 0);
			
			insertCount = pstmt.executeUpdate();

		}catch(Exception ex){
			System.out.println("lineupInsert 에러 : "+ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return insertCount;
	}
	
	public int updateArticle(SajahuBean article) {
		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql = "update sajahu set sajahu_title=?, sajahu_content=? where sajahu_no=?";

		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getSajahu_title());
			pstmt.setString(2, article.getSajahu_content());
			pstmt.setInt(3, article.getSajahu_no());
			updateCount = pstmt.executeUpdate();
		}catch(Exception ex){
			System.out.println("sajahuModify 에러 : " + ex);
		}finally{
			close(pstmt);
		}

		return updateCount;
	}
	
	public int deleteArticle(int sajahu_no) {
		PreparedStatement pstmt = null;
		String sajahuDelete = "delete from sajahu where sajahu_no=?";
		int deleteCount=0;

		try{
			pstmt = conn.prepareStatement(sajahuDelete);
			pstmt.setInt(1, sajahu_no);
			deleteCount = pstmt.executeUpdate();
			
		}catch(Exception ex){
			System.out.println("sajahuDelete 에러 : "+ex);
		}	finally{
			close(pstmt);
		}

		return deleteCount;
	}
	
	public int updateReadCount(int sajahu_no) {
		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql = "update sajahu set sajahu_readcount = sajahu_readcount+1 where sajahu_no = ?";

		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sajahu_no);
			updateCount = pstmt.executeUpdate();
		}catch(SQLException ex){
			System.out.println("updateReadCount 에러 : "+ex);
		}
		finally{
			close(pstmt);

		}

		return updateCount;
	}
	
}


