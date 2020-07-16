package svc;

import java.sql.Connection;

import dao.LineupDAO;

import static db.JdbcUtil.*;

public class LineupDeleteProService {

	public boolean isArticleWriter(int lineup_no) {
		boolean isArticleWriter = false;
		Connection conn = getConnection();
		LineupDAO lineupDAO = LineupDAO.getInstance();
		lineupDAO.setConnection(conn);
		isArticleWriter = lineupDAO.isArticleLineupWriter(lineup_no);
		close(conn);
		return isArticleWriter;
	}

	public boolean removeArticle(int lineup_no) {
		boolean isRemoveSuccess = false;
		Connection conn = getConnection();
		LineupDAO lineupDAO = LineupDAO.getInstance();
		lineupDAO.setConnection(conn);
		int deleteCount = lineupDAO.deleteArticle(lineup_no);
		
		if(deleteCount > 0){
			commit(conn);
			isRemoveSuccess=true;
		}
		else{
			rollback(conn);
		}
		
		close(conn);
		return isRemoveSuccess;
	}

}
