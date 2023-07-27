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
 				width: 80%; 
 				border-collapse: collapse;
 				border-width: 2px;
 				cellspacing="1"
   			}
   			tr,td{border-width: 2px;text-align : left;}
   			textarea,input{
   				width: 98%;
   				margin: 4px;
   				margin-left:5px;
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
			span{
				display: block;
				text-align: center; 
				margin-left:5px;
			}
		</style>
	</head>
	<body>
		<c:if test="${empty oneSelectView}">
        <h2>해당 ID는 존재하지 않습니다 : ${param.id}</h2>
    	</c:if>

	    <c:if test="${not empty oneSelectView}">
			<!-- form 메소드 post 지정 -->
		<form method='post'>
		<table border='1'> <!-- 테이블 테두리 1 지정 -->
			<tr> <!-- 셀 스타일 지정,text 출력 -->
				<td bgcolor='#dde5ff' width= 15%><span>번호</span></td>
				<td colspan='3' align='left' width= 85%><input type='text' name='id' value='${oneSelectView.id}' readonly style="all: unset; margin-left:5px;"></td>
			</tr>
			<tr> <!-- 셀 스타일 지정,text 출력 -->
				<td bgcolor='#dde5ff' width= 15%><span>제목</span></td>
				<td colspan='3' align= 'left' width= 85%><input type='text' name='title' value='${oneSelectView.title}' readonly style="all: unset; margin-left:5px;"></td>
			</tr>
			<tr> <!-- 셀 스타일 지정,text 출력 -->
				<td bgcolor='#dde5ff' width= 15%><span>일자</span></td>
				<td colspan='3' align='left' width = 85%><input type='text' name='date' value='${oneSelectView.date}' readonly style="all: unset; margin-left:5px;"></td>
			</tr>
			<tr> <!-- 셀 스타일 지정,text 출력 -->
				<td bgcolor='#dde5ff' width= 15%><span>조회수</span></td>
				<td colspan='3' align='left' width = 85%><input type='text' name=viewcnt value='${oneSelectView.viewcnt}' readonly style="all: unset; margin-left:5px;"></td>
			</tr>
			<tr> <!-- 셀 스타일 지정,text 출력 -->
				<td bgcolor='#dde5ff' width= 15%><span>내용</span></td>
				<td colspan='3' align= 'left' width= 85%>
				<textarea name="content" readonly style="height: 300px; max-height: 300px; overflow-x: auto; overflow-y: scroll;resize: none;">${oneSelectView.content}</textarea>
				</td>
			</tr>
			
		</table>
		
		<table>
			<tr> <!-- 셀 스타일 지정,text 출력 -->
				<td colspan='2' style="text-align:right;">
				<!-- 버튼 클릭 시 freeboard_list.jsp 이동 -->
					<input class='fourth' type='submit' value='목록' formaction = 'list' 
						style="width: 60px; height: 30px; padding: 0px;font-weight: bold;"formnovalidate>
				<!-- 버튼 클릭 시 freeboard_update.jsp 이동 -->		
					<input class='fourth' type='submit' value='수정' formaction = 'update'
						style="width: 60px; height: 30px; padding: 0px;font-weight: bold;">
				<!-- 버튼 클릭 시 freeboard_delete.jsp 이동 -->
					<input class='fourth' type='submit' value='삭제' formaction = 'oneDelete?id=${oneSelectView.id}'
						style="width: 60px; height: 30px; padding: 0px;font-weight: bold;"formnovalidate>
				<!-- 버튼 클릭 시 freeboard_reinsert.jsp 이동 -->
					<input class='fourth' type='submit' value='댓글' formaction = ''
						style="width: 60px; height: 30px; padding: 0px;font-weight: bold;">
				</td>
			</tr>
		</table>
		</form>
	    </c:if>
		
	</body>
</html>