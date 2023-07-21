<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<body>
	Hello, ${name}!	
	<br>
	sum: ${sum}
	<br>
	<c:forEach var="item" items="${myItems}">
		<tr>
			<td>${item}</td>
		</tr>
		<br>
	</c:forEach>
</body>
</html>