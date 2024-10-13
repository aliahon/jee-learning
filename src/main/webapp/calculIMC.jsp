<%@ page language="java" contentType="text/html; charset=ISO-
8859-1"

pageEncoding="ISO-8859-1"%>
<%@ taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix= "fmt" uri= "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Résultat du Calcul IMC</title>
</head>
<body>
    <h2>Résultats du calcul de l'IMC</h2>

    <% 
        // Récupérer les données du formulaire
        double poids = Double.parseDouble(request.getParameter("poids"));
        double taille = Double.parseDouble(request.getParameter("taille"));
        int age = Integer.parseInt(request.getParameter("age"));
        String enceinte = request.getParameter("enceinte");
        String musclee = request.getParameter("musclee");

        // Calcul de l'IMC
        double imc = poids * 10000 / (taille * taille);

        // Définir l'interprétation de l'IMC en fonction de l'OMS
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

        // Stocker les résultats dans les attributs de la requête
        request.setAttribute("imc", imc);
        request.setAttribute("interpretation", interpretation);
        request.setAttribute("age", age);
        request.setAttribute("enceinte", enceinte);
        request.setAttribute("musclee", musclee);
    %>

    <c:choose>
        <c:when test="${age < 18 || age > 65}">
            <p><strong>Attention !</strong> Cet outil n'est pas adapté pour les personnes âgées de moins de 18 ans ou de plus de 65 ans.</p>
        </c:when>
        <c:when test="${enceinte == 'oui'}">
            <p><strong>Attention !</strong> Cet outil n'est pas adapté pour les femmes enceintes. Veuillez consulter un professionnel de la santé.</p>
        </c:when>
       
        <c:when test="${musclee == 'oui'}">
            <p><strong>Attention !</strong> Cet outil peut ne pas refléter correctement votre corpulence en raison de votre musculature. Veuillez consulter un professionnel de la santé pour un évaluation plus précise.</p>
        </c:when>
       
        <c:otherwise>
            <p>Votre IMC est : <strong>${imc}</strong></p>
            <p>Interprétation de l'IMC selon l'OMS : <strong>${interpretation}</strong></p>
        </c:otherwise>
    </c:choose>

    <a href="index.html">Revenir au formulaire</a>
</body>
</html>
