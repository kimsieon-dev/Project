<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.SajahuBean" %>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="dao.SajahuDAO" %>
<%	
	int sajahu_no = (int) request.getAttribute("sajahu_no");
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
		<form name="deleteForm" action="sajahuDeletePro.bd?sajahu_no=<%=sajahu_no %>" method="post" >
			<input type="hidden" name="page" value="<%=nowPage %>" />
			
			<article>				
				<input type="submit" value="삭제" />&nbsp;&nbsp;
				<input type="button" value="돌아가기" onclick="javascript:history.go(-1)" />
			</article>
			
		
		</form>
		
	</section>
</body>
</html>