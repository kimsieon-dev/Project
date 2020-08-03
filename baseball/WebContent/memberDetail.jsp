<%@page import="vo.LineupBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.MembersBean" %>
<%@ page import="dao.BaseballDAO" %>

 <%
 	MembersBean article = (MembersBean) request.getAttribute("article");
 
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
		
		
              	아이디 : <%=article.getMembers_id() %>
              	비밀번호 : <%=article.getMembers_password() %>
              	이름 : <%=article.getMembers_name() %>
              	이메일 : <%=article.getMembers_email() %>
              	생년월일 : <%=article.getMembers_birthday() %>
               
               
</body>
</html>