package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.NoticeDAO;
import dao.SajahuDAO;

public class NoticeDeleteProService {

	public boolean removeArticle(int notice_no) {
		boolean isRemoveSuccess = false;
		Connection conn = getConnection();
		NoticeDAO noticeDAO = NoticeDAO.getInstance();
		noticeDAO.setConnection(conn);
		int deleteCount = noticeDAO.deleteArticle(notice_no);
		
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
