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

            // Créer un nouveau projet pour le test
            Projet nouveauProjet = new Projet();
            nouveauProjet.setIdProjet(1); // Assurez-vous que l'ID correspond à un projet existant dans votre base de données
            nouveauProjet.setNomProjet("Nouveau Nom du Projet");
            nouveauProjet.setDescription("Nouvelle Description");
            nouveauProjet.setDateDebut(new Date());
            nouveauProjet.setDateFin(new Date());
            nouveauProjet.setBudget(1500.0);

            // Appeler la méthode modifierProjet() du DAO pour mettre à jour le projet
            daoProjet.modifierProjet(nouveauProjet);

            System.out.println("Le projet a été modifié avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}