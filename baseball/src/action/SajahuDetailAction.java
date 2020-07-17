package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.SajahuDetailService;
import vo.ActionForward;
import vo.SajahuBean;


public class SajahuDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int sajahu_no = Integer.parseInt(request.getParameter("sajahu_no"));
		String page = request.getParameter("page");
		SajahuDetailService sajahuDetailService = new SajahuDetailService();
		SajahuBean article = sajahuDetailService.getArticle(sajahu_no);
		ActionForward forward = new ActionForward();
		request.setAttribute("page", page);
	   	request.setAttribute("article", article);
   		forward.setPath("/sajahu/sajahuDetail.jsp");
   		return forward;
	}

}
