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
                        <label for="members_id">아이디</label>
                    </h3>
                    <span class="box int_id">
                        <input type="text" id="members_id" name="members_id" class="int" maxlength="20">
                    </span>
                    	<div class="check_font" id="id_check"></div>
                    <span class="error_next_box"></span>
                </div>

                <!-- PW1 -->
                <div>
                    <h3 class="join_title"><label for="members_password">비밀번호</label></h3>
                    <span class="box int_pass">
                        <input type="password" id="members_password" name="members_passowrd" class="int" maxlength="20">
                        <span id="alertTxt">사용불가</span>
                        <img src="image/m_icon_pass.png" id="pswd1_img1" class="pswdImg">
                    </span>
                    <span class="error_next_box"></span>
                </div>

                <!-- PW2 -->
                <div>
                    <h3 class="join_title"><label for="pswd2">비밀번호 재확인</label></h3>
                    <span class="box int_pass_check">
                        <input type="password" id="pswd2" class="int" maxlength="20">
                        <img src="image/m_icon_check_disable.png" id="pswd2_img1" class="pswdImg">
                    </span>
                    <span class="error_next_box"></span>
                </div>

                <!-- NAME -->
                <div>
                    <h3 class="join_title"><label for="members_name">이름</label></h3>
                    <span class="box int_name">
                        <input type="text" id="members_name" name="members_name" class="int" maxlength="20">
                    </span>
                    <span class="error_next_box"></span>
                </div>

                <!-- BIRTH -->
               
                <!-- EMAIL -->
                <div>
                    <h3 class="join_title"><label for="members_email">이메일</label></h3>
                    <span class="box int_email">
                        <input type="text" id="members_email" name="members_email" class="int" maxlength="100">
                    </span>
                    <span class="error_next_box">이메일 주소를 다시 확인해주세요.</span>    
                </div>
                
                <div>
                    <h3 class="join_title"><label for="members_birthday">생년월일</label></h3>
                    <span class="box">
                        <input type="text" id="members_birthday" name="members_birthday" class="int" maxlength="100">
                    </span>
                    <span class="error_next_box">생년월일을 다시 확인해주세요.</span>    
                </div>

     


                <!-- JOIN BTN-->
                <div class="btn_area">
                    <button type="button" id="btnJoin" >
                        <span>가입하기</span>
                    </button>
                </div>

                

            </div> 
            <!-- content-->

        </div> 
        <!-- wrapper -->
		 <script src="js/join.js"></script>
	</form>
</body>
</html>