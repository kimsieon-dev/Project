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
<link rel="stylesheet" href="css/club.css" />

<script src="js/jquery-3.5.1.min.js"></script>
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
				
				<li><a href="#">쇼핑몰</a></li>
				
		<div id="login">
		<%=id.equals("") ? "<a href='memberLogin.bd'>로그인</a>" : "<a href='memberLogoutAction.bd'>로그아웃</a>" %>&nbsp;&nbsp;|&nbsp;&nbsp;<%=id.equals("") ? "<a href='memberJoin.bd'>회원 가입</a>" : "<a href='memberDetail.bd'>회원 정보 변경</a>" %>
		<div>
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
				<img src="image/pngegg.png">
				<p>구단</p>
				<img src="image/pngegg.png">
				<p>구단소개</p>
			</div>

			<div class="page2">
				<p>New Blue! New Lions! 삼성 라이온즈를 소개합니다.</p>
			</div>
		</div>
	</section>
	<br />
	
	<section>
		<div class="intro">
			<h4>구단 소개</h4>
			<img src="image/club1.jpg" alt="-" />
		</div>
		<br />
	
	<div class="fri">
		<p><b>2020 '푸른 피의 사자군단'</b></p>
		<br />
		<p>삼성 라이온즈의 또 다른 야구가 시작됩니다.</p>
		<br />
		<br />
	</div>

		<div class="co">
			<p class="gLeft">
				삼성 라이온즈의 2020시즌 캐치프레이즈는 'New Blue! New Lions!'입니다.<br />
				<br /> '블루 블러드(Blue Bloods)'라는 말이 있습니다. 명가의 혈통이라는 뜻입니다. 바로 우리 삼성의
				블루입니다. 삼성 라이온즈가 명가인 이유는 매우 많습니다. 우리는 V8과 4번의 연속 통합우승을 비롯, 수많은 승리의
				기록을 가지고 있습니다. 프로야구가 창단한 1982년 이래 팀 이름과 연고지가 변치 않은 팀입니다. 또한 KBO 최초로
				육성 야구와 시스템 야구를 도입했으며, 메이저리그가 부럽지 않은 홈구장을 가지고 있습니다.
			</p>
			<p class="gLeft">
				하지만 우리가 진정한 명가인 이유는 따로 있습니다. 바로 팬 여러분입니다. 아버지에게서 아들로 대를 이어가고, 어린이
				회원에서 어른 팬으로 성장해온 팬심의 역사가 우리와 함께 합니다. 사자팬이라는 자부심을 가진 여러분이 계시기에 우리는
				당당하게 '최고의 명문구단'이라고 말할 수 있는 것입니다. 삼성 라이온즈 선수들과 팬 여러분의 피는 분명 '블루
				블러드(Blue Bloods)'입니다.<br />
				<br /> 지난 4년간 삼성 라이온즈는 초라한 성적표를 받아들었습니다. 5년 연속 정규시즌 1위와 4년 연속 통합우승에
				이은 성적표라 실망감은 더 클 수밖에 없습니다. 사자가 더 높이 뛰기 위해서는 다리를 더 많이 움츠린다고 합니다. 우리는
				그런 시기를 보낸 것입니다.
			</p>
			<p class="gLeft">
				사자가 자세를 바꾸면 밀림이 긴장합니다. 2020년은 자세를 바꾸어 도약하는 순간이며 New Lions로 태어나는
				시기입니다. 새로 태어난 사자는 옛날의 사자가 아닙니다. 단순히 다른 동물들을 제압하는 왕이 아니라 밀림 전체의 성장과
				발전을 고민하고 밀림에 기여하는 왕입니다. 그런 사자가 되기 위해 선수들은 구슬땀을 쏟고 프런트는 머리를 맞대겠습니다.
				도약을 위한 큰 그림을 그리고, 이를 위해 작은 것부터 챙기고 준비하겠습니다.<br />
				<br /> 성적은 뛰어오르고 플레이는 한 단계 높아지며 모든 면에서 모범이 되는 팀이 될 것입니다. 팬 여러분이
				자부심을 회복하는 한 해, 승리 그 이상의 감동을 주는 한 해를 만들겠습니다.
			</p>
		
			<p class="gRight"><b>
				2020년 삼성 라이온즈의 또 다른 야구역사가 시작됩니다.<br /><br />
				
				그 처음과 끝을 팬 여러분과
				함께하겠습니다.<br /><br />
				
				감사합니다. <br /><br />
				
				2020년 3월 삼성 라이온즈 구단주 겸 대표이사 원기찬</b></p>
		</div>

		<div class="fri">
			<p>
				<b>'사자군단'의 영광을 되찾기 위해 초심으로 새롭게 출발합니다.</b>
			</p>
			<br />
			<p>프런트가 한발 앞서 길을 닦아나가겠습니다.</p>
			<br /> <br />
		</div>
		
		<div class="co">
			<p class="gLeft">
				유난히 추웠던 겨울이 가고 봄이 오고 있습니다. 겨울 찬바람은 봄의 희망을 더 크게 키워냅니다.
				<br /><br />삼성 라이온즈는 새 봄을 맞는 심정으로 2020시즌을 시작하려 합니다.
			</p>
			<p class="gLeft">
				올 시즌은 여러 가지 변화가 많습니다. 새로 부임한 감독과 보강된 코칭스태프진, 외국인 선수 3인방을 비롯 삼성 라이온즈의 새 식구들이 잘 적응할 수 있도록 물심양면 지원을 아끼지 않겠습니다.
				<br /><br />트랙맨 도입 등 빅 데이터를 활용하고, 재충전과 교육을 더욱 보강하여 시스템 야구를 정착시키는 데 힘을 쏟겠습니다.
			</p>
			<p class="gLeft">
				국제대회라는 큰 행사가 팀의 전력에 보탬이 되도록 세심하게 챙기고, 시설을 정비한 대구 라팍과 경산볼파크 운영도 더욱 내실 있게 진행할 것입니다.
				<br /><br />지난 4년 동안 움츠렸던 사자가 다시 밀림의 왕으로 포효할 수 있게 최선을 다하겠습니다.
			</p>

			<p class="gRight"><b>
				팬 여러분, 지켜보고 응원해주십시오. 감사합니다.<br /><br />단장 홍준학
				</b></p>
		</div>
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