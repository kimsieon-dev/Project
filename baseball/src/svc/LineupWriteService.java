package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.LineupDAO;
import vo.LineupBean;

public class LineupWriteService {

	public boolean registArticle(LineupBean lineupBean) throws Exception {
		boolean isWriteSuccess = false;
		Connection conn = getConnection();
		LineupDAO lineupDAO = LineupDAO.getInstance();
		lineupDAO.setConnetion(conn);
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
