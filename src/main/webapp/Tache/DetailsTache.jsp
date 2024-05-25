<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Détails de la Tâche</title>
    <link rel="stylesheet" href="path/to/your/css/styles.css">
</head>
<body>
<h2>Détails de la Tâche</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <td>${tache.idTache}</td>
    </tr>
    <tr>
        <th>Description</th>
        <td>${tache.description}</td>
    </tr>
    <tr>
        <th>Date Début</th>
        <td>${tache.dateDebut}</td>
    </tr>
    <tr>
        <th>Date Fin</th>
        <td>${tache.dateFin}</td>
    </tr>
    <tr>
        <th>ID Projet</th>
        <td>${tache.idProjet}</td>
    </tr>
    <tr>
        <th>Statut</th>
        <td>${tache.statut}</td>
    </tr>
</table>
<a href="tache?action=list">Retour à la liste des tâches</a>
</body>
</html>
