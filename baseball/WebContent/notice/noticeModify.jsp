<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.NoticeBean" %>
<%
NoticeBean article = (NoticeBean) request.getAttribute("article");
	String nowPage = (String) request.getAttribute("page");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="noticeModifyPro.bd" name="noticeModifyForm">
	<input type="hidden" name="notice_no" value="<%=article.getNotice_no() %>" />
	<input type="hidden" name="notice_id" value="<%=article.getNotice_id() %>" />
    <table width="700" border="3" bordercolor="lightgray" align="center">
            <tr>
            <td id="title">
                제 목
            </td>
            <td>
                <input id="notice_title" name="notice_title" type="text" size="70" maxlength="100" value=""/>
            	
            </td>        
        </tr>
        
        <tr>
            <td id="title">
         내용
            </td>
            <td>
              <input id="notice_content" name="notice_content" type="text" size="70" maxlength="100" value=""/>         
            	
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