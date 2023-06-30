<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*, model1.BoardDTO,model1.BoardDAO" %>

<%
request.setCharacterEncoding("utf-8");
String num = request.getParameter("num");  // 일련번호 받기 

BoardDAO dao = new BoardDAO(application);  // DAO 생성 
dao.updateVisitCount(num);                 // 조회수 증가 
BoardDTO dto = dao.selectView(num);        // 게시물 가져오기 
dao.close();                               // DB 연결 해제
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>수정</title>
<style>
   	.fourth{
	  background: gold;
	  border-color: white;
	  color: black;
	  font-weight : bold;
	  background-image: linear-gradient(45deg, yellow 50%, transparent 50%);
	  background-position: 100%;
	  background-size: 400%;
	  transition: background 300ms ease-in-out;
	  border-radius: 5px;
	  height : 35px;
	}
	
	.fourth:hover {
	  background-position: 0;
	}
</style>
<script type="text/javascript">
function validateForm(form) {  // 폼 내용 검증
    if (form.title.value == "") {
        alert("제목을 입력하세요.");
        form.title.focus();
        return false;
    }
    if (form.content.value == "") {
        alert("내용을 입력하세요.");
        form.content.focus();
        return false;
    }
}
</script>
</head>
<body>
<jsp:include page="../Common/Link.jsp" />
<h2>회원제 게시판 - 수정 하기(Update)</h2>
<form name="writeFrm"  method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name="num" value="<%= num %>" />  <!-- 공통 링크 -->

    <table border="1" width="90%">
        <tr>
            <td>번호</td>
            <td><input type="hidden" name="num" value="<%= dto.getNum() %>"readonly><%= dto.getNum() %></td>
            <td>작성자</td>
            <td><%= dto.getName() %></td>
        </tr>
        <tr>
            <td>작성일</td>
            <td><%= dto.getPostdate() %></td>
            <td>조회수</td>
            <td><%= dto.getVisitcount() %></td>
        </tr>
        <tr>
            <td>제목</td>
            <td  colspan="3">
                <input type="text" name="title" value="<%= dto.getTitle() %>" style="width: 90%;" required/>
            </td>        
        </tr>
        <tr>
            <td>내용</td>
            <td  colspan="3" height="100">
                <textarea name="content" style="width: 90%; height: 100px;"><%= dto.getContent().replace("\r\n", "<br/>") %></textarea>
            </td>           
        </tr>
        <tr>
            <td colspan="4" align="center">
            <%
            if (session.getAttribute("UserId") != null
                && session.getAttribute("UserId").toString().equals(dto.getId())) {
            %>
                <button class="fourth" type="submit" formaction="EditProcess.jsp">수정하기</button>
                <button class="fourth" type="button" onclick="location.href='View.jsp?num=<%= dto.getNum() %>';">수정취소</button> 
            <%
            }
            %>
                <button class="fourth" type="button" onclick="location.href='List.jsp';">
                    목록 보기
                </button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>