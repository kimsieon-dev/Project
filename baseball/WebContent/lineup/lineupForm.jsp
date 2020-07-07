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
<link rel="stylesheet" href="../css/lineupForm.css" />

<script src="js/jquery-3.5.1.min.js"></script>
</head>
<body>
	<form name="lineupForm" action="lineupFormAction.bd" method="post">

		<section>
			<div id="content">
				
				<div>
					<h3>
						<label for="lineup_title">제목</label>
					</h3>
					<span class="box int_id"> <input type="text" id="lineup_title" name="lineup_title"
						class="int">
					</span> <span class="error_next_box"></span>
				</div>
				
				<div>
					<h3>
						<label for="lineup_pit">선발 투수</label>
					</h3>
					<span class="box int_id"> <input type="text" id="lineup_pit" name="lineup_pit"
						class="int">
					</span> <span class="error_next_box"></span>
				</div>
				
				<div>
					<h3>
						<label for="lineup_bat1">1번 타자</label>
					</h3>
					<span class="box int_id"> <input type="text" id="lineup_bat1" name="lineup_bat1"
						class="int">
					</span> <span class="error_next_box"></span>
				</div>
				
				<div>
					<h3>
						<label for="lineup_bat2">2번 타자</label>
					</h3>
					<span class="box int_id"> <input type="text" id="lineup_bat2" name="lineup_bat2"
						class="int">
					</span> <span class="error_next_box"></span>
				</div>
				
				<div>
					<h3>
						<label for="lineup_bat3">3번 타자</label>
					</h3>
					<span class="box int_id"> <input type="text" id="lineup_bat3" name="lineup_bat3"
						class="int">
					</span> <span class="error_next_box"></span>
				</div>
				
				<div>
					<h3>
						<label for="lineup_bat4">4번 타자</label>
					</h3>
					<span class="box int_id"> <input type="text" id="lineup_bat4" name="lineup_bat4"
						class="int">
					</span> <span class="error_next_box"></span>
				</div>
				
				<div>
					<h3>
						<label for="lineup_bat5">5번 타자</label>
					</h3>
					<span class="box int_id"> <input type="text" id="lineup_bat5" name="lineup_bat5"
						class="int">
					</span> <span class="error_next_box"></span>
				</div>
				
				<div>
					<h3>
						<label for="lineup_bat6">6번 타자</label>
					</h3>
					<span class="box int_id"> <input type="text" id="lineup_bat6" name="lineup_bat6"
						class="int">
					</span> <span class="error_next_box"></span>
				</div>
				
				<div>
					<h3>
						<label for="lineup_bat7">7번 타자</label>
					</h3>
					<span class="box int_id"> <input type="text" id="lineup_bat7" name="lineup_bat7"
						class="int">
					</span> <span class="error_next_box"></span>
				</div>
				
				<div>
					<h3>
						<label for="lineup_bat8">8번 타자</label>
					</h3>
					<span class="box int_id"> <input type="text" id="lineup_bat8" name="lineup_bat8"
						class="int">
					</span> <span class="error_next_box"></span>
				</div>
				
				<div>
					<h3>
						<label for="lineup_bat9">9번 타자</label>
					</h3>
					<span class="box int_id"> <input type="text" id="lineup_bat9" name="lineup_bat9"
						class="int">
					</span> <span class="error_next_box"></span>
				</div>
				
				<div class="btn_area">
                    <button type="button" id="btnJoin">
                        <span>가입하기</span>
                    </button>
                </div>
				
			</div>
		</section>
	</form>
</body>
</html>