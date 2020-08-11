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
<link rel="stylesheet" href="css/join.css" />

<script src="js/jquery-3.5.1.min.js"></script>
</head>
<body>
		<div id="header">
			<img src="image/catch.jpg" id="logo">
		</div>
		
		
              	아이디 : <%=article.getMemberbb_id() %>
              	비밀번호 : <%=article.getMemberbb_password() %>
              	이름 : <%=article.getMemberbb_name() %>
              	이메일 : <%=article.getMemberbb_email() %>
              	생년월일 : <%=article.getMemberbb_birthday() %>
               
               
</body>
</html>