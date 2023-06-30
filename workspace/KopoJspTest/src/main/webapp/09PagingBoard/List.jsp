<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model1.BoardDTO,model1.BoardDAO, utils.BoardPage" %>
    
<%
BoardDAO dao = new BoardDAO(application); // DB연결

Map<String, Object> param = new HashMap<String, Object>();

String searchField = request.getParameter("searchField");
String searchWord = request.getParameter("searchWord");

if (searchWord != null){
	param.put("searchField", searchField);
	param.put("searchWord", searchWord);
}

int totalCount = dao.selectCount(param); // 게시물 수

/*페이지 처리 시작*/
// 전체 페이지 수 계산
int pageSize = Integer.parseInt(application.getInitParameter("POSTS_PER_PAGE"));
int blockPage = Integer.parseInt(application.getInitParameter("PAGES_PER_BLOCK"));
int totalPage = (int) Math.ceil( (double) totalCount / pageSize); // 전체 페이지 수
// 현재 페이지 확인
int pageNum = 1; // 디폴트 값
String pageTemp = request.getParameter("pageNum");
if (pageTemp !=null && !pageTemp.equals("")){
	pageNum = Integer.parseInt(pageTemp); // 요청받은 페이지 수로 수정
}

// 목록에 보여질 게시물 범위확인
int start = (pageNum - 1) * pageSize + 1;
int end = pageNum * pageSize;
param.put("start",start);
param.put("end",end);
/*페이지 처리 끝*/


//List<BoardDTO> boardLists = dao.selectList(param); // 게시물 목록
List<BoardDTO> boardLists = dao.selectListPage(param); // 게시물 목록

dao.close(); // DB 연결 닫기
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원제 게시판</title>
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
</head>
<body>
    <jsp:include page="../Common/Link.jsp" />  <!-- 공통 링크 -->

    <h2>목록 보기 : <%= pageNum %> / <%= totalPage %></h2>
    <!-- 검색폼 --> 
    <form method="get">  
    <table border="1" width="90%">
    <tr>
        <td align="center">
            <select name="searchField"> 
                <option value="title">제목</option> 
                <option value="content">내용</option>
            </select>
            <input type="text" name="searchWord" />
            <input class='fourth' type="submit" value="검색하기" />
        </td>
    </tr>   
    </table>
    </form>
    <!-- 게시물 목록 테이블(표) --> 
    <table border="1" width="90%">
        <!-- 각 칼럼의 이름 --> 
        <tr>
            <th width="10%">번호</th>
            <th width="50%">제목</th>
            <th width="15%">작성자</th>
            <th width="10%">조회수</th>
            <th width="15%">작성일</th>
        </tr>
        <!-- 목록의 내용 --> 
<%
if (boardLists.isEmpty()) {
    // 게시물이 하나도 없을 때 
%>
        <tr>
            <td colspan="5" align="center">
                * 등록된 게시물이 없습니다 *
            </td>
        </tr>
<%
}else {
    // 게시물이 있을 때 
    int virtualNum = 0;  // 화면상에서의 게시물 번호
    int countNum = 0;
    
    for (BoardDTO dto : boardLists)
    {
        //virtualNum = totalCount--;  // 전체 게시물 수에서 시작해 1씩 감소
        virtualNum = totalCount - (((pageNum - 1) * pageSize) + countNum++);
%>
        <tr align="center">
            <td><%= virtualNum %></td>  <!--게시물 번호-->
            <td align="left">  <!--제목(+ 하이퍼링크)-->
                <a href="View.jsp?num=<%= dto.getNum() %>"><%= dto.getTitle() %></a> 
            </td>
            <td align="center"><%= dto.getId() %></td>          <!--작성자 아이디-->
            <td align="center"><%= dto.getVisitcount() %></td>  <!--조회수-->
            <td align="center"><%= dto.getPostdate() %></td>    <!--작성일-->
        </tr>
<%
    }
}
%>
    </table>
    <!--목록 하단의 [글쓰기] 버튼-->
    <table border="1" width="90%">
        <tr align="center">
        	<td>
        		<%=BoardPage.pagingStr(totalCount, pageSize, blockPage, pageNum, request.getRequestURI()) %>
        	</td>
            <td><button class='fourth' type="button" onclick="location.href='Write.jsp';">글쓰기
                </button></td>
        </tr>
    </table>
</body>
</html>