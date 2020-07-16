package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.LineupWriteProService;
import vo.ActionForward;
import vo.LineupBean;

public class LineupWriteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		LineupBean lineupBean = null;
		lineupBean = new LineupBean();
		
		lineupBean.setLineup_title(request.getParameter("lineup_title"));
		lineupBean.setLineup_pit(request.getParameter("lineup_pit"));
		lineupBean.setLineup_bat1(request.getParameter("lineup_bat1"));
		lineupBean.setLineup_bat2(request.getParameter("lineup_bat2"));
		lineupBean.setLineup_bat3(request.getParameter("lineup_bat3"));
		lineupBean.setLineup_bat4(request.getParameter("lineup_bat4"));
		lineupBean.setLineup_bat5(request.getParameter("lineup_bat5"));
		lineupBean.setLineup_bat6(request.getParameter("lineup_bat6"));
		lineupBean.setLineup_bat7(request.getParameter("lineup_bat7"));
		lineupBean.setLineup_bat8(request.getParameter("lineup_bat8"));
		lineupBean.setLineup_bat9(request.getParameter("lineup_bat9"));
		lineupBean.setMembers_id(request.getParameter("members_id"));
		
		LineupWriteProService lineupWriteProService = new LineupWriteProService();
		boolean isWriteSuccess = lineupWriteProService.registArticle(lineupBean);
		
		if(!isWriteSuccess){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패')");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
		else{
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("lineupList.bd");
		}

		return forward;
	}

}
