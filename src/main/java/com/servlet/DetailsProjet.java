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
import java.sql.SQLException;

@WebServlet("/DetailsProjet")
public class DetailsProjet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idProjet = Integer.parseInt(request.getParameter("id"));
        try (Connection connection = DbConnection.getConnection()) {
            DaoProjet daoProjet = new DaoProjet(connection);
            try {
                Projet projet = daoProjet.rechbyid(idProjet);
                request.setAttribute("projet", projet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            this.getServletContext().getRequestDispatcher("/Projet/DetailsProjet.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }
}