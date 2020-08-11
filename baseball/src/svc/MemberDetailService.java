package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import dao.BaseballDAO;
import vo.MemberbbBean;

public class MemberDetailService {

	public static MemberbbBean getArticle(String id) {
		MemberbbBean article = null;
		Connection conn = getConnection();
		BaseballDAO baseballDAO = BaseballDAO.getInstance();
		baseballDAO.setConnection(conn);
		article = BaseballDAO.selectMember(id);
		close(conn);
		
		return article;
	}
}
