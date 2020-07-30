package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.NoticeWriteService;
import vo.ActionForward;
import vo.NoticeBean;

public class NoticeWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		NoticeBean noticeBean = null;
		noticeBean = new NoticeBean();
		HttpSession session = request.getSession();
		
		noticeBean.setNotice_id((String)session.getAttribute("id"));
		noticeBean.setNotice_title(request.getParameter("notice_title"));
		noticeBean.setNotice_content(request.getParameter("notice_content"));
		
		NoticeWriteService noticeWriteService = new NoticeWriteService();
		boolean isWriteSuccess = noticeWriteService.registArticle(noticeBean);
		
		if(!isWriteSuccess) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		} else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("noticeList.bd");
		}

		return forward;
	}

}
