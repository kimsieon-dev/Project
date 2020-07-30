<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="vo.PageInfo"%>
<%@page import="vo.SajahuBean"%>
<%@page import="java.util.*" %>
<%@ page import="java.io.PrintWriter"%>

<%
	request.setCharacterEncoding("UTF-8");
	String id = "";
	if(session.getAttribute("id") != null) {
		id = (String)session.getAttribute("id");
	}
	
	ArrayList<SajahuBean> sajahuList = (ArrayList<SajahuBean>) request.getAttribute("articleList");
	PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
	int listCount = pageInfo.getListCount();
	int nowPage = pageInfo.getPage();
	int maxPage = pageInfo.getMaxPage();
	int startPage = pageInfo.getStartPage();
	int endPage = pageInfo.getEndPage();
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" href="css/sajahu.css" />

<script src="js/jquery-3.5.1.min.js"></script>

</head>
<body>
	<header>
		<h5><%=id.equals("") ? "" : id + "님 반갑습니다." %><span><%=id.equals("") ? "<a href='loginForm.jsp'>로그인</a>" : "<a href='logoutAction.jsp'>로그아웃</a>" %></span><span><%=id.equals("") ? "<a href='joinForm.jsp'>회원 가입</a>" : "<a href='logoutAction.jsp'>회원 정보 변경</a>" %></span></h5>
	</header>
	<nav>
		<div class="dropmenu">			
			<ul>
				<li id="logo1">
					<img src="image/logo1.jpg">
					<h1><a href="main.bd">SAMSUNG LIONS</a></h1>
				</li>
				
			
				<li><a href="#">구단</a>
					<ul>
						<li><a href="club.bd">구단 소개</a></li>
						<li><a href="laPark2.bd">GO 라팍!</a></li>
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
		<h2>
			글 목록<input type="button" value="게시판글쓰기"
				onclick="location.href='sajahuWrite.bd'" />
		</h2>
		
		<%
			if(sajahuList != null && listCount > 0) {
		%>
		
		<table class="type09">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>날짜</th>
			</tr>
		</thead>
			
			<%
				for(int i = 0; i < sajahuList.size(); i++) {
			%>
			
			<tbody>
			<tr>
				<td><%=sajahuList.get(i).getSajahu_no() %></td>
				<td><a href="sajahuDetail.bd?sajahu_no=<%=sajahuList.get(i).getSajahu_no() %>&page=<%=nowPage %>"><%=sajahuList.get(i).getSajahu_title() %></a></td>
				<td><%=sajahuList.get(i).getSajahu_id() %>
				<td><%=sajahuList.get(i).getSajahu_readcount() %></td>
				<td><%=sajahuList.get(i).getSajahu_date() %></td>
			</tr>
			</tbody>
			<% 
				}
			%>
		</table>
		<%
			} else {
				out.println("<article id='emptyArea'>등록된 글이 없습니다.</article>");
			}
		%>
	</section>
	
	<%
	if(sajahuList != null && listCount > 0) {
	%>
	<section id="pageList">
		<%
		if(nowPage<=1) { 
			out.println("[이전]&nbsp;");
		} else {
			out.println("sajahuList.bd?page=" + (nowPage-1) + "'>[이전]</a>&nbsp;");
		}
		
		for(int a=startPage; a<=endPage; a++) {
			if(a==nowPage) {	
				out.println("["+a+"]");
			} else {
				out.println("<a href='sajahuList.bd?page=" + a + "'>[" + a + "]</a>&nbsp;");
			}
		}
		
		if(nowPage>=maxPage) {
			out.println("[다음]");		
		} else {
			out.println("<a href=sajahuList.bd?page=" + (nowPage+1) + "'>[다음]</a>");
		}
		%>
	</section>
	<%
	}
	%>
</body>
</html>