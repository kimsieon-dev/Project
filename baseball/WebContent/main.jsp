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
<script src="js/jquery.bxslider.min.js"></script>

<script>
$(document).ready(function(){
	
	var main = $('.bxslider').bxSlider({
		mode: 'fade',
		auto: true,		//자동으로 슬라이드
		controls : true,	//좌우 화살표	
		autoControls: true,	//stop,play
		pager:true,	//페이징
		pause: 3000,
		autoDelay: 0,	
		speed: 500,
		stopAutoOnclick:true
	});
  
	$(".bx-stop").click(function(){	// 중지버튼 눌렀을때
		main.stopAuto();
		$(".bx-stop").hide();
		$(".bx-start").show();
		return false;
	});

	$(".bx-start").click(function(){	//시작버튼 눌렀을때
	    main.startAuto();
		$(".bx-start").hide();
		$(".bx-stop").show();
		return false;
	});
	
	$(".bx-start").hide();	//onload시 시작버튼 숨김.
});
</script>


</head>
<body>
	<header>
		<h5><%=id.equals("") ? "" : id + "님 반갑습니다." %><span><%=id.equals("") ? "<a href='memberLogin.bd'>로그인</a>" : "<a href='logoutAction.bd'>로그아웃</a>" %></span><span><%=id.equals("") ? "<a href='joinForm.bd'>회원 가입</a>" : "<a href='memberDetail.bd'>회원 정보 변경</a>" %></span></h5>
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
			<ul class="bxslider">
				<li><img src="image/frist.jpg" /></li>
				<li><img src="image/slider2.jpg" /></li>
				<li><img src="image/slider4.jpg" /></li>
			</ul>
	</section>

	<footer></footer>
</body>
</html>