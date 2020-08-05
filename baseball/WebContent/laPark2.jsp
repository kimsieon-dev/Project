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
<link rel="stylesheet" href="css/laPark2.css" />

<script src="js/jquery-3.5.1.min.js"></script>

</head>
<body>
	<div id="wrap">
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
		<h4>GO 라팍!</h4>

		<div class="tabmenu">
			<ul>
				<li id="tab1" class="btnCon"><input type="radio" checked
					name="tabmenu" id="tabmenu1"> <label for="tabmenu1">라팍
						오시는 길</label>
					<div class="tabCon">
						<div id="daumRoughmapContainer1592962832062"
							class="root_daum_roughmap root_daum_roughmap_landing"
							style="float: left; margin-top: 40px; margin-bottom: 20px;"></div>

						<script charset="UTF-8" class="daum_roughmap_loader_script"
							src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>
						<script charset="UTF-8">
							new daum.roughmap.Lander({
								"timestamp" : "1592962832062",
								"key" : "ywij",
								"mapWidth" : "1280",
								"mapHeight" : "432"
							}).render();
						</script>

						
							<span>대구삼성라이온즈파크 찾아가는 길</span><br />
							<span>주변 대중교통(지하철, 버스)</span><br /><br />
							<table class="tra">
								<tr>
									<th rowspan="2" style="width: 70px;">지하철</th>
									<td style="width: 160px;">대공원</td>
									<td style="width: 60px;">2호선</td>
									<td style="text-align: left;">5번 출구</td>
									<td style="width: 80px;">도보 1분</td>
								</tr>
								
								<tr>
									<td>연호</td>
									<td>2호선</td>
									<td style="text-align: left;" >3번 출구</td>
									<td>도보 14분</td>
								</tr>
								
								<tr>
									<th rowspan="12">버스</th>
									<td rowspan="2">A.대공원역(5번 출구)</td>
									<td>간선</td>
									<td style="text-align: justify;">100, &nbsp;100-1, &nbsp;309, &nbsp;349, &nbsp;399, &nbsp;449, &nbsp;509, &nbsp;609, &nbsp;649, &nbsp;724, &nbsp;840, &nbsp;849-1, &nbsp;909, &nbsp;937, &nbsp;939, &nbsp;990, &nbsp;991</td>
									<td rowspan="2">도보 2분</td>
								</tr>
								
								<tr>
									<td>지선</td>
									<td style="text-align: left;">수성3</td>
								</tr>
								
								<tr>
									<td rowspan="2">B.대공원역(1번 출구)</td>
									<td>간선</td>
									<td style="text-align: left;">100,  100-1,  309,  349,  399,  449,  509,  609,  649,  724,  840,  849,  909,  937,  939,  990,  991</td>
									<td rowspan="2">도보 3분</td>
								</tr>
								
								<tr>
									<td>지선</td>
									<td style="text-align: left;">수성3-1</td>
								</tr>
								
								<tr>
									<td rowspan="2">C.연호지</td>
									<td>간선</td>
									<td style="text-align: left;">609, 939</td>
									<td rowspan="2">도보 9분</td>
								</tr>
								
								<tr>
									<td>지선</td>
									<td style="text-align: left;">수성3</td>
								</tr>
								
								<tr>
									<td>월드컵 삼거리</td>
									<td>간선</td>
									<td style="text-align: left;">100,  100-1,  309,  349,  399,  449,  509,  649,  724,  840,  849-1,  909,  937,  990,  991</td>
									<td>도보 10분</td>
								</tr>
								
								<tr>
									<td rowspan="2">연호동화훼단지1</td>
									<td>간선</td>
									<td style="text-align: left;">100,  100-1,  309,  349,  399,  449,  509,  609,  649,  724,  840,  849-1,  909,  937,  939,  990,  991</td>
									<td rowspan="2">도보 10분</td>
								</tr>
								
								<tr>
									<td>지선</td>
									<td style="text-align: left;">수성3</td>
								</tr>
								
								<tr>
									<td rowspan="2">월드컵삼거리앞</td>
									<td>간선</td>
									<td style="text-align: left;">100,  100-1,  309,  349,  399,  449,  509,  649,  724,  840,  849,  909,  937,  990,  991</td>
									<td rowspan="2">도보 10분</td>
								</tr>
							</table>
					</div>
				</li>

				<li id="tab2" class="btnCon"><input type="radio" name="tabmenu"
					id="tabmenu2"> <label for="tabmenu2">라팍 안내</label>
					<div class="tabCon">
						<img src="image/laparkinfo.jpg" style="margin-top: 40px;" />
					</div>
				</li>
				
				<li id="tab3" class="btnCon"><input type="radio" name="tabmenu"
					id="tabmenu3"> <label for="tabmenu3">라팍 매장 안내</label>
					<div class="tabCon">
						<img src="image/laparkinfo1.jpg" style="margin-top: 40px;" />
					</div>
				</li>
			</ul>
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
	</div>
</body>
</html>