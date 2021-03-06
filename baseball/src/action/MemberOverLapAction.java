package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.MemberOverLapService;
import vo.ActionForward;
import vo.MemberbbBean;

public class MemberOverLapAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberbbBean memberbb = new MemberbbBean();
		HttpSession session = request.getSession();
   		boolean joinResult = false;
   		memberbb.setMemberbb_id(request.getParameter("check"));
   		
   		MemberOverLapService memberOverLapService = new MemberOverLapService();
   		joinResult = memberOverLapService.overlap(memberbb);
   		
   		ActionForward forward = null;
   		if(joinResult) {
   			session.setAttribute("check", joinResult);
	   	    forward = new ActionForward();
	   		forward.setRedirect(true);
	   		forward.setPath("memberoverlap.bd");
   		} else {
   			session.setAttribute("check", joinResult);
	   	    forward = new ActionForward();
	   		forward.setRedirect(true);
	   		forward.setPath("memberoverlap.bd");
   		}
   		return forward;
	}

}
