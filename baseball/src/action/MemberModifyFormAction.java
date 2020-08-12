package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BaseballDAO;
import svc.LineupDetailService;
import svc.MemberDetailService;
import vo.ActionForward;
import vo.LineupBean;
import vo.MemberbbBean;

public class MemberModifyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HttpSession session =request.getSession();
		String id = (String)session.getAttribute("id"); 
		MemberDetailService memberDetailService = new MemberDetailService();	
		MemberbbBean article = MemberDetailService.getArticle(id);
		MemberbbBean memberbb = new MemberbbBean();
		memberbb = new MemberbbBean();
		request.setAttribute("article", article);
		forward.setPath("/memberModify.jsp");
		return forward;
	}

}
