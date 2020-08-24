<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/join.css" />
<script src="js/jquery-3.5.1.min.js"></script>
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
                        <label for="memberbb_id">아이디</label>
                    </h3>
                    <span class="box int_id">
                        <input type="text" id="memberbb_id" name="memberbb_id" class="int" maxlength="20">
                    </span>
                    	<div class="check_font" id="id_check"></div>
                    <span class="error_next_box"></span>
                </div>

                <!-- PW1 -->
                <div>
                    <h3 class="join_title"><label for="memberbb_password">비밀번호</label></h3>
                    <span class="box int_pass">
                        <input type="password" id="memberbb_password" name="memberbb_password" class="int" maxlength="20">
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
                    <h3 class="join_title"><label for="memberbb_name">이름</label></h3>
                    <span class="box int_name">
                        <input type="text" id="memberbb_name" name="memberbb_name" class="int" maxlength="20">
                    </span>
                    <span class="error_next_box"></span>
                </div>

                <!-- BIRTH -->
               
                <!-- EMAIL -->
                <div>
                    <h3 class="join_title"><label for="memberbb_email">이메일</label></h3>
                    <span class="box int_email">
                        <input type="text" id="memberbb_email" name="memberbb_email" class="int" maxlength="100">
                    </span>
                    <span class="error_next_box">이메일 주소를 다시 확인해주세요.</span>    
                </div>
                
                <!-- BIRTH -->
                <div>
                    <h3 class="join_title"><label for="memberbb_birthday">생년월일</label></h3>

                    <div id="bir_wrap">
                        <!-- BIRTH_YY -->
                        <div id="bir_yy">
                            <span class="box">
                                <input type="text" id="memberbb_yy" name="memberbb_yy" class="int" maxlength="4" placeholder="년(4자)">
                            </span>
                        </div>

                        <!-- BIRTH_MM -->
                        <div id="bir_mm">
                            <span class="box">
                                <select id="memberbb_mm" name="memberbb_mm" class="sel">
                                    <option>월</option>
                                    <option value="01">1</option>
                                    <option value="02">2</option>
                                    <option value="03">3</option>
                                    <option value="04">4</option>
                                    <option value="05">5</option>
                                    <option value="06">6</option>
                                    <option value="07">7</option>
                                    <option value="08">8</option>
                                    <option value="09">9</option>                                    
                                    <option value="10">10</option>
                                    <option value="11">11</option>
                                    <option value="12">12</option>
                                </select>
                            </span>
                        </div>

                        <!-- BIRTH_DD -->
                        <div id="bir_dd">
                            <span class="box">
                                <input type="text" id="memberbb_dd" name="memberbb_dd" class="int" maxlength="2" placeholder="일">
                            </span>
                        </div>

                    </div>
                    <span class="error_next_box"></span>    
                </div>

                <!-- JOIN BTN-->
                <div id="btn_group">
                    <button type="button" id="btn" onclick="javascript:joinForm.submit()" >
                        <span>가입하기</span>
                    </button>
                </div>

            </div> 
            <!-- content-->

        </div> 
        <!-- wrapper -->
		 
	</form>
</body>
<script src="js/join.js"></script>
</html>