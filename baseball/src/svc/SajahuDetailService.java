package svc;

import java.sql.Connection;

import dao.SajahuDAO;
import vo.SajahuBean;

import static db.JdbcUtil.*;

public class SajahuDetailService {

	public static SajahuBean getArticle(int sajahu_no) throws Exception {
		SajahuBean article = null;
		Connection conn = getConnection();
		SajahuDAO sajahuDAO = SajahuDAO.getInstance();
		sajahuDAO.setConnection(conn);
		int updateCount = sajahuDAO.updateReadCount(sajahu_no);

		if(updateCount > 0){
			commit(conn);
		}
		else{
			rollback(conn);
		}
		
		article = sajahuDAO.selectArticle(sajahu_no);
		close(conn);
		return article;
	}

}
