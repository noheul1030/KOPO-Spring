<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>New 게시글 등록</title>
</head>
<body>
    <h1>New 게시글 등록</h1>
    <form action="/newInsert" method="post"> <!-- method를 post로 변경 -->
        <label for="title">제목: </label>
        <input type="text" id="title" name="title" required>
        <br>
        <label for="content">내용: </label>
        <textarea id="content" name="content" rows="4" cols="50" required></textarea>
        <br>
        <input type="submit" value="등록">
    </form>
</body>
</html>
