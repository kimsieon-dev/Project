package svc;

import java.sql.Connection;

import dao.LineupDAO;

import static db.JdbcUtil.*;

public class LineupDeleteProService {

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
