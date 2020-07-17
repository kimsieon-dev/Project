<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.SajahuBean" %>
<%
SajahuBean article = (SajahuBean) request.getAttribute("article");
	String nowPage = (String) request.getAttribute("page");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="sajahuModifyPro.bd" name="sajahuModifyForm">
	<input type="hidden" name="sajahu_no" value="<%=article.getSajahu_no() %>" />
	<input type="hidden" name="sajahu_id" value="<%=article.getSajahu_id() %>" />
    <table width="700" border="3" bordercolor="lightgray" align="center">
            <tr>
            <td id="title">
                제 목
            </td>
            <td>
                <input id="sajahu_title" name="sajahu_title" type="text" size="70" maxlength="100" value=""/>
            	
            </td>        
        </tr>
        
        <tr>
            <td id="title">
         내용
            </td>
            <td>
              <input id="sajahu_content" name="sajahu_content" type="text" size="70" maxlength="100" value=""/>         
            	
            </td>        
        </tr>
        
        <tr align="center" valign="middle">
            <td colspan="5">
                <input type="reset" value="작성취소" >
                <input type="submit" value="등록" >
                <input type="button" value="목록" >            
            </td>
        </tr>
    </table>    
    </form>
</body>
</html>