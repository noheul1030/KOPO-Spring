<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<style>
table {
	margin-left: auto;
	margin-right: auto;
	text-align: center;
	width: 80%;
	border-collapse: collapse;
	border-width: 2px;
	cellspacing
	="1"
}

tr, td {
	border-width: 2px;
	text-align: left;
}

textarea, input {
	width: 98%;
	margin: 4px;
	margin-left: 5px;
}

.fourth {
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

span {
	display: block;
	text-align: center;
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
			<table border='1'>
				<!-- 테이블 테두리 1 지정 -->
				<tr>
					<!-- 셀 스타일 지정,text 출력 -->
					<td bgcolor='#dde5ff' width=15%><span>번호</span></td>
					<td colspan='3' align='left' width=85%><input type='text'
						name='id' value='${oneSelectView.id}' readonly
						style="all: unset; margin-left: 5px;"></td>
				</tr>
				<tr>
					<!-- 셀 스타일 지정,text 출력 -->
					<td bgcolor='#dde5ff' width=15%><span>제목</span></td>
					<td colspan='3' align='left' width=85%><input type='text'
						name='title' value='${oneSelectView.title}' readonly
						style="all: unset; margin-left: 5px;"></td>
				</tr>
				<tr>
					<!-- 셀 스타일 지정,text 출력 -->
					<td bgcolor='#dde5ff' width=15%><span>일자</span></td>
					<td colspan='3' align='left' width=85%><input type='text'
						name='date' value='${oneSelectView.date}' readonly
						style="all: unset; margin-left: 5px;"></td>
				</tr>
				<tr>
					<!-- 셀 스타일 지정,text 출력 -->
					<td bgcolor='#dde5ff' width=15%><span>조회수</span></td>
					<td colspan='3' align='left' width=85%><input type='text'
						name=viewcnt value='${oneSelectView.viewcnt}' readonly
						style="all: unset; margin-left: 5px;"></td>
				</tr>
				<tr>
					<!-- 셀 스타일 지정,text 출력 -->
					<td bgcolor='#dde5ff' width=15%><span>내용</span></td>
					<td colspan='3' align='left' width=85%><textarea
							name="content" readonly
							style="height: 300px; max-height: 300px; overflow-x: auto; overflow-y: scroll; resize: none;">${oneSelectView.content}</textarea>
					</td>
				</tr>

			</table>

			<table>
				<tr>
					<!-- 셀 스타일 지정,text 출력 -->
					<td colspan='2' style="text-align: right;"><input
						class='fourth' type='submit' value='목록' formaction='list'
						style="width: 60px; height: 30px; padding: 0px; font-weight: bold;"
						formnovalidate> <input class='fourth' type='submit'
						value='수정' formaction='update'
						style="width: 60px; height: 30px; padding: 0px; font-weight: bold;">
						<input class='fourth' type='submit' value='삭제'
						formaction='oneDelete?id=${oneSelectView.id}'
						style="width: 60px; height: 30px; padding: 0px; font-weight: bold;"
						formnovalidate></td>
				</tr>
			</table>
		</form>
		
		<form method='post'>
			<table border='1'>
				<tr>
					<!-- 셀 스타일 지정,text 출력 -->
					<td bgcolor='#dde5ff' width= '50px'><span>댓글</span></td>
					<td align='left'><textarea name="recontent"
							style="height: 50px; max-height: 300px; overflow-x: auto; overflow-y: scroll; resize: none;"maxlength="100"></textarea>
						<input type="hidden" name="id" value="${oneSelectView.id}">
					</td>
					<td width='40'><input class='fourth' type='submit' value='작성'
						formaction='reply/writereply'
						style="width: 40px; height: 30px; padding: 0px; font-weight: bold;">
					</td>
				</tr>
			</table>
		</form>
		<form method='post'>
		<table border='1'>
			<tr>
				<!-- 셀 스타일 지정,text 출력 -->
				<td bgcolor='#dde5ff' width='50'><span>번호</span></td>
				<td bgcolor='#dde5ff'><span>댓글내용</span></td>
				<td bgcolor='#dde5ff' width='90'><span>등록일</span></td>
				<td bgcolor='#dde5ff' width='40'><span>삭제</span></td>
			</tr>
			<c:if test="${empty relist}">
				<tr style="border: none;">
					<td colspan='5' align='center'><span><h3 style="margin-top:15px;">댓글이 존재하지않습니다.</h3></span></td>
				</tr>
			</c:if>

			<c:if test="${not empty relist}">
				<c:forEach var="boardComment" items="${relist}">
					<tr class='tr' align=center>
						<td><input type='text' name='reid' value='${boardComment.reid}' readonly style="all: unset; margin-left:10px; width:30px;text-align:center;"></td>
						<td><span style=" margin-left:5px; text-align:left;">${boardComment.recontent}</span></td>
						<td><span>${boardComment.redate}</span></td>						
						<td align=center><input type='submit' value='삭제' formaction='reply/reDelete?id=${oneSelectView.id}&reid=${boardComment.reid}'
						style="width: 40px; height: 30px; padding: 0px; font-weight: bold;"></td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		</form>
	</c:if>

</body>
</html>