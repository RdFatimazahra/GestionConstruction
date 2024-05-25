<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter Tâche</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <h1 class="mt-5">Ajouter une Nouvelle Tâche</h1>
    <form action="ServletTache" method="post">
        <input type="hidden" name="action" value="insert">
        <div class="form-group">
            <label for="description">Description</label>
            <input type="text" class="form-control" id="description" name="description" required>
        </div>
        <div class="form-group">
            <label for="dateDebut">Date de Début</label>
            <input type="date" class="form-control" id="dateDebut" name="dateDebut" required>
        </div>
        <div class="form-group">
            <label for="dateFin">Date de Fin</label>
            <input type="date" class="form-control" id="dateFin" name="dateFin" required>
        </div>
        <div class="form-group">
            <label for="idProjet">ID Projet</label>
            <input type="number" class="form-control" id="idProjet" name="idProjet" required>
        </div>
        <div class="form-group">
            <label for="statut">Statut</label>
            <input type="text" class="form-control" id="statut" name="statut" required>
        </div>
        <button type="submit" class="btn btn-primary">Ajouter</button>
        <a href="ServletTache" class="btn btn-secondary">Annuler</a>
    </form>
</div>

</body>
</html>
