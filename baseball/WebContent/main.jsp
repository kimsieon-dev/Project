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
	<nav>
		<div class="dropmenu">			
			<ul>
				<li id="logo1">
					<img src="image/insignia1.svg.png">
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
				
		<div id="login">
		<%=id.equals("") ? "<a href='memberLogin.bd'>로그인</a>" : "<a href='memberLogoutAction.bd'>로그아웃</a>" %>&nbsp;&nbsp;|&nbsp;&nbsp;<%=id.equals("") ? "<a href='joinForm.bd'>회원 가입</a>" : "<a href='memberDetail.bd'>회원 정보 변경</a>" %>
		<div>
		</ul>
		</div>
		
		<div class="mainlogo">
			<img src="image/sllogo.png" />
		</div>
	</nav>

	<section>
			<ul class="bxslider">
				<li><img src="image/frist.jpg" /></li>
				<li><img src="image/slider2.jpg" /></li>
				<li><img src="image/slider4.jpg" /></li>
			</ul>
	</section>

	<footer>
		<div class="footer">
			<div class="foot">
				<div class="footlogo">
					<img src="image/footlogo1.png">
				</div>

				<div class="footsns">
					<img src="image/facebook.png"> 
					<img src="image/instagram.png">
					<img src="image/twitter1.png">
					<img src="image/youtube.png">
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