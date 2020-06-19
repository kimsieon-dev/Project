package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
}
