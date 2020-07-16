package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.LineupDetailService;
import vo.ActionForward;
import vo.LineupBean;

public class LineupModifyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		int lineup_no = Integer.parseInt(request.getParameter("lineup_no"));
		String nowPage = request.getParameter("page");
		LineupDetailService lineupDetailService = new LineupDetailService();	
		LineupBean article = LineupDetailService.getArticle(lineup_no);
	   	request.setAttribute("article", article);
	   	request.setAttribute("page", nowPage);
   		forward.setPath("/lineup/lineupModify.jsp");
   		return forward;
	}

}
