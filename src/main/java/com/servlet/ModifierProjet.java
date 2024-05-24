package com.servlet;


import com.dao.DaoProjet;
import com.dao.Iprojet;
import com.model.Projet;
import com.util.DbConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/ModifierProjet")
public class ModifierProjet extends HttpServlet {
    private DaoProjet daoProjet;

    @Override
    public void init() throws ServletException {
        try {
            // Initialize the database connection using DbConnection
            Connection connection = DbConnection.getConnection();
            daoProjet = new DaoProjet(connection);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
    Projet projet = null;
    try {
        projet = daoProjet.rechbyid(id);
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    req.setAttribute("projet", projet);
    req.getRequestDispatcher("Projet/EditProjet.jsp").forward(req, resp);
}
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get project parameters from the form
        int idProjet = Integer.parseInt(req.getParameter("id"));
        String nomProjet = req.getParameter("nomProjet");
        String description = req.getParameter("description");
        String dateDebut = req.getParameter("dateDebut");
        String dateFin = req.getParameter("dateFin");
        double budget = Double.parseDouble(req.getParameter("budget"));

        // Create a new project object with the updated details
        Projet projet = new Projet();
        projet.setIdProjet(idProjet);
        projet.setNomProjet(nomProjet);
        projet.setDescription(description);
        projet.setDateDebut(java.sql.Date.valueOf(dateDebut));
        projet.setDateFin(java.sql.Date.valueOf(dateFin));
        projet.setBudget(budget);

        try {
            // Update the project in the database
            daoProjet.modifierProjet(projet);
        } catch (SQLException e) {
            throw new ServletException(e);
        }

        // Redirect to the project list page
        resp.sendRedirect("ServletAfficher"); // Update with the correct URL for your project list page
    }
}
