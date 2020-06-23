package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.BaseballDAO;
import vo.MembersBean;

public class MemberLoginService {

	public boolean login(MembersBean members) {
		Connection conn = getConnection();
		BaseballDAO baseballDAO = BaseballDAO.getInstance();
		baseballDAO.setConnection(conn);
		boolean loginResult = false;
		String loginId = baseballDAO.selectLoginId(members);
		if(loginId != null) {
			loginResult = true;
		}
		close(conn);
		
		return loginResult;
	}

}
