package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.LineupDeleteProAction;
import action.LineupDetailAction;
import action.LineupListAction;
import action.LineupModifyFormAction;
import action.LineupModifyProAction;
import action.LineupSearchAction;
import action.LineupWriteAction;
import action.MemberDeleteAction;
import action.MemberDetailAction;
import action.MemberJoinAction;
import action.MemberLoginAction;
import action.MemberLogoutAction;
import action.MemberModifyFormAction;
import action.MemberModifyProAction;
import action.MemberOverLapAction;
import action.NoticeDeleteProAction;
import action.NoticeDetailAction;
import action.NoticeListAction;
import action.NoticeModifyFormAction;
import action.NoticeModifyProAction;
import action.NoticeSearchAction;
import action.NoticeWriteAction;
import action.SajahuDeleteProAction;
import action.SajahuDetailAction;
import action.SajahuListAction;
import action.SajahuModifyFormAction;
import action.SajahuModifyProAction;
import action.SajahuSearchAction;
import action.SajahuWriteAction;
import vo.ActionForward;


@WebServlet("*.bd")
public class BaseballController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;

		if (command.equals("/main.bd")) {
			forward = new ActionForward();
			forward.setPath("/main.jsp");
		} else if (command.equals("/club.bd")) {
			forward = new ActionForward();
			forward.setPath("/club.jsp");
		} else if (command.equals("/laPark2.bd")) {
			forward = new ActionForward();
			forward.setPath("/laPark2.jsp");
		} else if (command.equals("/sns.bd")) {
			forward = new ActionForward();
			forward.setPath("/sns.jsp");
		} else if (command.equals("/shop.bd")) {
			forward = new ActionForward();
			forward.setPath("/shop.jsp");
		} else if (command.equals("/view.bd")) {
			forward = new ActionForward();
			forward.setPath("/view.jsp");
		} else if (command.equals("/lineupWrite.bd")) {
			forward = new ActionForward();
			forward.setPath("/lineup/lineupWrite.jsp");
		} else if (command.equals("/lineupSearch.bd")) {
			forward = new ActionForward();
			forward.setPath("/lineup/lineupSearch.jsp");
		} else if (command.equals("/sajahuWrite.bd")) {
			forward = new ActionForward();
			forward.setPath("/sajahu/sajahuWrite.jsp");
		} else if (command.equals("/sajahuSearch.bd")) {
			forward = new ActionForward();
			forward.setPath("/sajahu/sajahuSearch.jsp");
		} else if (command.equals("/noticeWrite.bd")) {
			forward = new ActionForward();
			forward.setPath("/notice/noticeWrite.jsp");
		} else if (command.equals("/noticeSearch.bd")) {
			forward = new ActionForward();
			forward.setPath("/notice/noticeSearch.jsp");
		} else if (command.equals("/memberLogin.bd")) {
			forward = new ActionForward();
			forward.setPath("/loginForm.jsp");
		} else if (command.equals("/memberJoin.bd")) {
			forward = new ActionForward();
			forward.setPath("/joinForm.jsp");
		} else if(command.equals("/memberoverlap.bd")) {	// 실시간 확인 jsp
				forward = new ActionForward();
				forward.setPath("/Memberoverlap.jsp");
		} else if (command.equals("/memberLoginAction.bd")) {
			action = new MemberLoginAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/memberLogoutAction.bd")) { 
			action = new MemberLogoutAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/memberJoinAction.bd")) {
			action = new MemberJoinAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/memberoverlapaction.bd")) {	// 실시간 아이디 중복 Action
				action = new MemberOverLapAction();
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
		} else if (command.equals("/memberJoin.bd")) {
			forward = new ActionForward();
			forward.setPath("/joinForm.jsp");
		} else if (command.equals("/memberDetailAction.bd")) {
			action = new MemberDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/memberModifyForm.bd")) {
			action = new MemberModifyFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/memberModifyPro.bd")) {
			action = new MemberModifyProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/memberDelete.bd")) {
			action = new MemberDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 라인업 게시판
		} else if (command.equals("/lineupWriteAction.bd")) {
			action = new LineupWriteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/lineupList.bd")) {
			action = new LineupListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/lineupDetail.bd")) {
			action = new LineupDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/lineupModifyForm.bd")) {
			action = new LineupModifyFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/lineupModifyPro.bd")) {
			action = new LineupModifyProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/lineupSearchAction.bd")) {	// 게시판 글 검색 Action
				action = new LineupSearchAction();
				try { 
					forward = action.execute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
		} else if (command.equals("/lineupDelete.bd")) {
			String nowPage = request.getParameter("page");
			request.setAttribute("page", nowPage);
			int lineup_no = Integer.parseInt(request.getParameter("lineup_no"));
			request.setAttribute("lineup_no", lineup_no);
			forward = new ActionForward();
			forward.setPath("/lineup/lineupDelete.jsp");
		} else if (command.equals("/lineupDeletePro.bd")) {
			action = new LineupDeleteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		// 사자후 게시판
		} else if (command.equals("/sajahuWriteAction.bd")) {
			action = new SajahuWriteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/sajahuList.bd")) {
			action = new SajahuListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/sajahuDetail.bd")) {
			action = new SajahuDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/sajahuModifyForm.bd")) {
			action = new SajahuModifyFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/sajahuModifyPro.bd")) {
			action = new SajahuModifyProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/sajahuSearchAction.bd")) {	// 게시판 글 검색 Action
			action = new SajahuSearchAction();
			try { 
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/sajahuDelete.bd")) {
			String nowPage = request.getParameter("page");
			request.setAttribute("page", nowPage);
			int sajahu_no = Integer.parseInt(request.getParameter("sajahu_no"));
			request.setAttribute("sajahu_no", sajahu_no);
			forward = new ActionForward();
			forward.setPath("/sajahu/sajahuDelete.jsp");
		} else if (command.equals("/sajahuDeletePro.bd")) {
			action = new SajahuDeleteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
	 // 공지 게시판
	} else if (command.equals("/noticeWriteAction.bd")) {
		action = new NoticeWriteAction();
		try {
			forward = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} else if (command.equals("/noticeList.bd")) {
		action = new NoticeListAction();
		try {
			forward = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} else if (command.equals("/noticeDetail.bd")) {
		action = new NoticeDetailAction();
		try {
			forward = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} else if (command.equals("/noticeModifyForm.bd")) {
		action = new NoticeModifyFormAction();
		try {
			forward = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} else if (command.equals("/noticeModifyPro.bd")) {
		action = new NoticeModifyProAction();
		try {
			forward = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} else if(command.equals("/noticeSearchAction.bd")) {	// 게시판 글 검색 Action
		action = new NoticeSearchAction();
		try { 
			forward = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} else if (command.equals("/noticeDelete.bd")) {
		String nowPage = request.getParameter("page");
		request.setAttribute("page", nowPage);
		int notice_no = Integer.parseInt(request.getParameter("notice_no"));
		request.setAttribute("notice_no", notice_no);
		forward = new ActionForward();
		forward.setPath("/notice/noticeDelete.jsp");
	} else if (command.equals("/noticeDeletePro.bd")) {
		action = new NoticeDeleteProAction();
		try {
			forward = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
		
		
//		} else if (command.equals("/memberListAction.do")) {
//			action = new MemberListAction();
//			try {
//				forward = action.execute(request, response);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} else if (command.equals("/memberViewAction.do")) {
//			action = new MemberViewAction();
//			try {
//				forward = action.execute(request, response);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} else if (command.equals("/memberDeleteAction.do")) {
//			action = new MemberDeleteAction();
//			try {
//				forward = action.execute(request, response);
//			} catch (Exception e) {
//				e.printStackTrace();
//			} 
//		} else {
//			response.setContentType("text/html;charset=UTF-8");
//			PrintWriter out = response.getWriter();
//			out.println("<script>");
//			out.println("alert('잘못된 경로입니다.')");
//			out.println("</script>");
//			forward = new ActionForward();
//			forward.setPath("/loginForm.jsp");		
//		}

		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
				rd.forward(request, response);
			}
		}
	}
}
