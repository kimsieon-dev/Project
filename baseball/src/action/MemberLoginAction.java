package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.MemberLoginService;
import vo.ActionForward;
import vo.MemberbbBean;

public class MemberLoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		MemberbbBean memberbb = new MemberbbBean();
		
		memberbb.setMemberbb_id(request.getParameter("memberbb_id"));
		memberbb.setMemberbb_password(request.getParameter("memberbb_password"));
		
		MemberLoginService memberLoginService = new MemberLoginService();
		boolean loginResult = memberLoginService.login(memberbb);
		ActionForward forward = null;
		
		if(loginResult) {
			forward = new ActionForward();
			session.setAttribute("id", memberbb.getMemberbb_id());
			forward.setRedirect(true);
			forward.setPath("main.bd");
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
