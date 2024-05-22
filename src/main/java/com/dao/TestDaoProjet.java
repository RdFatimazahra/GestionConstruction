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

            // Appeler la méthode afficherListeProjets() du DAO pour obtenir tous les projets
            List<Projet> projets = daoProjet.afficherListeProjets();

            // Afficher les projets
            for (Projet projet : projets) {
                System.out.println("ID du projet : " + projet.getIdProjet());
                System.out.println("Nom du projet : " + projet.getNomProjet());
                System.out.println("Description : " + projet.getDescription());
                System.out.println("Date de début : " + projet.getDateDebut());
                System.out.println("Date de fin : " + projet.getDateFin());
                System.out.println("Budget : " + projet.getBudget());
                System.out.println("-----------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}