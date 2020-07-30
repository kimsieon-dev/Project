package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.MembersBean;

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

	public int insertMembers(MembersBean members) {
		String sql = "insert into members values(?, ?, ?, ?, ?)";
		int insertCount = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, members.getMembers_id());
			pstmt.setString(2, members.getMembers_password());
			pstmt.setString(3, members.getMembers_name());
			pstmt.setString(4, members.getMembers_email());
			pstmt.setString(5, members.getMembers_birthday());
			insertCount = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return insertCount;
	}

	public String selectLoginId(MembersBean members) {
		String loginId = null;
		String sql = "select members_id from members where members_id = ? and members_password = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, members.getMembers_id());
			pstmt.setString(2, members.getMembers_password());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				loginId = rs.getString("members_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return loginId;
	}

	public static MembersBean selectMember(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MembersBean membersBean = null;
		
		try {
			pstmt = conn.prepareStatement("select * from members where members_id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				membersBean = new MembersBean();
				membersBean.setMembers_id(rs.getString("members_id"));
				membersBean.setMembers_password(rs.getString("members_password"));
				membersBean.setMembers_name(rs.getString("members_name"));
				membersBean.setMembers_email(rs.getString("members_email"));
				membersBean.setMembers_birthday(rs.getString("members_birthday"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return membersBean;
	}
}
