<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.model.Tache" %>
<%@ page import="com.dao.DaoTache" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Tâches</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <h1 class="mt-5">Liste des Tâches</h1>
    <a href="ServletTache?action=ajouter" class="btn btn-primary btn-sm mb-3">Ajouter Tâche</a>
    <table class="table table-bordered mt-3">
        <thead>
        <tr>
            <th>ID</th>
            <th>Description</th>
            <th>Date de Début</th>
            <th>Date de Fin</th>
            <th>ID Projet</th>
            <th>Statut</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Tache> listTache = (List<Tache>) request.getAttribute("afficherList");
            if (listTache != null) {
                listTache.sort((t1, t2) -> Integer.compare(t1.getIdTache(), t2.getIdTache()));

                for (Tache tache : listTache) {
        %>
        <tr>
            <td><%= tache.getIdTache() %></td>
            <td><%= tache.getDescription() %></td>
            <td><%= tache.getDateDebut() %></td>
            <td><%= tache.getDateFin() %></td>
            <td><%= tache.getIdProjet() %></td>
            <td><%= tache.getStatut() %></td>
            <td>
                <a href="ServletTache?action=edit&id=<%= tache.getIdTache() %>" class="btn btn-warning btn-sm">Modifier</a>
                <a href="ServletTache?action=delete&id=<%= tache.getIdTache() %>" class="btn btn-danger btn-sm" onclick="return confirm('Êtes-vous sûr de vouloir supprimer cette tâche ?');">Supprimer</a>
            </td>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="7">Aucune tâche disponible.</td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
