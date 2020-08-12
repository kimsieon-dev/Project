package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import dao.SajahuDAO;
import vo.SajahuBean;

public class SajahuSearchService {

	public int getSearchCount(SajahuBean search) {
		int listCount = 0;
		Connection conn = getConnection();
		SajahuDAO sajahuDAO = SajahuDAO.getInstance();
		sajahuDAO.setConnection(conn);
		listCount = sajahuDAO.selectSearchCount(search);
		close(conn);
		System.out.println("서치 리카 : " + listCount);
		return listCount;
	}

	public ArrayList<SajahuBean> noticeSearch(int page, int limit, SajahuBean search) {
		ArrayList<SajahuBean> sajahuSearch = null;
		Connection conn = getConnection();
		SajahuDAO sajahuDAO = SajahuDAO.getInstance();
		sajahuDAO.setConnection(conn);
		sajahuSearch = sajahuDAO.sajahuSearch(page, limit, search);
		close(conn);
		return sajahuSearch;
	}

}
