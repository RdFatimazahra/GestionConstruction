package com.dao;

import com.model.Projet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

public class TestDaoProjet {

    public static void main(String[] args) {
        // Créer une connexion à la base de données
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GestionConstruction", "postgres", "admin")) {
            // Créer un DAO avec la connexion
            DaoProjet daoProjet = new DaoProjet(connection);

            // Créer un nouveau projet pour le test
            Projet nouveauProjet = new Projet();
            nouveauProjet.setNomProjet("Projet de test");
            nouveauProjet.setDescription("Description du projet de test");
            nouveauProjet.setDateDebut(new Date());
            nouveauProjet.setDateFin(new Date());
            nouveauProjet.setBudget(1000.0);

            // Appeler la méthode ajouterProjet() du DAO
            daoProjet.ajouterProjet(nouveauProjet);

            System.out.println("Le projet a été ajouté avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
