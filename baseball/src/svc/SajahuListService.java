package svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.SajahuDAO;
import vo.SajahuBean;

import static db.JdbcUtil.*;
public class SajahuListService {

	public int getListCount() {
		int listCount = 0;
		Connection conn = getConnection();
		SajahuDAO sajahuDAO = SajahuDAO.getInstance();
		sajahuDAO.setConnection(conn);
		listCount = sajahuDAO.selectListCount();
		close(conn);
		return listCount;
	}

	public ArrayList<SajahuBean> getsajahuList(int page, int limit) throws Exception {
		ArrayList<SajahuBean> sajahuList = null;
		Connection conn = getConnection();
		SajahuDAO sajahuDAO = SajahuDAO.getInstance();
		sajahuDAO.setConnection(conn);
		sajahuList = sajahuDAO.sajahuList(page,limit);
		close(conn);
		return sajahuList;
	}

	

}
