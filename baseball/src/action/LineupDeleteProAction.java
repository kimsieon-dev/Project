package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.LineupDeleteProService;
import vo.ActionForward;

public class LineupDeleteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		boolean isDeleteSuccess = false;
		int lineup_no =Integer.parseInt(request.getParameter("lineup_no"));
		String nowPage = request.getParameter("page");
		LineupDeleteProService lineupDeleteProService = new LineupDeleteProService();

			
			isDeleteSuccess = lineupDeleteProService.removeArticle(lineup_no);

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
				forward.setPath("lineupList.bd?page=" + nowPage);
			}


		return forward;
	}

}
