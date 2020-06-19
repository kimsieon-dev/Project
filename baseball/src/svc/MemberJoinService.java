package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.BaseballDAO;
import vo.MembersBean;

public class MemberJoinService {

	public boolean joinMember(MembersBean members) {
		boolean joinSuccess = false;
		BaseballDAO baseballDAO = BaseballDAO.getInstance();
		Connection conn = getConnection();
		baseballDAO.setConnection(conn);
		int insertCount = baseballDAO.insertMembers(members);
		if(insertCount > 0) {
			joinSuccess = true;
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return joinSuccess;
	}
}
