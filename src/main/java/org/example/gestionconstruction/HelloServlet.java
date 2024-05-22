package org.example.gestionconstruction;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = request.getServletPath();
        if(path.equals("/home")) {
            request.getRequestDispatcher("Projet/CreateProjet.jsp").forward(request, response);
        }
    }

    public void destroy() {
    }
}