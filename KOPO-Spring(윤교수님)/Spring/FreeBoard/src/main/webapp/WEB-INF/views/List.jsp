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
		Hello, ${id}!	
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