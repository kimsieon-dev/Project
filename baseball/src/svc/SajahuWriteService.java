package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.SajahuDAO;
import vo.SajahuBean;

public class SajahuWriteService {

	public boolean registArticle(SajahuBean sajahuBean) throws Exception {
		boolean isWriteSuccess = false;
		Connection conn = getConnection();
		SajahuDAO sajahuDAO = SajahuDAO.getInstance();
		sajahuDAO.setConnection(conn);
		int insertCount = sajahuDAO.insertArticle(sajahuBean);
		
		if(insertCount > 0) {
			commit(conn);
			isWriteSuccess = true;
		} else {
			rollback(conn);
		}
		
		close(conn);
		return isWriteSuccess;
	}
}
