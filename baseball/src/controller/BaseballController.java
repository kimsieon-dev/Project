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
import action.MemberJoinAction;
import action.MemberLoginAction;
import vo.ActionForward;


@WebServlet("*.bd")
public class BaseballController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;
		
		if (command.equals("/main.bd")) {
			forward = new ActionForward();
			forward.setPath("/main.jsp");
		} else if (command.equals("/memberLogin.bd")) {
			forward = new ActionForward();
			forward.setPath("/loginForm.jsp");
		} else if (command.equals("/memberJoin.bd")) {
			forward = new ActionForward();
			forward.setPath("/joinForm.jsp");
		} else if (command.equals("/memberLoginAction.bd")) {
			action = new MemberLoginAction();
			try {
				forward = action.execute(request, response);
		} catch (Exception e) {				e.printStackTrace();
			}
		} else if (command.equals("/memberJoinAction.bd")) {
			action = new MemberJoinAction();
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
