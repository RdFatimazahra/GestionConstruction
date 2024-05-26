package com.dao;

import com.model.Tache;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoTache implements Itache {
    private Connection connection;

    public DaoTache(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void ajouterTache(Tache tache) throws SQLException {
        String query = "INSERT INTO Tache (Description, DateDebut, DateFin, IdProjet, Statut) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, tache.getDescription());
            stmt.setDate(2, new java.sql.Date(tache.getDateDebut().getTime()));
            stmt.setDate(3, new java.sql.Date(tache.getDateFin().getTime()));
            stmt.setInt(4, tache.getIdProjet());
            stmt.setString(5, tache.getStatut());
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Tache> afficherListeTaches() throws SQLException {
        List<Tache> taches = new ArrayList<>();
        String query = "SELECT * FROM Tache";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Tache tache = new Tache(
                        rs.getInt("IdTache"),
                        rs.getString("Description"),
                        rs.getDate("DateDebut"),
                        rs.getDate("DateFin"),
                        rs.getInt("IdProjet"),
                        rs.getString("Statut")
                );
                taches.add(tache);
            }
        }
        return taches;
    }

    @Override
    public void modifierTache(Tache tache) throws SQLException {
        String query = "UPDATE Tache SET Description = ?, DateDebut = ?, DateFin = ?, IdProjet = ?, Statut = ? WHERE IdTache = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, tache.getDescription());
            stmt.setDate(2, new java.sql.Date(tache.getDateDebut().getTime()));
            stmt.setDate(3, new java.sql.Date(tache.getDateFin().getTime()));
            stmt.setInt(4, tache.getIdProjet());
            stmt.setString(5, tache.getStatut());
            stmt.setInt(6, tache.getIdTache());
            stmt.executeUpdate();
        }
    }

    @Override
    public void supprimerTache(int idTache) throws SQLException {
        String query = "DELETE FROM Tache WHERE IdTache = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idTache);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Tache> afficherListeTachesByIdProjet(int idProjet) throws SQLException {
        List<Tache> taches = new ArrayList<>();
        String query = "SELECT * FROM Tache WHERE IdProjet = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idProjet);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Tache tache = new Tache(
                        rs.getInt("IdTache"),
                        rs.getString("Description"),
                        rs.getDate("DateDebut"),
                        rs.getDate("DateFin"),
                        rs.getInt("IdProjet"),
                        rs.getString("Statut")
                );
                taches.add(tache);
            }
        }
        return taches;
    }

    @Override
    // Ajout de la méthode searchById
    public Tache searchById(int id) throws SQLException {
        String query = "SELECT * FROM Tache WHERE IdTache = ?";
        Tache tache = null;
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                tache = new Tache();
                tache.setIdTache(rs.getInt("IdTache"));
                tache.setDescription(rs.getString("Description"));
                tache.setDateDebut(rs.getDate("DateDebut"));
                tache.setDateFin(rs.getDate("DateFin"));
                tache.setIdProjet(rs.getInt("IdProjet"));
                tache.setStatut(rs.getString("Statut"));
            }
        }
        return tache;
    }
}
