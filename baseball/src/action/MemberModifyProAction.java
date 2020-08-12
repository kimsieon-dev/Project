package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.MemberModifyProService;
import vo.ActionForward;
import vo.MemberbbBean;

public class MemberModifyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		boolean isModifySuccess = false;
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		MemberbbBean article = new MemberbbBean();
		MemberModifyProService memberModifyProService = new MemberModifyProService();

		article.setMemberbb_id(id);
		article.setMemberbb_password(request.getParameter("memberbb_password"));
		article.setMemberbb_email(request.getParameter("memberbb_email"));
		
		isModifySuccess = MemberModifyProService.modifyArticle(article);
	
			if(!isModifySuccess){
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('수정실패');");
				out.println("history.back()");
				out.println("</script>");
				out.close();
			}
			else{
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("main.bd");
			}

		return forward;
	}

}
