package com.dao;

import com.model.Projet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class TestDaoProjet {

    public static void main(String[] args) {
        // Créer une connexion à la base de données
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GestionConstruction", "postgres", "admin")) {
            // Créer un DAO avec la connexion
            DaoProjet daoProjet = new DaoProjet(connection);

            int idProjetASupprimer = 1; // ID du projet à supprimer (assurez-vous que cet ID correspond à un projet existant dans la base de données)

            // Appeler la méthode supprimerProjet() du DAO pour supprimer le projet
            daoProjet.supprimerProjet(idProjetASupprimer);

            System.out.println("Le projet a été supprimé avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}