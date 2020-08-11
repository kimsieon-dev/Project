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

	public int insertMembers(MemberbbBean members) {
		String sql = "insert into memberbb values(?, ?, ?, ?, ?)";
		int insertCount = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, members.getMemberbb_id());
			pstmt.setString(2, members.getMemberbb_password());
			pstmt.setString(3, members.getMemberbb_name());
			pstmt.setString(4, members.getMemberbb_email());
			pstmt.setString(5, members.getMemberbb_birthday());
			insertCount = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return insertCount;
	}

	public String selectLoginId(MemberbbBean members) {
		String loginId = null;
		String sql = "select memberbb_id from memberbb where memberbb_id = ? and memberbb_password = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, members.getMemberbb_id());
			pstmt.setString(2, members.getMemberbb_password());
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
}
