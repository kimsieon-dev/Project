package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.MemberDetailService;
import vo.ActionForward;
import vo.MembersBean;

public class MemberDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		id = request.getParameter("id");
		MemberDetailService memberDetailService = new MemberDetailService();
		MembersBean article = MemberDetailService.getArticle(id);
	   	request.setAttribute("article", article);
   		forward.setPath("/memberDetail.jsp");
   		return forward;
	}

}
