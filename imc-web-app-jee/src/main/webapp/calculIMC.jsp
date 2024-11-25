<%@ page language="java" contentType="text/html; charset=ISO-
8859-1"

pageEncoding="ISO-8859-1"%>
<%@ taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix= "fmt" uri= "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>R�sultat du Calcul IMC</title>
    <style>
    	.alert{
    		margin: 5% 25%;
    		background-color:pink;
    		padding: 10px; border-radius:15px;
    		align-self:center;
    	    text-align:center;
    	    font-size:20px;
    	}
    	.alert strong{
    		color:red;
    		font-size:25px;
    	}
    </style>
</head>
<body style="background-color:#11150d;">
    <h2 style="color:white; text-align:center;">R�sultats du calcul de l'IMC</h2>

    <% 
        double poids = Double.parseDouble(request.getParameter("poids"));
        double taille = Double.parseDouble(request.getParameter("taille"));
        int age = Integer.parseInt(request.getParameter("age"));
        String enceinte = request.getParameter("enceinte");
        String musclee = request.getParameter("musclee");

        
        double imc = poids * 10000 / (taille * taille);

        
        String interpretation = "";
        if (imc < 16) {
            interpretation = "Anorexie ou d�nutrition";
        } else if (imc < 18.5) {
            interpretation = "Maigreur";
        } else if (imc < 25) {
            interpretation = "Corpulence normale";
        } else if (imc < 30) {
            interpretation = "Surpoids";
        } else if (imc < 35) {
            interpretation = "Ob�sit� mod�r�e (Classe 1)";
        } else if (imc < 40) {
            interpretation = "Ob�sit� �lev�e (Classe 2)";
        } else {
            interpretation = "Ob�sit� morbide ou massive";
        }
        
        request.setAttribute("imc", imc);
        request.setAttribute("interpretation", interpretation);
        request.setAttribute("age", age);
        request.setAttribute("enceinte", enceinte);
        request.setAttribute("musclee", musclee);
    %>

    <c:choose>
        <c:when test="${age < 18 || age > 65}">
            <p class="alert"><strong>Attention !</strong><br><br> Cet outil n'est pas adapt� pour les personnes �g�es de moins de 18 ans ou de plus de 65 ans.</p>
        </c:when>
        <c:when test="${enceinte == 'oui'}">
            <p class="alert"><strong>Attention !</strong> <br><br>Cet outil n'est pas adapt� pour les femmes enceintes. Veuillez consulter un professionnel de la sant�.</p>
        </c:when>
       
        <c:when test="${musclee == 'oui'}">
            <p class="alert"><strong>Attention !</strong> <br><br>Cet outil peut ne pas refl�ter correctement votre corpulence en raison de votre musculature. Veuillez consulter un professionnel de la sant� pour un �valuation plus pr�cise.</p>
        </c:when>
       
        <c:otherwise>
            <div style="margin: 5% 25%; background-color:#b5ea8c; padding: 10px; border-radius:15px; align-self:center;  text-align:center; font-size:20px;">
            	<p>Votre IMC est : <strong style="font-size:25px;">${imc}</strong></p>
            	<p>Interpr�tation de l'IMC selon l'OMS :<br><br> <strong style="font-size:25px;">${interpretation}</strong></p>
            </div>
        </c:otherwise>
    </c:choose>

</body>
</html>
