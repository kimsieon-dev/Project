<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/login.css" />
</head>
<body>
			<form name="loginForm" action="memberLoginAction.bd" method="post">
	<div class="logo">
		<img src="image/logo4.jpg" />
	</div>
	
	<div class="inner_login">
		<div class="login_tistory">
				<fieldset>
					<div class="box_login">
						<div class="inp_text">
							<label for="member_id" class="screen_out">아이디</label> <input
								type="text" id="member_id" name="member_id" placeholder="ID"
								autocomplete="off" />
						</div>
						<div class="inp_text">
							<label for="member_password" class="screen_out">비밀번호</label> <input
								type="password" id="member_password" name="member_password"
								placeholder="Password" autocomplete="off" />
						</div>
					</div>
					<button type="submit" class="btn_login">로그인</button>
					<div class="login_append">
						<div class="inp_chk">
							<!-- 체크시 checked 추가 -->
							<input type="checkbox" id="keepLogin" class="inp_radio"
								name="keepLogin"> <label for="keepLogin" class="lab_g">
								<span class="img_top ico_check"></span> <span class="txt_lab">로그인
									상태 유지</span>
							</label>
						</div>
						<span class="txt_find"> <a href="memberJoin.bd"
							class="link_find">회원 가입</a>
						</span>
					</div>
				</fieldset>
		</div>
	</div>
			</form>
</body>
</html>