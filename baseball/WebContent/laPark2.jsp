<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/laPark2.css" />

<script src="js/jquery-3.5.1.min.js"></script>

</head>
<body>
	<header>
		<h5><a href="loginForm.jsp">로그인</a></h5>
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
								"mapWidth" : "800",
								"mapHeight" : "432"
							}).render();
						</script>

						
							<span>대구삼성라이온즈파크 찾아가는 길</span><br />
							<span>주변 대중교통(지하철, 버스)</span><br /><br />
							<table border="1">
								<tr>
									<th rowspan="2">지하철</th>
									<td>대공원</td>
									<td>도보</td>
							</table>
					</div>
				</li>

				<li id="tab2" class="btnCon"><input type="radio" name="tabmenu"
					id="tabmenu2"> <label for="tabmenu2">라팍 안내</label>
					<div class="tabCon">
						<img src="image/laparkin.jpg" style="margin-top: 40px;" />
					</div>
				</li>
				
				<li id="tab3" class="btnCon"><input type="radio" name="tabmenu"
					id="tabmenu3"> <label for="tabmenu3">라팍 매장 안내</label>
					<div class="tabCon">
						<img src="image/laparkin2.jpg" style="margin-top: 40px;" />
					</div>
				</li>
			</ul>
		</div>
	</section>
	

</body>
</html>