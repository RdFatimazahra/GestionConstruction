package com.servlet;

import com.dao.DaoTache;
import com.model.Tache;
import com.util.DbConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/ServletTache")
public class ServletTache extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try (Connection connection = DbConnection.getConnection()) {
            DaoTache daoTache = new DaoTache(connection);
            switch (action) {
                case "ajouter":
                    request.getRequestDispatcher("/Tache/CreateTache.jsp").forward(request, response);
                    break;
                case "modifier":
                    int idTache = Integer.parseInt(request.getParameter("id"));
                    Tache tache = daoTache.searchById(idTache);
                    request.setAttribute("tache", tache);
                    request.getRequestDispatcher("/Tache/EditTache.jsp").forward(request, response);
                    break;
                case "supprimer":
                    int idTacheToDelete = Integer.parseInt(request.getParameter("id"));
                    daoTache.supprimerTache(idTacheToDelete);
                    response.sendRedirect(request.getContextPath() + "/ServletTache");
                    break;
                default:
                    int idProjet = Integer.parseInt(request.getParameter("idProjet"));
                    List<Tache> taches = daoTache.afficherListeTachesByIdProjet(idProjet);
                    request.setAttribute("taches", taches);
                    request.getRequestDispatcher("/Tache/ListeTache.jsp").forward(request, response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try (Connection connection = DbConnection.getConnection()) {
            DaoTache daoTache =new DaoTache(connection);
            switch (action) {
                case "ajouter":
                    int idProjet = Integer.parseInt(request.getParameter("idProjet"));
                    Tache tache = new Tache(
                            request.getParameter("description"),
                            java.sql.Date.valueOf(request.getParameter("dateDebut")),
                            java.sql.Date.valueOf(request.getParameter("dateFin")),
                            idProjet,
                            request.getParameter("statut")
                    );
                    daoTache.ajouterTache(tache);
                    response.sendRedirect(request.getContextPath() + "/ServletTache?action=default&idProjet=" + idProjet);
                    break;
                case "modifier":
                    int idTache = Integer.parseInt(request.getParameter("id"));
                    Tache tacheToUpdate = daoTache.searchById(idTache);
                    tacheToUpdate.setDescription(request.getParameter("description"));
                    tacheToUpdate.setDateDebut(java.sql.Date.valueOf(request.getParameter("dateDebut")));
                    tacheToUpdate.setDateFin(java.sql.Date.valueOf(request.getParameter("dateFin")));
                    tacheToUpdate.setIdProjet(Integer.parseInt(request.getParameter("idProjet")));
                    tacheToUpdate.setStatut(request.getParameter("statut"));
                    daoTache.modifierTache(tacheToUpdate);
                    response.sendRedirect(request.getContextPath() + "/ServletTache?action=default&idProjet=" + tacheToUpdate.getIdProjet());
                    break;
                default:
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}