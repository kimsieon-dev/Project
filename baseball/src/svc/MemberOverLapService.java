package svc;

import java.sql.Connection;

import static db.JdbcUtil.*;
import dao.BaseballDAO;
import vo.MemberbbBean;

public class MemberOverLapService {

	public boolean overlap(MemberbbBean memberbb) {
		Connection conn = getConnection();
		BaseballDAO baseballDAO = BaseballDAO.getInstance();
		baseballDAO.setConnection(conn);
		boolean OverlapResult = false;
		int OverlapId = baseballDAO.OverLapId(memberbb);
		if(OverlapId == 0) {
			OverlapResult = true;	// 아이디 있음
		}
		close(conn);
		return OverlapResult;
	}

}
