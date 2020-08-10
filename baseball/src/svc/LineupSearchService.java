package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import dao.LineupDAO;
import vo.LineupBean;

public class LineupSearchService {

	public int getSearchCount(LineupBean search) {
		int listCount = 0;
		Connection conn = getConnection();
		LineupDAO lineupDAO = LineupDAO.getInstance();
		lineupDAO.setConnection(conn);
		listCount = lineupDAO.selectSearchCount(search);
		close(conn);
		System.out.println("서치 리카 : " + listCount);
		return listCount;
	}

	public ArrayList<LineupBean> lineupSearch(int page, int limit, LineupBean search) {
		ArrayList<LineupBean> lineupSearch = null;
		Connection conn = getConnection();
		LineupDAO lineupDAO = LineupDAO.getInstance();
		lineupDAO.setConnection(conn);
		lineupSearch = lineupDAO.lineupSearch(page, limit, search);
		close(conn);
		return lineupSearch;
	}

}
