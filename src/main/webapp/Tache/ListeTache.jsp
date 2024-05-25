<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des Tâches</title>
</head>
<body>
<h2>Liste des Tâches</h2>
<a href="taches?action=ajouter">Ajouter une Tâche</a>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Description</th>
        <th>Date Début</th>
        <th>Date Fin</th>
        <th>Projet</th>
        <th>Statut</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="tache" items="${taches}">
        <tr>
            <td>${tache.idTache}</td>
            <td>${tache.description}</td>
            <td>${tache.dateDebut}</td>
            <td>${tache.dateFin}</td>
            <td>${tache.idProjet}</td>
            <td>${tache.statut}</td>
            <td>
                <a href="taches?action=modifier&id=${tache.idTache}">Modifier</a>
                <a href="taches?action=supprimer&id=${tache.idTache}">Supprimer</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
