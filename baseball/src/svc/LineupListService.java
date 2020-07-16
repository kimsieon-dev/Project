package svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.LineupDAO;
import vo.LineupBean;
import static db.JdbcUtil.*;
public class LineupListService {

	public int getListCount() {
		int listCount = 0;
		Connection conn = getConnection();
		LineupDAO lineupDAO = LineupDAO.getInstance();
		lineupDAO.setConnection(conn);
		listCount = lineupDAO.selectListCount();
		close(conn);
		return listCount;
	}

	public ArrayList<LineupBean> getlineupList(int page, int limit) throws Exception {
		ArrayList<LineupBean> lineupList = null;
		Connection conn = getConnection();
		LineupDAO lineupDAO = LineupDAO.getInstance();
		lineupDAO.setConnection(conn);
		lineupList = lineupDAO.lineupList(page,limit);
		close(conn);
		return lineupList;
	}

	

}
