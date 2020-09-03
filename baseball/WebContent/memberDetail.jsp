<%@page import="vo.LineupBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.MemberbbBean" %>
<%@ page import="dao.BaseballDAO" %>

 <%
 	MemberbbBean article = (MemberbbBean) request.getAttribute("article");
 
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
<link rel="stylesheet" href="css/memberDetail.css" />
<link rel="stylesheet" href="css/main.css" />

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
						<li><a href="starting.bd">선발</a></li>
						<li><a href="bullpen.bd">불펜</a></li>
						<li><a href="catcher.bd">포수</a></li>
						<li><a href="infielder.bd">내야수</a></li>
						<li><a href="outfielder.bd">외야수</a></li>
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
		<%=id.equals("") ? "<a href='memberJoin.bd'>회원 가입</a>" : "<a href='#'>회원 정보 변경</a>" %>
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
				<a href="#">회원 정보</a>
			</div>

			<div class="page2">
				<p>New Blue! New Lions!</p>
			</div>
		</div>
		
		<div class="toptitle">
			<p>회원 정보</p>
		</div>
	</section>
	
	
	<section>
			<div id="wrapper">

            <!-- content-->
            <div id="content">

                <!-- ID -->
                <div>
                    <h3 class="join_title">
                        <label for="memberbb_id">아이디</label>
                    </h3>
                    <span class="box int_id">
                        <%=article.getMemberbb_id() %>
                    </span>
                </div>
                
                <div>
                    <h3 class="join_title">
                        <label for="memberbb_password" type="password">비밀번호</label>
                    </h3>
                    <span class="box int_id">
                        <%=article.getMemberbb_password() %>
                    </span>
                </div>
                
                <div>
                    <h3 class="join_title">
                        <label for="memberbb_name">이름</label>
                    </h3>
                    <span class="box int_id">
                        <%=article.getMemberbb_name() %>
                    </span>
                </div>
                
                <div>
                    <h3 class="join_title">
                        <label for="memberbb_email">이메일</label>
                    </h3>
                    <span class="box int_id">
                        <%=article.getMemberbb_email() %>
                    </span>
                </div>
                
                <div>
                    <h3 class="join_title">
                        <label for="memberbb_birthday">생년월일</label>
                    </h3>
                    <span class="box int_id">
                        <%=article.getMemberbb_birthday() %>
                    </span>
                </div>

               
                <!-- JOIN BTN-->
                
                <div id="btn_group">
                    <button id="btn1" onclick="location.href='memberModifyForm.bd'">수정</button>
                    <button id="btn2" onclick="location.href='memberDelete.bd'">탈퇴</button>
                </div>
             

            </div> 
            <!-- content-->

        </div> 
        <!-- wrapper -->
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