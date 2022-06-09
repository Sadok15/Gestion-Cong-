<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>0
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
<br>
<hr>

<table border="1" width="60%" style="border-width: 0px">
	<tr>
		<th style="border-style: none; border-width: medium">Date Debut Demande</th>
		<th style="border-style: none; border-width: medium">Titre</th>
		<th style="border-style: none; border-width: medium">durée</th>
		<th style="border-style: none; border-width: medium">Description</th>
		<th style="border-style: none; border-width: medium">Statut Demande</th>
	</tr>
	<tr>
		<td style="border-style: none; border-width: medium">&nbsp;</td>
		<td style="border-style: none; border-width: medium">&nbsp;</td>
		<td style="border-style: none; border-width: medium">&nbsp;</td>
	</tr>
	
	<c:forEach items="${requestScope.ListDemandes}" var="element">
	<tr>
		<td style="border-style: none; border-width: medium"><center>${element.date_debut}</center> </td>
		<td style="border-style: none; border-width: medium"><center>${element.titre} </center></td>
		<td style="border-style: none; border-width: medium"><center>${element.duree} </center></td>
		<td style="border-style: none; border-width: medium"><center>${element.description} </center></td>
		<c:if test="${sessionScope.role == 'E'}">
		<c:choose>
		<c:when test="${element.status == 'En Cours'}">
		<td style="border-style: none; border-width: medium;color:blue;"><center>${element.status} </center></td>
		</c:when>
		<c:when test="${element.status=='Valider'}">
		<td style="border-style: none; border-width: medium;color:lightgreen;"><center>${element.status} </center></td>
		</c:when>
		<c:when test="${element.status=='Réfuser'}">
		<td style="border-style: none; border-width: medium;color:red;"><center>${element.status} </center></td>
		</c:when>
		</c:choose>
		</c:if>
		<c:if test="${sessionScope.role == 'A'}">
		<td style="border-style: none; border-width: medium">
		<center>
			<form method="POST" action="">
				<p>
				<select size="1" name="status">
				<option value="${element.status}" selected>${element.status}</option>
				<option value="Valider">Valider</option>
				<option value="Réfuser">Réfuser</option>
				</select>
				<input name="id_demande" type="hidden" value="${element.id_demande}">
				<input type="submit" value="Submit" name="B1">
				</p>
			</form> 
		</center>
		</td>
		</c:if>
	</tr>
	</c:forEach>
</table>
	
</body>
</html>