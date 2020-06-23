package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.MemberLoginService;
import vo.ActionForward;
import vo.MembersBean;

public class MemberLoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		MembersBean members = new MembersBean();
		
		members.setMembers_id(request.getParameter("members_id"));
		members.setMembers_password(request.getParameter("members_password"));
		
		MemberLoginService memberLoginService = new MemberLoginService();
		boolean loginResult = memberLoginService.login(members);
		ActionForward forward = null;
		
		if(loginResult) {
			forward = new ActionForward();
			session.setAttribute("id", members.getMembers_id());
			forward.setRedirect(true);
			forward.setPath("main.jsp");
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		return forward;
	}

}
