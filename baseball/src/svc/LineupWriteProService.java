package svc;

import java.sql.Connection;

import static db.JdbcUtil.*;
import dao.LineupDAO;
import vo.LineupBean;

public class LineupWriteProService {

	public boolean registArticle(LineupBean lineupBean) {
		
		boolean isWriteSuccess = false;
		Connection conn = getConnection();
		LineupDAO lineupDAO = LineupDAO.getInstance();
		lineupDAO.setConnection(conn);
		int insertCount = lineupDAO.insertArticle(lineupBean);
		
		if(insertCount > 0) {
			commit(conn);
			isWriteSuccess = true;
		} else {
			rollback(conn);
		}
		
		close(conn);
		return isWriteSuccess;
	}

}
