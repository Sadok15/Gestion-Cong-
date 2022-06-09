<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1" width="60%" style="border-width: 0px">
	<tr>
		<td style="border-style: none; border-width: medium"><a href="./list_demande"> List des demandes </a></td>
		<td style="border-style: none; border-width: medium"><a href="./Demande.jsp"> Demande congé     </a></td>
		<td style="border-style: none; border-width: medium"><a href="./Deconnexion"> Deconnexion       </a></td>
	</tr>
</table>
<br>
<form action="./DemandeForm" method="POST">
<h2> Demande congé</h2>
<table border="1" width="60%" style="border-width: 0px">
	<tr>
		<td style="border-style: none; border-width: medium">Titre :</td>
		<td style="border-style: none; border-width: medium"><input type="text" name="titre"></td>
	</tr>
	<tr>
		<td style="border-style: none; border-width: medium">Date début :</td>
		<td style="border-style: none; border-width: medium"> <input type="date" name="date_deb"></td>
	</tr>
	<tr>
		<td style="border-style: none; border-width: medium">Durée :</td>
		<td style="border-style: none; border-width: medium"><input type="number" name="duree"></td>
	</tr>
	<tr>
		<td style="border-style: none; border-width: medium">Description</td>
		<td style="border-style: none; border-width: medium"><textarea name="description" rows="5" cols="50"></textarea></td>
	</tr>
	<tr>
		<td style="border-style: none; border-width: medium">
		<input type="submit" value="Envoyer" name="envoyer">
		</td>
	</tr>
</table>
</form>
</body>
</html>