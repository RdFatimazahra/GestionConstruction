<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.model.Projet" %>
<%@ page import="com.dao.DaoProjet" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <title>Liste des projets</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<%
    // Initialize the DAO and retrieve the list of projects
    DaoProjet daoProjet = new DaoProjet();
    List<Projet> listeProjets = daoProjet.afficherListeProjets();
%>
<h1>Liste des projets</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Nom du Projet</th>
        <th>Description</th>
        <th>Date de Début</th>
        <th>Date de Fin</th>
        <th>Budget</th>
        <th>Actions</th> <!-- New column for actions -->
    </tr>
    </thead>
    <tbody>
    <%
        DaoProjet projetdao = new DaoProjet();
        List<Projet> listProjet = projetdao.afficherListeProjets();
        System.out.println("Number of projects: " + listProjet.size());
        for (Projet projet : listProjet){
    %>
    <tr>
        <td><%= projet.getIdProjet() %></td>
        <td><%= projet.getNomProjet() %></td>
        <td><%= projet.getDescription() %></td>
        <td><%= projet.getDateDebut() %></td>
        <td><%= projet.getDateFin() %></td>
        <td><%= projet.getBudget() %></td>
        <td>
            <!-- Edit button -->
            <a href="EditProjetServlet?idProjet=<%= projet.getIdProjet() %>">Edit</a>
            <!-- Delete button -->
            <a href="DeleteProjetServlet?idProjet=<%= projet.getIdProjet() %>">Delete</a>
        </td>
    </tr>
    <% } %>
    </tbody>
</table>
<!-- Add Project button -->
<a href="CreateProjet.jsp">Ajouter Projet</a>
</body>
</html>





