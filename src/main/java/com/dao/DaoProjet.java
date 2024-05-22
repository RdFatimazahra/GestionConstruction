package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.dao.Iprojet;
import com.model.Projet;

public class DaoProjet implements Iprojet{

    private Connection connection;

    public DaoProjet(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void ajouterProjet(Projet projet) throws SQLException {
        String query = "INSERT INTO Projet (NomProjet, Description, DateDebut, DateFin, Budget) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, projet.getNomProjet());
            stmt.setString(2, projet.getDescription());
            stmt.setDate(3, new java.sql.Date(projet.getDateDebut().getTime()));
            stmt.setDate(4, new java.sql.Date(projet.getDateFin().getTime()));
            stmt.setDouble(5, projet.getBudget());
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Projet> afficherListeProjets() throws SQLException {
        List<Projet> projets = new ArrayList<>();
        String query = "SELECT * FROM Projet";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Projet projet = new Projet(
                        rs.getInt("IdProjet"),
                        rs.getString("NomProjet"),
                        rs.getString("Description"),
                        rs.getDate("DateDebut"),
                        rs.getDate("DateFin"),
                        rs.getDouble("Budget")
                );
                projets.add(projet);
            }
        }
        return projets;
    }

    @Override
    public void modifierProjet(Projet projet) throws SQLException {
        String query = "UPDATE Projet SET NomProjet = ?, Description = ?, DateDebut = ?, DateFin = ?, Budget = ? WHERE IdProjet = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, projet.getNomProjet());
            stmt.setString(2, projet.getDescription());
            stmt.setDate(3, new java.sql.Date(projet.getDateDebut().getTime()));
            stmt.setDate(4, new java.sql.Date(projet.getDateFin().getTime()));
            stmt.setDouble(5, projet.getBudget());
            stmt.setInt(6, projet.getIdProjet());
            stmt.executeUpdate();
        }
    }

    @Override
    public void supprimerProjet(int idProjet) throws SQLException {
        String query = "DELETE FROM Projet WHERE IdProjet = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idProjet);
            stmt.executeUpdate();
        }
    }
}
