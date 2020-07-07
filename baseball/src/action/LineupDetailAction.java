package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.LineupDetailService;
import vo.ActionForward;
import vo.LineupBean;

public class LineupDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int lineup_no = Integer.parseInt(request.getParameter("lineup_no"));
		String page = request.getParameter("page");
		LineupDetailService lineupDetailService = new LineupDetailService();
		LineupBean article = lineupDetailService.getArticle(lineup_no);
		ActionForward forward = new ActionForward();
		request.setAttribute("page", page);
	   	request.setAttribute("article", article);
   		forward.setPath("/lineup/lineupView.jsp");
   		return forward;
	}

}
