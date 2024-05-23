package com.servlet;

import com.dao.DaoProjet;
import com.model.Projet;
import com.util.DbConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet("/home")
public class ServletProjet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if(path.equals("/home")) {
            req.getRequestDispatcher("Projet/CreateProjet.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nomProjet = request.getParameter("nomProjet");
        String description = request.getParameter("description");
        String dateDebutStr = request.getParameter("dateDebut");
        String dateFinStr = request.getParameter("dateFin");
        String budgetStr = request.getParameter("budget");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date dateDebut = dateFormat.parse(dateDebutStr);
            Date dateFin = dateFormat.parse(dateFinStr);
            double budget = Double.parseDouble(budgetStr);

            Projet projet = new Projet();
            projet.setNomProjet(nomProjet);
            projet.setDescription(description);
            projet.setDateDebut(dateDebut);
            projet.setDateFin(dateFin);
            projet.setBudget(budget);

            try (Connection connection = DbConnection.getConnection()) {
                DaoProjet daoProjet = new DaoProjet(connection);
                daoProjet.ajouterProjet(projet);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            response.sendRedirect("ServletAfficher");
        } catch (ParseException | NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect("error.html");
        }

        String path = request.getServletPath();
        if(path.equals("/home")) {
            request.getRequestDispatcher("Projet/CreateProjet.jsp").forward(request, response);
        }
    }
}
