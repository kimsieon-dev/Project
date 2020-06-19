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
		
		members.setMember_id(request.getParameter("member_id"));
		members.setMember_password(request.getParameter("member_pw"));
		members.setMember_name(request.getParameter("member_name"));
		members.setMember_email(request.getParameter("member_email"));
		members.setMember_birthday(request.getParameter("member_birthday"));
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
			forward.setPath("memberLogin.do");
		}
		return forward;
	}
}