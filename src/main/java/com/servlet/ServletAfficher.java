package com.servlet;

import com.dao.DaoProjet;
import com.util.DbConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/ServletAfficher")

public class ServletAfficher extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (Connection connection = DbConnection.getConnection()) {
            DaoProjet daoProjet = new DaoProjet(connection);
            try {
                request.setAttribute("afficherList", daoProjet.afficherListeProjets());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            this.getServletContext().getRequestDispatcher("/Projet/ListeProjet.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }
}
