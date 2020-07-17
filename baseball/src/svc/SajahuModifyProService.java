package svc;

import java.sql.Connection;

import dao.SajahuDAO;

import static db.JdbcUtil.*;
import vo.SajahuBean;

public class SajahuModifyProService {

	public boolean modifyArticle(SajahuBean article) {
		boolean isModifySuccess = false;
		Connection conn = getConnection();
		SajahuDAO sajahuDAO = SajahuDAO.getInstance();
		sajahuDAO.setConnection(conn);
		int updateCount = sajahuDAO.updateArticle(article);
		
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
