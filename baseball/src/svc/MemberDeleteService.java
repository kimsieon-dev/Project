package svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.BaseballDAO;

public class MemberDeleteService {

public boolean deleteMember(String id) throws Exception {
		
		boolean isRemoveSuccess = false;
		Connection conn = getConnection();
		BaseballDAO baseballDAO = BaseballDAO.getInstance();
		baseballDAO.setConnection(conn);
		int deleteCount = baseballDAO.deleteMember(id);
		
		if(deleteCount > 0) {
			commit(conn);
			isRemoveSuccess = true;
		}
		else {
			rollback(conn);
		}		
		close(conn);
		return isRemoveSuccess;
	}
}
