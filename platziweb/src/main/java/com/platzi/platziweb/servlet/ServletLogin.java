package com.platzi.platziweb.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/***
 * Servlet para login
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String usuario = request.getParameter("usuario");
        String empresa = request.getParameter("empresa");

        PrintWriter escritor = response.getWriter();

        // Validaciones
        if( usuario != null && empresa != null){
            if(empresa.equals("platzi")){
                escritor.println("Welcome Platzi");
            }else{
                escritor.println("Bienvenido....");
            }
        }else{
            escritor.println("Usuario incorrecto");
        }

    }
}
