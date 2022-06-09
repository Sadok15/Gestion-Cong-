<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="./Inscription" method="POST">
<table border="1" width="60%" style="border-width: 0px">
	<tr>
		<td style="border-style: none; border-width: medium">Nom :</td>
		<td style="border-style: none; border-width: medium"><input type="text" name="nom"></td>
	</tr>
	<tr>
		<td style="border-style: none; border-width: medium">Prenom :</td>
		<td style="border-style: none; border-width: medium"><input type="text" name="prenom"></td>
	</tr>
	<tr>
		<td style="border-style: none; border-width: medium">Mail :</td>
		<td style="border-style: none; border-width: medium"><input type="text" name="mail"></td>
	</tr>
	<tr>
		<td style="border-style: none; border-width: medium">Mot de passe</td>
		<td style="border-style: none; border-width: medium"><input type="text" name="mdp"></td>
	</tr>
	
	<tr>
		<td style="border-style: none; border-width: medium">
		<input type="submit" value="S'inscrire" name="inscri" onclick="form.action='./Inscription'">
		</td>
	</tr>
</table>
</form>
<h3>${err}</h3>
<%
        request.getSession().removeAttribute("err");
%>
</body>
</html>