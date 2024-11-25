<%@page import="web.ImcModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%
ImcModel model = (ImcModel) request.getAttribute("ImcModel");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>IMC</title>
</head>
<body>
	<div>
		<form action="calculeIMC.do" method="post">
			Poids :<input type="text" name="poids" value="<%=model.getPoids()%>"> en kg <br>
			Taille :<input type="text" name="taille" value="<%=model.getTaille()%>"> en m<br>
			<input type="submit" value="Calculer">
		</form>
	</div>
	<p></p>
	<div>
		IMC :<%=model.getImc()%>
	</div>
</body>
</html>