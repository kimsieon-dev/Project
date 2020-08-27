package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CommentDAO {
	private static CommentDAO commentDAO;
	static Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private void commentDAO() {
	
		}

	public static CommentDAO getInstance() {
		if (commentDAO == null) {
			commentDAO = new CommentDAO();
		}
		return commentDAO;
	}

	public void setConnection(Connection conn) {
		this.conn = conn;

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
		String SQL = "SELECT comment_no FROM comment ORDER BY comment_no DESC";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) + 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1; // 첫번째 댓글인 경우
	}

	public int write(int sajahu_no, String memberbb_id, String comment_content) {
		String SQL = "INSERT INTO comment VALUES(?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext());
			pstmt.setInt(2, sajahu_no);
			pstmt.setString(3, memberbb_id);
			pstmt.setString(4, comment_content);
			pstmt.setString(5, getDate());
			pstmt.setInt(6, 1);
			pstmt.executeUpdate();
			return getNext();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터베이스 오류
	}

	public String getUpdateComment(int comment_no) {
		String SQL = "SELECT comment_content FROM comment WHERE comment_no = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, comment_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ""; // 오류
	}

	public ArrayList<Comment> getList(int sajau_no) {
		String SQL = "SELECT * FROM comment WHERE sajahu_no = ? AND commentAvailable = 1 ORDER BY sajahu_no DESC";
		ArrayList<Comment> list = new ArrayList<Comment>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, sajahu_no);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Comment cmt = new Comment();
				cmt.setComment_no(rs.getInt(1));
				cmt.setSajahu_noID(rs.getInt(2));
				cmt.setmemberbb_id(rs.getString(3));
				cmt.setComment_Content(rs.getString(4));
				cmt.setComment_date(rs.getString(5));
				cmt.setCommentAvilable(rs.getInt(6));
				list.add(cmt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list; // 데이터베이스 오류
	}

	public int update(int comment_no, String comment_content) {
		String SQL = "UPDATE comment SET comment_content = ? WHERE comment_no LIKE ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, comment_content);
			pstmt.setInt(2, comment_no);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터베이스 오류
	}

	public Comment getComment(int comment_no) {
		String SQL = "SELECT * FROM comment WHERE comment_no = ? ORDER BY comment_no DESC";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, comment_no);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Comment cmt = new Comment();
				cmt.setComment_no(rs.getInt(1));
				cmt.setSajahu_no(rs.getInt(2));
				cmt.setMemberbb_id(rs.getString(3));
				cmt.setComment_content(rs.getString(4));
				cmt.setComment_date(rs.getString(5));
				cmt.setCommentAvilable(rs.getInt(6));
				return cmt;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int delete(int comment_no) {
		String SQL = "DELETE FROM comment WHERE comment_no = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, comment_no);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터베이스 오류
	}

}
