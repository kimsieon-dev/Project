package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.MemberJoinService;
import vo.ActionForward;
import vo.MembersBean;

public class MemberJoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MembersBean members = new MembersBean();
		boolean joinResult = false;
		
		members.setMembers_id(request.getParameter("members_id"));
		members.setMembers_password(request.getParameter("members_password"));
		members.setMembers_name(request.getParameter("members_name"));
		members.setMembers_email(request.getParameter("members_email"));
		members.setMembers_birthday(request.getParameter("members_birthday"));
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