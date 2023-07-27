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
		  	a {text-decoration-line: none;  color: #696969;}
		  
		  	a:hover {
			  font-size : 16px;
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
		<table border = '1'>
        <tr>
            <td colspan=4><h2 style="margin-top:15px;">자유 게시판 목록</h2></td>
        </tr>
		<tr> <!-- 셀 스타일 지정,text 출력 -->
			<td bgcolor='#dde5ff' width = '70'><b>번호</b></td>
			<td bgcolor='#dde5ff'><b>제목</b></td>
			<td bgcolor='#dde5ff' width = '100'><b>등록일</b></td>
			<td bgcolor='#dde5ff' width = '70'><b>조회수</b></td>
		</tr>
        <c:if test="${empty list}">
            <tr style="border:none;"><td colspan='4'><h3 style="margin-top:15px;">게시글이 존재하지 않습니다.</h3></td></tr>
        </c:if>
        <c:if test="${not empty list}">
            <c:forEach var="boardItem" items="${list}">
                <tr class = 'tr' align = center>
                    <td align = center>${boardItem.id}</td> 
                    <td align = left><a href='oneSelectView?id=${boardItem.id}' style="margin-left:5px;">${boardItem.title}</a></td>
                    <td align = center>${boardItem.date}</td>
                    <td align = center>${boardItem.viewcnt}</td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
    
    <form method = 'post'>
	<table style="table-layout: fixed;">
        <tr align = center>   
       	<td align = 'right' width= 60px>
			<input class='fourth' type='submit' value='글쓰기' formaction = 'newInsert'
				style="width: 70px; height: 30px; padding: 0px;font-weight: bold;"> </td>
		</tr>
	</table>
	</form>
	</body>
</html>