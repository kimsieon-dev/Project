package svc;

import java.sql.Connection;

import dao.BaseballDAO;
import dao.LineupDAO;

import static db.JdbcUtil.*;
import vo.MemberbbBean;

public class MemberModifyProService {

	public static boolean modifyArticle(MemberbbBean article) {
		boolean isModifySuccess = false;
		Connection conn = getConnection();
		BaseballDAO baseballDAO = BaseballDAO.getInstance();
		baseballDAO.setConnection(conn);
		int updateCount = baseballDAO.updateArticle(article);
		
		if(updateCount > 0){
			commit(conn);
			isModifySuccess=true;
		}
		else{
			rollback(conn);
		}
		
		close(conn);
		return isModifySuccess;
	}

}
