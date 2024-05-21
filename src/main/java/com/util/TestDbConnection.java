package com.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDbConnection {

    public static void main(String[] args) {
        try (Connection connection = DbConnection.getConnection()) {
            String query = "SELECT * FROM Projet";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    int idProjet = resultSet.getInt("IdProjet");
                    String nomProjet = resultSet.getString("NomProjet");
                    String description = resultSet.getString("description");
                    String dteDebut = resultSet.getString("DteDebut");
                    String dateFin = resultSet.getString("DateFin");
                    double budget = resultSet.getDouble("Budget");

                    System.out.println("ID Projet: " + idProjet);
                    System.out.println("Nom Projet: " + nomProjet);
                    System.out.println("Description: " + description);
                    System.out.println("Date Debut: " + dteDebut);
                    System.out.println("Date Fin: " + dateFin);
                    System.out.println("Budget: " + budget);
                    System.out.println("-----------");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error during database operation: " + e.getMessage());
        }
    }
}
