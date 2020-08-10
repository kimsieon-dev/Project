package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.LineupSearchService;
import vo.ActionForward;
import vo.LineupBean;
import vo.PageInfo2;

public class LineupSearchAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		ArrayList<LineupBean> lineupSearch = new ArrayList<LineupBean>();
		LineupBean search = new LineupBean();
		HttpSession session = request.getSession();
		
	  	int page = 1;
		int limit = 10;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		session.setAttribute("option", request.getParameter("lineup_option"));
		session.setAttribute("search", request.getParameter("lineup_search"));
		search.setLineup_option(request.getParameter("lineup_option"));
		search.setLineup_search(request.getParameter("lineup_search"));
		System.out.println(search.getLineup_option());
		System.out.println(search.getLineup_search());
		LineupSearchService lineupSearchService = new LineupSearchService();
		int searchlistCount = lineupSearchService.getSearchCount(search); //총 리스트 수를 받아옴.
		lineupSearch = lineupSearchService.lineupSearch(page, limit, search); //리스트를 받아옴.
		//총 페이지 수.
   		int maxPage=(int)((double)searchlistCount / limit + 0.95); //0.95를 더해서 올림 처리.
   		//현재 페이지에 보여줄 시작 페이지 수(1, 11, 21 등...)
   		int startPage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
   		//현재 페이지에 보여줄 마지막 페이지 수.(10, 20, 30 등...)
   	    int endPage = startPage + 10 - 1;

   		if (endPage> maxPage) endPage = maxPage;
   		   		
   		PageInfo2 pageInfo2 = new PageInfo2();
   		pageInfo2.setEndPage(endPage);
   		pageInfo2.setListCount(searchlistCount);
		pageInfo2.setMaxPage(maxPage);
		pageInfo2.setPage(page);
		pageInfo2.setStartPage(startPage);	
		request.setAttribute("pageInfo", pageInfo2);
		request.setAttribute("lineupSearch", lineupSearch);
		ActionForward forward= new ActionForward();
   		forward.setPath("BoardSearch.jsp");
   		return forward;
   		
	 }

}
