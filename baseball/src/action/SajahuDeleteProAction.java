package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.SajahuDeleteProService;
import vo.ActionForward;

public class SajahuDeleteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		boolean isDeleteSuccess = false;
		int sajahu_no =Integer.parseInt(request.getParameter("sajahu_no"));
		String nowPage = request.getParameter("page");
		SajahuDeleteProService sajahuDeleteProService = new SajahuDeleteProService();

			
			isDeleteSuccess = sajahuDeleteProService.removeArticle(sajahu_no);

			if(!isDeleteSuccess){
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('삭제실패');");
				out.println("history.back();");
				out.println("</script>");
				out.close();
			}
			else{
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("sajahuList.bd?page=" + nowPage);
			}


		return forward;
	}

}
