package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.NoticeDAO;
import vo.NoticeBean;

public class NoticeListService {

	public int getListCount() {
		int listCount = 0;
		Connection conn = getConnection();
		NoticeDAO noticeDAO = NoticeDAO.getInstance();
		noticeDAO.setConnection(conn);
		listCount = noticeDAO.selectListCount();
		close(conn);
		return listCount;
	}

	public ArrayList<NoticeBean> getnoticeList(int page, int limit) throws Exception {
		ArrayList<NoticeBean> noticeList = null;
		Connection conn = getConnection();
		NoticeDAO noticeDAO = NoticeDAO.getInstance();
		noticeDAO.setConnection(conn);
		noticeList = noticeDAO.noticeList(page,limit);
		close(conn);
		return noticeList;
	}

}
