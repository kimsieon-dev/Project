package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.NoticeDAO;
import vo.NoticeBean;

public class NoticeDetailService {

	public static NoticeBean getArticle(int notice_no) throws Exception {
		NoticeBean article = null;
		Connection conn = getConnection();
		NoticeDAO noticeDAO = NoticeDAO.getInstance();
		noticeDAO.setConnection(conn);
		int updateCount = noticeDAO.updateReadCount(notice_no);

		if(updateCount > 0){
			commit(conn);
		}
		else{
			rollback(conn);
		}
		
		article = noticeDAO.selectArticle(notice_no);
		close(conn);
		return article;
	}

}
