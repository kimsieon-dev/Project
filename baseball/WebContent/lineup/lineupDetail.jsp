<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.LineupBean" %>
<%
	request.setCharacterEncoding("UTF-8");
	String id = "";
	if (session.getAttribute("id") != null) {
	id = (String) session.getAttribute("id");
	}
	
	LineupBean article = (LineupBean) request.getAttribute("article");
	String nowPage = (String) request.getAttribute("page");
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
						<li><a href="#">사자후</a></li>
						<li><a href="#">SNS</a></li>
						<li><a href="#">공지사항</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</nav>
	
	<section>
		<h2>글 내용 상세보기</h2>
		<article>
			제목 : 
			<%=article.getLineup_title() %>
		</article>
		
		<article>
			선발투수 :
			<%=article.getLineup_pit() %>
		</article>
		
		<article>
			1번 타자 :
			<%=article.getLineup_bat1() %>
		</article>
		
		<article>
			2번 타자 :
			<%=article.getLineup_bat2() %>
		</article>
		
		<article>
			3번 타자 :
			<%=article.getLineup_bat3() %>
		</article>
		
		<article>
			4번 타자 : 
			<%=article.getLineup_bat4() %>
		</article>
		
		<article>
			5번 타자 : 
			<%=article.getLineup_bat5() %>
		</article>
		
		<article>
			6번 타자 : 
			<%=article.getLineup_bat6() %>
		</article>
		
		<article>
			7번 타자 : 
			<%=article.getLineup_bat7() %>
		</article>
		
		<article>
			8번 타자 : 
			<%=article.getLineup_bat8() %>
		</article>
		
		<article>
			9번 타자 : 
			<%=article.getLineup_bat9() %>
		</article>
	</section>
	
	<section id="commandList">
		<a href="lineupModifyForm.bd?lineup_no=<%=article.getLineup_no() %>&page=<%=nowPage %>">[수정] </a>
		<a href="lineupDeleteForm.bd?lineup_no=<%=article.getLineup_no() %>&page=<%=nowPage %>">[삭제] </a>
		<a href="lineupList.bd?page=<%=nowPage %>">[목록] </a>
		&nbsp;&nbsp;
	</section>
</body>
</html>