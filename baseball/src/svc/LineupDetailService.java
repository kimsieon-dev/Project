package svc;

import java.sql.Connection;
import dao.LineupDAO;
import vo.LineupBean;
import static db.JdbcUtil.*;

public class LineupDetailService {

	public static LineupBean getArticle(int lineup_no) throws Exception {
		LineupBean article = null;
		Connection conn = getConnection();
		LineupDAO lineupDAO = LineupDAO.getInstance();
		lineupDAO.setConnection(conn);
		int updateCount = lineupDAO.updateReadCount(lineup_no);

		if(updateCount > 0){
			commit(conn);
		}
		else{
			rollback(conn);
		}
		
		article = lineupDAO.selectArticle(lineup_no);
		close(conn);
		return article;
	}

}
