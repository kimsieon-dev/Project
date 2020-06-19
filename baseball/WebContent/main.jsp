<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<p>로그인</p>
	</header>
	<nav>
		<div class="dropmenu">
			<img src="image/logo.jpg" />
			<ul>
				<li><a href="#">구단</a>
					<ul>
						<li><a href="club.jsp">구단 소개</a></li>
						<li><a href="#">구장 소개</a></li>
						<li><a href="#">구장 오시는 길</a></li>
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