/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author I342041
 */
@WebServlet(name = "RegistrationServlet", urlPatterns = {"/RegistrationServlet"})
public class RegistrationServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(password.length() > 16)
        {
            response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

             out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistrationServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1>Regestration Failed</h1>");
            out.println("<p>Password must be less than 16 Characters</p> <br>");
           
            
            out.println("</body>");
            out.println("</html>");
        }
        }
        if(username.length() < 5)
        {
            response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

             out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistrationServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1>Regestration Failed</h1>");
            out.println("<p>Username must be more than 5 Characters</p> <br>");
           
            
            out.println("</body>");
            out.println("</html>");
        }
        }
        if(username.length() >= 5 && password.length() < 16)
        {
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("Login.html");
            rd.forward(request, response);
        }
            
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
