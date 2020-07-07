<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.MembersBean" %>
<%@ page import="dao.BaseballDAO" %>

 <%
	String id = (String)session.getAttribute("members_id");
  	BaseballDAO baseballdao = BaseballDAO.getInstance();
  	MembersBean membersBean = 
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/join.css" />

<script src="js/jquery-3.5.1.min.js"></script>
</head>
<body>
	<form name="memberModifyForm" action="memberModifyAction.bd" method="post">
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
                        <%=membersBean.getMembers_id() %>
                  
                    </span>
                    	<div class="check_font" id="id_check"></div>
                    <span class="error_next_box"></span>
                </div>

                <!-- PW1 -->
                <div>
                    <h3 class="join_title"><label for="members_password">비밀번호</label></h3>
                    <span class="box int_pass">
                        <input type="password" id="members_password" name="members_password" class="int" maxlength="20">
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
                
                <!-- BIRTH -->
                <div>
                    <h3 class="join_title"><label for="members_birthday">생년월일</label></h3>

                    <div id="bir_wrap">
                        <!-- BIRTH_YY -->
                        <div id="bir_yy">
                            <span class="box">
                                <input type="text" id="members_yy" name="members_yy" class="int" maxlength="4" placeholder="년(4자)">
                            </span>
                        </div>

                        <!-- BIRTH_MM -->
                        <div id="bir_mm">
                            <span class="box">
                                <select id="members_mm" name="members_mm" class="sel">
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
                                <input type="text" id="members_dd" name="members_dd" class="int" maxlength="2" placeholder="일">
                            </span>
                        </div>

                    </div>
                    <span class="error_next_box"></span>    
                </div>

                <!-- JOIN BTN-->
                <div class="btn_area">
                    <button type="button" id="btnJoin" onclick="javascript:joinForm.submit()" >
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