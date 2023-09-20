<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
	<head>
		<style>
			table{
				margin-left: auto;
	  			margin-right: auto;
			  	text-align: center; 
 				width: 85%; 
 				border-collapse: collapse;
 				cellspacing:1;
   			}
   			.tr:hover{
   			 background-color : #f5f5f5;
   			}
    		.fourth{
			  background: gold;
			  border-color: white;
			  color: black;
			  background-image: linear-gradient(45deg, yellow 50%, transparent 50%);
			  background-position: 100%;
			  background-size: 400%;
			  transition: background 300ms ease-in-out;
			  border-radius: 5px;
			}
			
			.fourth:hover {
			  background-position: 0;
			}
		  	a {font-size : 18px; text-decoration-line: none;  color: #696969;}
		  
		  	a:hover {
			  font-size : 18px;
			  font-weight: bold;
			  background-position: 100%;
		  	  background-size: 400%;
			}			
			.custom-size {
        	font-size: 15px;
        	background-color: gold;
        	}
        	span{
        	 margin-left:5px;
        	}     			
		</style>
	</head>
	<body>
     	<form id="sortForm" method="get">
		<table>
	        <tr>
	            <td colspan=4><h2 style="margin-top:15px;">자유 게시판 목록</h2></td>
	        </tr>
	        <tr>
	        	<td width = '50'>
				        <select name="sort" style="height: 30px;">
				            <option value="id,asc" ${(param.sort == 'id,asc') ? 'selected' : ''}>번호 ▲</option>
				            <option value="id,desc" ${(param.sort == 'id,desc') ? 'selected' : ''}>번호 ▼</option>
				            <option value="date,asc" ${(param.sort == 'date,asc') ? 'selected' : ''}>등록일 ▲</option>
				            <option value="date,desc" ${(param.sort == 'date,desc') ? 'selected' : ''}>등록일 ▼</option>
				            <option value="viewcnt,asc" ${(param.sort == 'viewcnt,asc') ? 'selected' : ''}>조회수 ▲</option>
				            <option value="viewcnt,desc" ${(param.sort == 'viewcnt,desc') ? 'selected' : ''}>조회수 ▼</option>
				        </select>
				</td>
				<td align= left>
					<input type='text' name='search' value='${param.search}' placeholder='검색 키워드를 입력하세요' style="width: 95%; height: 30px; margin-left: 5px;"></td>
				<td width = '100'></td>
				<td align= right width = '70'>
					<input type="hidden" name="page" value="0">
				    <input class='fourth' type="submit" value="검색" style="width: 70px; height: 30px; padding: 0px;font-weight: bold;" formaction="list">
				</td>
	        </tr>
        </table>
        
        <br>
        
        <table border = '1'>
		<tr> <!-- 셀 스타일 지정,text 출력 -->
			<td bgcolor='#dde5ff' width = '80'><b>번호</b></td>
			<td bgcolor='#dde5ff'><b>제목</b></td>
			<td bgcolor='#dde5ff' width = '100'><b>등록일</b></td>
			<td bgcolor='#dde5ff' width = '70'><b>조회수</b></td>
		</tr>
        <c:if test="${empty list.content}">
            <tr style="border:none;"><td colspan='4'><h3 style="margin-top:15px;">게시글이 존재하지 않습니다.</h3></td></tr>
        </c:if>
        <c:if test="${not empty list.content}">
            <c:forEach var="boardItem" items="${list.content}">
                <tr class = 'tr' align = center>
                    <td align = center>${boardItem.id}</td> 
                    <td align = left><a href='oneSelectView?id=${boardItem.id}' style="margin-left:5px;">${boardItem.title}</a></td>
                    <td align = center>${boardItem.date}</td>
                    <td align = center>${boardItem.viewcnt}</td>
                </tr>
            </c:forEach>
        </c:if>
	    </table>
	    
	    <br>
	    
		<table style="table-layout: fixed;">
	        <tr align = center>   
	        <td width= 70px></td>
	        <td><!-- 이전 -->
				<c:choose>
					<c:when test="${list.first}">
						<a href="list?page=0"><<</a>
						<a href="list?page=0"><</a>
					</c:when>
					<c:otherwise>
						<a href="list?page=0"><<</a>
						<a href="list?page=${list.number-1}"><</a>
					</c:otherwise>
				</c:choose>
	
				<!-- 페이지 그룹 -->
				<c:forEach begin="${startBlockPage}" end="${endBlockPage}" var="i">
					<c:choose>
						<c:when test="${list.pageable.pageNumber+1 == i}">
							<b><a href="list?sort=${param.sort}&search=${param.search}&page=${i - 1}">${i}</a></b>
						</c:when>
						<c:otherwise>
							<a href="list?sort=${param.sort}&search=${param.search}&page=${i - 1}">${i}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				
				<!-- 다음 -->
				<c:choose>
					<c:when test="${list.last}">
						<a href="list?page=${list.totalPages-1}">></a>
						<a href="list?page=${list.totalPages-1}">>></a>
					</c:when>
					<c:otherwise>
						<a href="list?page=${list.number+1}">></a>
						<a href="list?page=${list.totalPages-1}">>></a>
					</c:otherwise>
				</c:choose>
			</td>
	       	<td align = 'right' width= 70px>
				<input class='fourth' type='submit' value='글쓰기' formaction = 'newInsert'
					style="width: 70px; height: 30px; padding: 0px;font-weight: bold;"> </td>
			</tr>
		</table>
		</form>
	
	</body>
</html>