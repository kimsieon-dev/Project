<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.NoticeBean" %>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="dao.NoticeDAO" %>
<%	
	int notice_no = (int) request.getAttribute("notice_no");
	String nowPage = (String) request.getAttribute("page");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#passForm {
		width: 400px;
		margin: auto;
		border: 1px solid orange;
	}
	
	article {
		text-align: center;
	}
</style>
</head>
<body>
	<section id="passForm">
		<form name="deleteForm" action="noticeDeletePro.bd?notice_no=<%=notice_no %>" method="post" >
			<input type="hidden" name="page" value="<%=nowPage %>" />
			
			<article>				
				<input type="submit" value="삭제" />&nbsp;&nbsp;
				<input type="button" value="돌아가기" onclick="javascript:history.go(-1)" />
			</article>
			
		
		</form>
		
	</section>
</body>
</html>