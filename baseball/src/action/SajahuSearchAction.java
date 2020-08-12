package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.SajahuSearchService;
import vo.ActionForward;
import vo.PageInfo2;
import vo.SajahuBean;

public class SajahuSearchAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		ArrayList<SajahuBean> sajahuSearch = new ArrayList<SajahuBean>();
		SajahuBean search = new SajahuBean();
		HttpSession session = request.getSession();
		
	  	int page = 1;
		int limit = 10;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		session.setAttribute("option", request.getParameter("sajahu_option"));
		session.setAttribute("search", request.getParameter("sajahu_search"));
		search.setSajahu_option(request.getParameter("sajahu_option"));
		search.setSajahu_search(request.getParameter("sajahu_search"));
		System.out.println(search.getSajahu_option());
		System.out.println(search.getSajahu_search());
		SajahuSearchService sajahuSearchService = new SajahuSearchService();
		int searchlistCount = sajahuSearchService.getSearchCount(search); //총 리스트 수를 받아옴.
		sajahuSearch = sajahuSearchService.noticeSearch(page, limit, search); //리스트를 받아옴.
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
		request.setAttribute("sajahuSearch", sajahuSearch);
		ActionForward forward= new ActionForward();
   		forward.setPath("sajahuSearch.bd");
   		return forward;
   		
	 }

}
