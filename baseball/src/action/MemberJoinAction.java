package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.MemberJoinService;
import vo.ActionForward;
import vo.MemberbbBean;

public class MemberJoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberbbBean members = new MemberbbBean();
		boolean joinResult = false;
		
		members.setMemberbb_id(request.getParameter("memberbb_id"));
		members.setMemberbb_password(request.getParameter("memberbb_password"));
		members.setMemberbb_name(request.getParameter("memberbb_name"));
		members.setMemberbb_email(request.getParameter("memberbb_email"));
		members.setMemberbb_birthday(request.getParameter("memberbb_yy") + request.getParameter("memberbb_mm") + request.getParameter("memberbb_dd"));
		MemberJoinService memberJoinService = new MemberJoinService();
		joinResult = memberJoinService.joinMember(members);
		
		ActionForward forward = null;
		if(joinResult == false) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원등록실패')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("memberLogin.bd");
		}
		return forward;
	}
}