package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import dao.NoticeDAO;
import vo.NoticeBean;

public class NoticeSearchService {

	public int getSearchCount(NoticeBean search) {
		int listCount = 0;
		Connection conn = getConnection();
		NoticeDAO noticeDAO = NoticeDAO.getInstance();
		noticeDAO.setConnection(conn);
		listCount = noticeDAO.selectSearchCount(search);
		close(conn);
		System.out.println("서치 리카 : " + listCount);
		return listCount;
	}

	public ArrayList<NoticeBean> noticeSearch(int page, int limit, NoticeBean search) {
		ArrayList<NoticeBean> noticeSearch = null;
		Connection conn = getConnection();
		NoticeDAO noticeDAO = NoticeDAO.getInstance();
		noticeDAO.setConnection(conn);
		noticeSearch = noticeDAO.noticeSearch(page, limit, search);
		close(conn);
		return noticeSearch;
	}

}
