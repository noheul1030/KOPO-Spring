<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UseBean Form</title>
</head>
<body>
	<h2>액션태그로 폼값을 한번에 받기</h2>
	<form method='post' action='UseBeanAction.jsp;'>
		이름 : <input type='text' name='name' /><br>
		나이 : <input type='text' name='age' /><br>
		<input type='submit' value='전달'/>
	</form>
</body>
</html>