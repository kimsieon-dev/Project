package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.NoticeDetailService;
import svc.SajahuDetailService;
import vo.ActionForward;
import vo.NoticeBean;
import vo.SajahuBean;

public class NoticeModifyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		int notice_no = Integer.parseInt(request.getParameter("notice_no"));
		String nowPage = request.getParameter("page");
		NoticeDetailService noticeDetailService = new NoticeDetailService();	
		NoticeBean article = NoticeDetailService.getArticle(notice_no);
	   	request.setAttribute("article", article);
	   	request.setAttribute("page", nowPage);
   		forward.setPath("/notice/noticeModify.jsp");
   		return forward;
	}
}
