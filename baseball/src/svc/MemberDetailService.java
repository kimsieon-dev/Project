package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import dao.BaseballDAO;
import vo.MembersBean;
import vo.NoticeBean;

public class MemberDetailService {

	public static MembersBean getArticle(String id) {
		MembersBean article = null;
		Connection conn = getConnection();
		BaseballDAO baseballDAO = BaseballDAO.getInstance();
		baseballDAO.setConnection(conn);
		article = BaseballDAO.selectMember(id);
		close(conn);
		
		return article;
	}
}
