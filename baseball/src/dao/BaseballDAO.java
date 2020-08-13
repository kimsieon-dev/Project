package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.MemberbbBean;

public class BaseballDAO {
	private static BaseballDAO baseballDAO;
	static Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private BaseballDAO() {
	
		}

	public static BaseballDAO getInstance() {
		if (baseballDAO == null) {
			baseballDAO = new BaseballDAO();
		}
		return baseballDAO;
	}

	public void setConnection(Connection conn) {
		this.conn = conn;

	}

	public int insertMembers(MemberbbBean memberbb) {
		String sql = "insert into memberbb values(?, ?, ?, ?, ?)";
		int insertCount = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberbb.getMemberbb_id());
			pstmt.setString(2, memberbb.getMemberbb_password());
			pstmt.setString(3, memberbb.getMemberbb_name());
			pstmt.setString(4, memberbb.getMemberbb_email());
			pstmt.setString(5, memberbb.getMemberbb_birthday());
			insertCount = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return insertCount;
	}

	public String selectLoginId(MemberbbBean memberbb) {
		String loginId = null;
		String sql = "select memberbb_id from memberbb where memberbb_id = ? and memberbb_password = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberbb.getMemberbb_id());
			pstmt.setString(2, memberbb.getMemberbb_password());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				loginId = rs.getString("memberbb_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return loginId;
	}

	public static MemberbbBean selectMember(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberbbBean memberbbBean = null;
		
		try {
			pstmt = conn.prepareStatement("select * from memberbb where memberbb_id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				memberbbBean = new MemberbbBean();
				memberbbBean.setMemberbb_id(rs.getString("memberbb_id"));
				memberbbBean.setMemberbb_password(rs.getString("memberbb_password"));
				memberbbBean.setMemberbb_name(rs.getString("memberbb_name"));
				memberbbBean.setMemberbb_email(rs.getString("memberbb_email"));
				memberbbBean.setMemberbb_birthday(rs.getString("memberbb_birthday"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return memberbbBean;
	}

	public int updateArticle(MemberbbBean article) {
		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql = "update memberbb set memberbb_password = ?, memberbb_email = ? where memberbb_id = ?";

		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getMemberbb_password());
			pstmt.setString(2, article.getMemberbb_email());
			pstmt.setString(3, article.getMemberbb_id());
			
			updateCount = pstmt.executeUpdate();
		}catch(Exception ex){
			System.out.println("memberModify 에러 : " + ex);
		}finally{
			close(pstmt);
		}

		return updateCount;
	}

	public int deleteMember(String id) {
		String sql = "DELETE FROM memberbb WHERE memberbb_id=?";
		int deleteCount = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			deleteCount = pstmt.executeUpdate();
		} catch(Exception ex) {
			System.out.println("deleteMember 에러: " + ex);	
		} finally {
			close(pstmt);
		}
		
		return deleteCount;
	}

	public int OverLapId(MemberbbBean memberbb) {
String sql = "SELECT memberbb_id FROM memberbb WHERE memberbb_id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberbb.getMemberbb_id());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return 0;		// 아이디 있음
			} else {
				return 1;		// 가입 가능
			}
		} catch (Exception ex) {
			System.out.println(" 에러: " + ex);			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return -1;	// 디비 에러
	}
}
