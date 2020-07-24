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
	<form method="post" action="lineupWriteAction.bd" name="lineupWrite">
    <table width="700" border="3" bordercolor="lightgray" align="center">
         <tr>
            <td id="title">
                제 목
            </td>
            <td>
                <input id="lineup_title" name="lineup_title" type="text" size="70" maxlength="100" value=""/>
            </td>        
        </tr>
        
         <tr>
            <td id="title">
         vs
            </td>
            <td>
                <input id="lineup_vs" name="lineup_vs" type="text" size="70" maxlength="100" value=""/>
            </td>        
        </tr>
        
        <tr>
            <td id="title">
        선발투수
            </td>
            <td>
              <input id="lineup_pit" name="lineup_pit" type="text" size="70" maxlength="100" value=""/>         
            </td>        
        </tr>
        
        <tr>
            <td id="title">
              1번타자
            </td>
            <td>
                <input id="lineup_bat1" name="lineup_bat1" type="text" size="70" maxlength="100" value=""/>                   
            </td>        
        </tr>
        
        
        <tr>
            <td id="title">
           2번타자
            </td>
            <td>
               <input id="lineup_bat2" name="lineup_bat2" type="text" size="70" maxlength="100" value=""/>         
            </td>        
        </tr>
        
        
        <tr>
            <td id="title">
              3번타자
            </td>
            <td>
                <input id="lineup_bat3" name="lineup_bat3" type="text" size="70" maxlength="100" value=""/>         
            </td>        
        </tr>
        
        
        <tr>
            <td id="title">
	4번타자
            </td>
            <td>
              <input id="lineup_bat4" name="lineup_bat4" type="text" size="70" maxlength="100" value=""/>         
            </td>        
        </tr>
        
        
        <tr>
            <td id="title">
              5번타자
            </td>
            <td>
                <input id="lineup_bat5" name="lineup_bat5" type="text" size="70" maxlength="100" value=""/>         
            </td>        
        </tr>
        
        
        <tr>
            <td id="title">
              6번타자
            </td>
            <td>
              <input id="lineup_bat6" name="lineup_bat6" type="text" size="70" maxlength="100" value=""/>         
            </td>        
        </tr>
        
        
        <tr>
            <td id="title">
             7번타자
            </td>
            <td>
              <input id="lineup_bat7" name="lineup_bat7" type="text" size="70" maxlength="100" value=""/>                   
            </td>        
        </tr>
        
        
        <tr>
            <td id="title">
              8번타자
            </td>
            <td>
               <input id="lineup_bat8" name="lineup_bat8" type="text" size="70" maxlength="100" value=""/>                   
            </td>        
        </tr>
        

        <tr>
            <td id="title">
             9번타자
            </td>
            <td>
               <input id="lineup_bat9" name="lineup_bat9" type="text" size="70" maxlength="100" value=""/>                 
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