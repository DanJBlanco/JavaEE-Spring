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
@WebServlet("/abc123")
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user = request.getParameter("user");
        String enterprise = request.getParameter("enterprise");

        PrintWriter outWriter = response.getWriter();

        // Validaciones
        if( user != null && enterprise != null){
            if(enterprise.equals("platzi")){
                outWriter.println("Welcome Platzi");
            }else{
                outWriter.println("Welcome....");
            }
        }else{
            outWriter.println("Wrong User");
        }

    }
}
