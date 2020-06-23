<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/join.css" />
</head>
<body>
		<form name="joinForm" action="memberJoinAction.bd" method="post">
			<div id="header">
				<img src="image/catch.jpg" id="logo">
			</div>
				  <!-- wrapper -->
        <div id="wrapper">

            <!-- content-->
            <div id="content">

                <!-- ID -->
                <div>
                    <h3 class="join_title">
                        <label for="member_id">아이디</label>
                    </h3>
                    <span class="box int_id">
                        <input type="text" name="member_id" id="member_id" class="int" autocomplete="off">
                    </span>
                    <span class="error_next_box"></span>
                </div>

                <!-- PW1 -->
                <div>
                    <h3 class="join_title"><label for="member_password">비밀번호</label></h3>
                    <span class="box int_pass">
                        <input type="text" name="member_password" id="member_password" class="int" autocomplete="off">
                        <span id="alertTxt">사용불가</span>
                        <img src="m_icon_pass.png" id="pswd1_img1" class="pswdImg">
                    </span>
                    <span class="error_next_box"></span>
                </div>

                <div>
                    <h3 class="join_title"><label for="member_email">이메일</label></h3>
                    <span class="box int_name">
                        <input type="text" name="member_email" id="member_email" class="int" autocomplete="off">
                    </span>
                    <span class="error_next_box"></span>
                </div>
                

                <!-- NAME -->
                <div>
                    <h3 class="join_title"><label for="name">이름</label></h3>
                    <span class="box int_name">
                        <input type="text" name="member_name" id="member_name" class="int" autocomplete="off">
                    </span>
                    <span class="error_next_box"></span>
                </div>
                
                <div>
                    <h3 class="join_title"><label for="member_birthday">생년월일</label></h3>
                    <span class="box int_name">
                        <input type="text" name="member_birthday" id="member_birthday" class="int" autocomplete="off">
                    </span>
                    <span class="error_next_box"></span>
                </div>

                


                <!-- JOIN BTN-->
                <div class="btn_area">
                    <button type="button" id="btnJoin" onclick="location.href='javascript:joinForm.submit()'">
                        <span>가입하기</span>
                    </button>
                </div>

                

            </div> 
            <!-- content-->

        </div> 
		</form>
</body>
</html>