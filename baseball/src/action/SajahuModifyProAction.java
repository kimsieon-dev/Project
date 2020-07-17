package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.SajahuModifyProService;
import vo.ActionForward;
import vo.SajahuBean;

public class SajahuModifyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		boolean isModifySuccess = false;
		int sajahu_no = Integer.parseInt(request.getParameter("sajahu_no"));
		SajahuBean article = new SajahuBean();
		SajahuModifyProService sajahuModifyProService = new SajahuModifyProService();

		article.setSajahu_no(sajahu_no);
		article.setSajahu_title(request.getParameter("sajahu_title"));
		article.setSajahu_content(request.getParameter("sajahu_content"));
		
		isModifySuccess = sajahuModifyProService.modifyArticle(article);
	
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
				forward.setPath("sajahuDetail.bd?sajahu_no="+article.getSajahu_no()+"&page=" + request.getParameter("page")); 
			}

		return forward;
	}

}
