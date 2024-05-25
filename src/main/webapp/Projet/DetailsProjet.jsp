<!-- VoirDetailsProjet.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.model.Projet" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Détails du Projet</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <h1 class="mt-5">Détails du Projet</h1>
    <%
        Projet projet = (Projet) request.getAttribute("projet");
    %>
    <form>
        <div class="form-group">
            <label for="idProjet">ID du Projet :</label>
            <input type="text" class="form-control" id="idProjet" value="<%= projet.getIdProjet() %>" readonly>
        </div>
        <div class="form-group">
            <label for="nomProjet">Nom du Projet :</label>
            <input type="text" class="form-control" id="nomProjet" value="<%= projet.getNomProjet() %>" readonly>
        </div>
        <div class="form-group">
            <label for="description">Description :</label>
            <textarea class="form-control" id="description" readonly><%= projet.getDescription() %></textarea>
        </div>
        <div class="form-group">
            <label for="dateDebut">Date de Début :</label>
            <input type="text" class="form-control" id="dateDebut" value="<%= projet.getDateDebut() %>" readonly>
        </div>
        <div class="form-group">
            <label for="dateFin">Date de Fin :</label>
            <input type="text" class="form-control" id="dateFin" value="<%= projet.getDateFin() %>" readonly>
        </div>
        <div class="form-group">
            <label for="budget">Budget :</label>
            <input type="text" class="form-control" id="budget" value="<%= projet.getBudget() %>" readonly>
        </div>
    </form>
</div>
</body>
</html>