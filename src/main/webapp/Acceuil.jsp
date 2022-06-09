<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1" width="60%" style="border-width: 0px">
	<c:if test="${sessionScope.role == 'E'}">
	<tr>
		<td style="border-style: none; border-width: medium"><a href="./list_demande"> List des demandes </a></td>
		<td style="border-style: none; border-width: medium"><a href="./Demande.jsp"> Demande congé     </a></td>
		<td style="border-style: none; border-width: medium"><a href="./Deconnexion"> Deconnexion       </a></td>
	</tr>
	
	</c:if>
	<c:if test="${sessionScope.role == 'A'}">
	<tr>
		<td style="border-style: none; border-width: medium"><a href="./list_demande"> List des demandes </a></td>
		<td style="border-style: none; border-width: medium"><a href="./Deconnexion"> Deconnexion       </a></td>
	</tr>
	</c:if>
</table>
</body>
</html>