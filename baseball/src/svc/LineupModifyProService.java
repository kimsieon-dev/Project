package svc;

import java.sql.Connection;

import dao.LineupDAO;

import static db.JdbcUtil.*;
import vo.LineupBean;

public class LineupModifyProService {

	public boolean isArticleWriter(int lineup_no, String id) {
		boolean isArticleWriter = false;
		Connection conn = getConnection();
		LineupDAO lineupDAO = LineupDAO.getInstance();
		lineupDAO.setConnection(conn);
		isArticleWriter = lineupDAO.isArticleLineupWriter(lineup_no, id);
		close(conn);
		return isArticleWriter;
	}

	public boolean modifyArticle(LineupBean article) {
		boolean isModifySuccess = false;
		Connection conn = getConnection();
		LineupDAO lineupDAO = LineupDAO.getInstance();
		lineupDAO.setConnection(conn);
		int updateCount = lineupDAO.updateArticle(article);
		
		if(updateCount > 0){
			commit(conn);
			isModifySuccess=true;
		}
		else{
			rollback(conn);
		}
		
		close(conn);
		return isModifySuccess;
	}

}
