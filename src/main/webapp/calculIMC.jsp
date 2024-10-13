<%@ page language="java" contentType="text/html; charset=ISO-
8859-1"

pageEncoding="ISO-8859-1"%>
<%@ taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix= "fmt" uri= "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Résultat du Calcul IMC</title>
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
    <h2 style="color:white; text-align:center;">Résultats du calcul de l'IMC</h2>

    <% 
        double poids = Double.parseDouble(request.getParameter("poids"));
        double taille = Double.parseDouble(request.getParameter("taille"));
        int age = Integer.parseInt(request.getParameter("age"));
        String enceinte = request.getParameter("enceinte");
        String musclee = request.getParameter("musclee");

        
        double imc = poids * 10000 / (taille * taille);

        
        String interpretation = "";
        if (imc < 16) {
            interpretation = "Anorexie ou dénutrition";
        } else if (imc < 18.5) {
            interpretation = "Maigreur";
        } else if (imc < 25) {
            interpretation = "Corpulence normale";
        } else if (imc < 30) {
            interpretation = "Surpoids";
        } else if (imc < 35) {
            interpretation = "Obésité modérée (Classe 1)";
        } else if (imc < 40) {
            interpretation = "Obésité élevée (Classe 2)";
        } else {
            interpretation = "Obésité morbide ou massive";
        }
        
        request.setAttribute("imc", imc);
        request.setAttribute("interpretation", interpretation);
        request.setAttribute("age", age);
        request.setAttribute("enceinte", enceinte);
        request.setAttribute("musclee", musclee);
    %>

    <c:choose>
        <c:when test="${age < 18 || age > 65}">
            <p class="alert"><strong>Attention !</strong><br><br> Cet outil n'est pas adapté pour les personnes âgées de moins de 18 ans ou de plus de 65 ans.</p>
        </c:when>
        <c:when test="${enceinte == 'oui'}">
            <p class="alert"><strong>Attention !</strong> <br><br>Cet outil n'est pas adapté pour les femmes enceintes. Veuillez consulter un professionnel de la santé.</p>
        </c:when>
       
        <c:when test="${musclee == 'oui'}">
            <p class="alert"><strong>Attention !</strong> <br><br>Cet outil peut ne pas refléter correctement votre corpulence en raison de votre musculature. Veuillez consulter un professionnel de la santé pour un évaluation plus précise.</p>
        </c:when>
       
        <c:otherwise>
            <div style="margin: 5% 25%; background-color:#b5ea8c; padding: 10px; border-radius:15px; align-self:center;  text-align:center; font-size:20px;">
            	<p>Votre IMC est : <strong style="font-size:25px;">${imc}</strong></p>
            	<p>Interprétation de l'IMC selon l'OMS :<br><br> <strong style="font-size:25px;">${interpretation}</strong></p>
            </div>
        </c:otherwise>
    </c:choose>

</body>
</html>
