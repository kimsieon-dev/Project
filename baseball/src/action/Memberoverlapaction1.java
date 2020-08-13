package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.MemberOverLapService;
import vo.MemberbbBean;

public class Memberoverlapaction1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		MemberbbBean memberbb = new MemberbbBean();
		memberbb.setMemberbb_id(request.getParameter("memberbb_id"));
		MemberOverLapService memberOverLapService = new MemberOverLapService();
		boolean overResult = memberOverLapService.overlap(memberbb);

		if (overResult) {
			overResult = true;
		}
	}
}

