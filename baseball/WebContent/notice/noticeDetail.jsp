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
<link rel="stylesheet" href="css/noticeDetail.css" />
</head>
<body>
	<nav>
		<div class="dropmenu">			
			<ul>
				<li id="logo1">
					<a href="main.bd"><img src="image/insignia1.svg.png"></a>
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
						<li><a href="view.bd">일정</a></li>
						<li><a href="lineupList.bd">라인업</a></li>
					</ul>
				</li>
				
				<li><a href="#">소통</a>
					<ul>
						<li><a href="sajahuList.bd">사자후</a></li>
						<li><a href="sns.bd">SNS</a></li>
						<li><a href="noticeList.bd">공지사항</a></li>
					</ul>
				</li>
				
				<li><a href="shop.bd">쇼핑몰</a></li>
				
		<li id="login">
		<%=id.equals("") ? "<a href='memberLogin.bd'>로그인</a>" : "<a href='memberLogoutAction.bd'>로그아웃</a>" %>
		</li>
		
		<li id="login2">
		<%=id.equals("") ? "<a href='memberJoin.bd'>회원 가입</a>" : "<a href='memberDetail.bd'>회원 정보 변경</a>" %>
		</li>
		</ul>
		</div>
		
		<div class="mainlogo">
			<img src="image/sllogo.png" />
		</div>
	</nav>
	
	<section>
		<div class="page">
			<div class="page1">
				<img src="image/home_icon.png">
			 	<span>></span> 
			 	<a href="#">소통</a>
				<span>></span> 
				<a href="noticeList.bd">공지사항</a>
			</div>

			<div class="page2">
				<p>New Blue! New Lions! 삼성 라이온즈의 공지사항을 알려드립니다.</p>
			</div>
		</div>
		
		<div class="toptitle">
			<p>공지사항</p>
		</div>
		
		<div class="topview">
			<div class="topview_1">
				<p><%=article.getNotice_title() %></p>
			</div>
			
			<div class="topview_2">
				<p>작성자 <span><%=article.getNotice_id() %></span></p>
				<p>조회수 <span><%=article.getNotice_readcount() %></span></p>
				<p>날자 <span><%=article.getNotice_date() %></span></p>
			</div>
		</div>
		
		<article>
			<%=article.getNotice_content() %>
		</article>
		
	</section>
	
	<section id="commandList">
	<a href="noticeList.bd?page=<%=nowPage %>">[목록] </a> 
	<%
		if(article.getNotice_id() != null && article.getNotice_id().equals(session.getAttribute("id"))) {
	%>
		<a href="noticeDelete.bd?notice_no=<%=article.getNotice_no() %>&page=<%=nowPage %>">[삭제] </a>
		<a href="noticeModifyForm.bd?notice_no=<%=article.getNotice_no() %>&page=<%=nowPage %>">[수정] </a>
	<%
		}
	%>
	
	</section>
	
	<footer>
		<div class="footer">
			<div class="foot">
				<div class="footlogo">
					<img src="image/footlogo1.png">
				</div>

				<div class="footsns">
					<a href="https://www.facebook.com/snssamsunglions" target="_blank">
					<img src="image/facebook.png"> 
					</a>
					
					<a href="https://www.instagram.com/samsunglions_baseballclub/" target="_blank">
					<img src="image/instagram.png">
					</a>
					
					<a href="https://twitter.com/twittlions" target="_blank">
					<img src="image/twitter1.png">
					</a>
					
					<a href="https://www.youtube.com/channel/UCMWAku3a3h65QpLm63Jf2pw" target="_blank">
					<img src="image/youtube.png">
					</a>
				</div>
			</div>
			
			<div class="ex">
				<p>
				<span>개인정보처리방침</span>
				&nbsp;&nbsp;|&nbsp;&nbsp;
				<span>이용약관</span>
				&nbsp;&nbsp;|&nbsp;&nbsp;
				<span>이메일주소무단수집거부</span>
				</p>
			</div>
			
			<div class="ex2">
				<p>
				<span>삼성 라이온즈 구단주 겸 대표이사 : 원기찬&nbsp;&nbsp;|&nbsp;&nbsp;주소 : 대구 수성구 야구전설로 1 대구삼성라이온즈파크</span><br>
				<span>사업자번호 : 504-81-03755&nbsp;&nbsp;|&nbsp;&nbsp;개인정보취급방침관리자 : 삼성 라이온즈(lionscareers@samsung.com)&nbsp;&nbsp;|&nbsp;&nbsp;고객센터 전화번호 : 053-780-3300</span><br>
				<span>Copyright©Samsung Lions. All Right Reserved.</span>
				</p>
			</div>
			
		</div>
	</footer>
</body>
</html>