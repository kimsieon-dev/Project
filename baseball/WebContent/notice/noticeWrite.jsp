<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String userId = "";
	if(session.getAttribute("id") != null) {
		userId = (String)session.getAttribute("id");
	}
	
	if(session.getAttribute("id") == null) {
		out.println("<script>");
		out.println("alert('로그인이 필요한 서비스입니다.');");
		out.println("location.href='memberLogin.bd';");
		out.println("</script>");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="noticeWriteAction.bd" name="noticeWrite">
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