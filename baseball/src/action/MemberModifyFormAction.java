package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BaseballDAO;
import vo.ActionForward;
import vo.LineupBean;
import vo.MembersBean;

public class MemberModifyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HttpSession session =request.getSession();
		String id = (String)session.getAttribute("id"); 
		
		MembersBean membersBean = null;
		membersBean = new MembersBean();
		
		id = request.getParameter("id");
  
		

		forward.setPath("/memberModify.jsp");
		return forward;
	}

}
