package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.BaseballDAO;
import vo.MemberbbBean;

public class MemberJoinService {

	public boolean joinMember(MemberbbBean memberbb) {
		boolean joinSuccess = false;
		BaseballDAO baseballDAO = BaseballDAO.getInstance();
		Connection conn = getConnection();
		baseballDAO.setConnection(conn);
		int insertCount = baseballDAO.insertMembers(memberbb);
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
