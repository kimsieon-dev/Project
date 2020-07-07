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

	public ArrayList<LineupBean> getArticleList(int page, int limit) {
		ArrayList<LineupBean> articleList = null;
		Connection conn = getConnection();
		LineupDAO lineupDAO = LineupDAO.getInstance();
		lineupDAO.setConnection(conn);
		articleList = lineupDAO.selectArticleList(page,limit);
		close(conn);
		return articleList;
	}

}
