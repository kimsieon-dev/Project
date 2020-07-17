package svc;

import java.sql.Connection;

import dao.SajahuDAO;

import static db.JdbcUtil.*;

public class SajahuDeleteProService {

	public boolean removeArticle(int sajahu_no) {
		boolean isRemoveSuccess = false;
		Connection conn = getConnection();
		SajahuDAO sajahuDAO = SajahuDAO.getInstance();
		sajahuDAO.setConnection(conn);
		int deleteCount = sajahuDAO.deleteArticle(sajahu_no);
		
		if(deleteCount > 0){
			commit(conn);
			isRemoveSuccess=true;
		}
		else{
			rollback(conn);
		}
		
		close(conn);
		return isRemoveSuccess;
	}

}
