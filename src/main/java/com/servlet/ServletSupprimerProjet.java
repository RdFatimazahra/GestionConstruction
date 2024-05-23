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

@WebServlet(name = "ServletSupprimerProjet", value = "/SupprimerProjet")
public class ServletSupprimerProjet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idProjet = Integer.parseInt(request.getParameter("id"));
        try (Connection connection = DbConnection.getConnection()) {
            DaoProjet daoProjet = new DaoProjet(connection);
            daoProjet.supprimerProjet(idProjet);
            response.sendRedirect("ServletAfficher");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirige vers doGet
        doGet(request, response);
    }
}
