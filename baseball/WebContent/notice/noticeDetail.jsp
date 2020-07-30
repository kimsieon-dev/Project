<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.NoticeBean" %>
<%@ page import="java.io.PrintWriter"%>
<%
	NoticeBean article = (NoticeBean) request.getAttribute("article");
	String nowPage = (String) request.getAttribute("page");

	request.setCharacterEncoding("UTF-8");
	String id = "";
	if (session.getAttribute("id") != null) {
	id = (String) session.getAttribute("id");
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/main.css" />
</head>
<body>
	<header>
		<h5><%=id.equals("") ? "" : id + "님 반갑습니다." %><span><%=id.equals("") ? "<a href='memberLogin.bd'>로그인</a>" : "<a href='logoutAction.jsp'>로그아웃</a>" %></span><span><%=id.equals("") ? "<a href='joinForm.jsp'>회원 가입</a>" : "<a href='logoutAction.jsp'>회원 정보 변경</a>" %></span></h5>
	</header>
	<nav>
		<div class="dropmenu">			
			<ul>
				<li id="logo1">
					<img src="image/logo1.jpg">
					<h1><a href="main.jsp">SAMSUNG LIONS</a></h1>
				</li>
				
			
				<li><a href="#">구단</a>
					<ul>
						<li><a href="club.bd">구단 소개</a></li>
						<li><a href="laPark.bd">GO 라팍!</a></li>
					</ul>
				</li>
				
				<li><a href="#">선수단</a>
					<ul>
						<li><a href="#">선발</a></li>
						<li><a href="#">불펜</a></li>
						<li><a href="#">내야수</a></li>
						<li><a href="#">외야수</a></li>
					</ul>
				</li>
				<li><a href="#">경기 정보</a>
					<ul>
						<li><a href="#">일정</a></li>
						<li><a href="lineupList.bd">라인업</a></li>
					</ul>
				</li>
				
				<li><a href="#">소통</a>
					<ul>
						<li><a href="sajahuList.bd">사자후</a></li>
						<li><a href="#">SNS</a></li>
						<li><a href="noticeList.bd">공지사항</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</nav>
	
	<section>
		<h2>글 내용 상세보기</h2>
		<article>
			제목 : 
			<%=article.getNotice_title() %>
		</article>
		
		<article>
			내용 :
			<%=article.getNotice_content() %>
		</article>
		
	</section>
	
	<section id="commandList">
	<%
		if(article.getNotice_id() != null && article.getNotice_id().equals(session.getAttribute("id"))) {
	%>
		<a href="noticeModifyForm.bd?notice_no=<%=article.getNotice_no() %>&page=<%=nowPage %>">[수정] </a>
		<a href="noticeDelete.bd?notice_no=<%=article.getNotice_no() %>&page=<%=nowPage %>">[삭제] </a>
		&nbsp;&nbsp;
	<%
		}
	%>
	<a href="noticeList.bd?page=<%=nowPage %>">[목록] </a> 
	
	</section>
</body>
</html>