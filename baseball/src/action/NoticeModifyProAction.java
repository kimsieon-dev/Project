package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.NoticeModifyProService;
import vo.ActionForward;
import vo.NoticeBean;

public class NoticeModifyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		boolean isModifySuccess = false;
		String nowPage = request.getParameter("page");
		int notice_no = Integer.parseInt(request.getParameter("notice_no"));
		NoticeBean article = new NoticeBean();
		NoticeModifyProService noticeModifyProService = new NoticeModifyProService();

		article.setNotice_no(notice_no);
		article.setNotice_title(request.getParameter("notice_title"));
		article.setNotice_content(request.getParameter("notice_content"));
		
		isModifySuccess = noticeModifyProService.modifyArticle(article);
	
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
				forward.setPath("noticeDetail.bd?notice_no="+article.getNotice_no()+"&page=" + request.getParameter("page")); 
			}

		return forward;
	}

}
