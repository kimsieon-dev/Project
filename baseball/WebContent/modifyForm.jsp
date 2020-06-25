<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	String id = "";
	if(session.getAttribute("id") != null) {
		id = (String)session.getAttribute("id");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" href="css/jquery.bxslider.css" />

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
					<h1><a href="main.jsp">SAMSUNG LIONS</a></h1>
				</li>
				
			
				<li><a href="#">구단</a>
					<ul>
						<li><a href="club.jsp">구단 소개</a></li>
						<li><a href="laPark.jsp">GO 라팍!</a></li>
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
						<li><a href="#">라인업</a></li>
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

	<footer></footer>
</body>
</html>