package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import dao.BaseballDAO;
import vo.MembersBean;

public class MemberDetailService {

	public static MembersBean getArticle(String id) {
		Connection conn = getConnection();
		BaseballDAO baseballDAO = BaseballDAO.getInstance();
		baseballDAO.setConnection(conn);
		MembersBean article = BaseballDAO.selectMember(id);
		close(conn);
		
		return article;
	}
}
