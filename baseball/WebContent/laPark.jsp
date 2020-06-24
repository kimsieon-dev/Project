<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/laPark.css" />

<script src="js/jquery-3.5.1.min.js"></script>

<script type="text/javascript">
    function oksSwitchTab(tab_id, tab_content) {
        // first of all we get all tab content blocks (I think the best way to get them
        // by class names)
        var x = document.getElementsByClassName("tabcontent");
        var i;
        for (i = 0; i < x.length; i++) {
            x[i].style.display = 'none'; // hide all tab content
        }
        document.getElementById(tab_content).style.display = 'block'; // display the content of the tab we need
 
        // now we get all tab menu items by class names (use the next code only if you need to highlight current tab)
        var x = document.getElementsByClassName("tabmenu");
        var i;
        for (i = 0; i < x.length; i++) {
            x[i].className = 'tabmenu';
        }
        document.getElementById(tab_id).className = 'tabmenu active';
    }
</script>
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
		<div class="map">
			<div id="daumRoughmapContainer1592962832062"
				class="root_daum_roughmap root_daum_roughmap_landing" style="float: left; margin-top: 20px; margin-bottom: 20px;" ></div>
			
			<script charset="UTF-8" class="daum_roughmap_loader_script" src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>
			<script charset="UTF-8">
				new daum.roughmap.Lander({
					"timestamp" : "1592962832062",
					"key" : "ywij",
					"mapWidth" : "640",
					"mapHeight" : "360"
				}).render();
			</script>
			</div>

		<div class="info">
			<div class="fri">
				<p>
					<b>대구삼성라이온즈파크 찾아가는 길</b>
				</p>
				<br />
				<p>
					<b>주변 대중교통 (지하철, 버스)</b>
				</p>
				<br />
				<br />
			</div>
		</div>

		<div>
			<ul class="tab-list">
				<li><a href="javascript:oksSwitchTab('tb_1', 'content_1');"
					id="tb_1" class="tabmenu active">Tab 1</a></li>
				<li><a href="javascript:oksSwitchTab('tb_2', 'content_2');"
					id="tb_2" class="tabmenu">Tab 2</a></li>
				<li><a href="javascript:oksSwitchTab('tb_3', 'content_3');"
					id="tb_3" class="tabmenu">Tab 3</a></li>
			</ul>
			<div id="content_1" class="tabcontent">content 1</div>
			<div id="content_2" class="tabcontent">content 2</div>
			<div id="content_3" class="tabcontent">content 3</div>
		</div>
	</section>
	

</body>
</html>