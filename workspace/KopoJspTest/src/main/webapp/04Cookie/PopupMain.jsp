<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String popupMode = "on"; // 팝업창 컨트롤 변수
	
// 들어온 쿠키 확인
Cookie[] cookies = request.getCookies();

if(cookies != null){
	for(Cookie c : cookies){
		String cookieName = c.getName();
		String cookieVal = c.getValue();
		
		// 쿠키 만들어서 보내기(이미 보낸 쿠키가 있다면 무시)
		if(cookieName.equals("PopupMode")){
			popupMode = cookieVal;
		}
	}
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키를 이용한 팝업 관리 ver 0.1</title>
<style>
    div#popup {
        position: absolute; top:100px; left:50px; color:yellow;  
        width:270px; height:100px; background-color:gray;
    }
    div#popup>div {
        position: relative; background-color:#ffffff; top:0px;
        border:1px solid gray; padding:10px; color:black;
    }
</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function() {
    $('#closeBtn').click(function() {
        $('#popup').hide();
        // 체크박스에 체크가 되었는지 확인
        var chkVal = $("input:checkbox[id=inactiveToday]:checked").val();
	    
        //ajax() 함수 비동기 처리
        $.ajax({
        	url : './PopupCookie.jsp',
        	type : 'get',
        	data : {inactiveToday : chkVal},
        	dataType :"text",
        	// 성공하면 새로고침 해라~
        	/* success : function(resData){
        		if(resData !='') location.reload();
        	} */
        });
    });
});
</script>
</head>
<body>
<h2>팝업 메인 페이지(ver 0.1)</h2>
<%
    for (int i = 1 ; i <= 10 ; i++) { 
        out.print("현재 팝업창은 " + popupMode + " 상태입니다.<br/>");
    }

    if (popupMode.equals("on")) {
%>
    <div id="popup">
        <h2 align="center">공지사항 팝업입니다.</h2>
        <div align="right"><form name="popFrm">
            <input type="checkbox" id="inactiveToday" value="1"> 
            하루 동안 열지 않음
            <input type="button" value="닫기" id="closeBtn"> 
        </form></div>
    </div>
<%
    }
%>
</body>
</html>