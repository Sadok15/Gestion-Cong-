<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="./Login" method="POST">
<table border="1" width="60%" style="border-width: 0px">
	<tr>
		<td style="border-style: none; border-width: medium">Mail :</td>
		<td style="border-style: none; border-width: medium"><input type="text" name="mail"></td>
	</tr>
	<tr>
		<td style="border-style: none; border-width: medium">Mot de passe</td>
		<td style="border-style: none; border-width: medium"><input type="text" name="mdp"></td>
	</tr>
	<tr>
		<td style="border-style: none; border-width: medium"><input type="submit" value="Se connecter" name="connecter"></td>
		<td style="border-style: none; border-width: medium">
		<input type="submit" value="Inscription" name="insc" onclick="document.forms[0].action='Inscription.jsp';">
		</td>
	</tr>
</table>
</form>
<br>
<h3>${msg}</h3>
<%
        request.getSession().removeAttribute("msg");
%>
</body>
</html>