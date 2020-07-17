package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.LineupDetailService;
import svc.SajahuDetailService;
import vo.ActionForward;
import vo.LineupBean;
import vo.SajahuBean;

public class SajahuModifyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		int sajahu_no = Integer.parseInt(request.getParameter("sajahu_no"));
		String nowPage = request.getParameter("page");
		SajahuDetailService sajahuDetailService = new SajahuDetailService();	
		SajahuBean article = SajahuDetailService.getArticle(sajahu_no);
	   	request.setAttribute("article", article);
	   	request.setAttribute("page", nowPage);
   		forward.setPath("/sajahu/sajahuModify.jsp");
   		return forward;
	}

}
