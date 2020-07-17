package action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.SajahuWriteService;
import vo.ActionForward;
import vo.SajahuBean;

public class SajahuWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		SajahuBean sajahuBean = null;
		sajahuBean = new SajahuBean();
		HttpSession session = request.getSession();
		
		sajahuBean.setSajahu_id((String)session.getAttribute("id"));
		sajahuBean.setSajahu_title(request.getParameter("sajahu_title"));
		sajahuBean.setSajahu_content(request.getParameter("sajahu_content"));
		
		SajahuWriteService sajahuWriteService = new SajahuWriteService();
		boolean isWriteSuccess = sajahuWriteService.registArticle(sajahuBean);
		
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
			forward.setPath("sajahuList.bd");
		}

		return forward;
	}

}
