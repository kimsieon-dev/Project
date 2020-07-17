package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.LineupModifyProService;
import vo.ActionForward;
import vo.LineupBean;

public class LineupModifyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		boolean isModifySuccess = false;
		int lineup_no = Integer.parseInt(request.getParameter("lineup_no"));
		LineupBean article = new LineupBean();
		LineupModifyProService lineupModifyProService = new LineupModifyProService();

		article.setLineup_no(lineup_no);
		article.setLineup_title(request.getParameter("lineup_title"));
		article.setLineup_pit(request.getParameter("lineup_pit"));
		article.setLineup_bat1(request.getParameter("lineup_bat1"));
		article.setLineup_bat2(request.getParameter("lineup_bat2"));
		article.setLineup_bat3(request.getParameter("lineup_bat3"));
		article.setLineup_bat4(request.getParameter("lineup_bat4"));
		article.setLineup_bat5(request.getParameter("lineup_bat5"));
		article.setLineup_bat6(request.getParameter("lineup_bat6"));
		article.setLineup_bat7(request.getParameter("lineup_bat7"));
		article.setLineup_bat8(request.getParameter("lineup_bat8"));
		article.setLineup_bat9(request.getParameter("lineup_bat9"));
		
		isModifySuccess = lineupModifyProService.modifyArticle(article);
	
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
				forward.setPath("lineupDetail.bd?lineup_no="+article.getLineup_no()+"&page=" + request.getParameter("page")); 
			}

		return forward;
	}

}
