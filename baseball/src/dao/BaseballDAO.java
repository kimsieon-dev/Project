package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.MembersBean;

public class BaseballDAO {
	private static BaseballDAO baseballDAO;
	Connection conn;
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
			pstmt.setInt(parameterIndex, x);
			pstmt.setString(1, members.getMember_id());
			pstmt.setString(2, members.getMember_password());
			pstmt.setString(3, members.getMember_name());
			pstmt.setString(4, members.getMember_email());
			pstmt.setString(5, members.getMember_birthday());
			insertCount = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return insertCount;
	}
}
