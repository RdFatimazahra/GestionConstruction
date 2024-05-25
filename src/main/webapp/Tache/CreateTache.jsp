<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><c:out value="${tache != null ? 'Modifier' : 'Ajouter'}"/> Tâche</title>
</head>
<body>
<h2><c:out value="${tache != null ? 'Modifier' : 'Ajouter'}"/> Tâche</h2>
<form action="taches" method="post">
    <input type="hidden" name="action" value="${tache != null ? 'modifier' : 'ajouter'}"/>
    <input type="hidden" name="idTache" value="${tache != null ? tache.idTache : ''}"/>
    <div>
        <label>Description:</label>
        <input type="text" name="description" value="${tache != null ? tache.description : ''}" required/>
    </div>
    <div>
        <label>Date Début:</label>
        <input type="date" name="dateDebut" value="${tache != null ? tache.dateDebut : ''}" required/>
    </div>
    <div>
        <label>Date Fin:</label>
        <input type="date" name="dateFin" value="${tache != null ? tache.dateFin : ''}" required/>
    </div>
    <div>
        <label>Projet:</label>
        <input type="number" name="idProjet" value="${tache != null ? tache.idProjet : ''}" required/>
    </div>
    <div>
        <label>Statut:</label>
        <input type="text" name="statut" value="${tache != null ? tache.statut : ''}" required/>
    </div>
    <div>
        <button type="submit">Enregistrer</button>
    </div>
</form>
<a href="taches?action=afficher">Retour à la liste des Tâches</a>
</body>
</html>
