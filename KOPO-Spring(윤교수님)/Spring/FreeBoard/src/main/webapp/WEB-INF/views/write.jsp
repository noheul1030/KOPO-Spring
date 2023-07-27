<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
	<head>
		<style>
		table {
			margin-left: auto;
			margin-right: auto;
			text-align: center;
			width: 80%;
			border-collapse: collapse;
			cellspacing: 1;
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
		</style>
	</head>
	<body>
		<br><br><br><br>
		<form method="get">
			<table>
                <tr>
                    <td><h2>게시글이 등록 되었습니다.</h2></td>
                </tr>
				<tr height=80px>
					<td align='center'>
						<!-- form 태그를 사용하여 버튼을 감싸줌 --> <input class='fourth' type='submit'
						value='게시글 목록 확인하기' formaction='list'
						style="width: 150px; height: 30px; padding: 0px; font-weight: bold;">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>