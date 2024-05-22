package org.example.gestionconstruction;

import java.io.*;
import com.dao.DaoProjet;
import com.model.Projet;
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

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        String path = request.getServletPath();
//        if(path.equals("/home")) {
//            request.getRequestDispatcher("Projet/CreateProjet.jsp").forward(request, response);
//        }
//    }
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

            try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/votre_base_de_donnees", "votre_utilisateur", "votre_mot_de_passe")) {
                DaoProjet daoProjet = new DaoProjet(connection);
                daoProjet.ajouterProjet(projet);
          } catch (SQLException e) {
                e.printStackTrace();
            }

            response.sendRedirect("success.html");
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




