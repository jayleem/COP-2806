/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jason
 */
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/index.html";

        // read form fields
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        System.out.println("username: " + username);
        System.out.println("password: " + password);

        if (username.equals("jsmith@toba.com") && password.equals("letmein")) {
            //forward to account activity page
            request.getRequestDispatcher("/account-activity.html").forward(request, response);
        } else {
            //forward to failure page
            request.getRequestDispatcher("/login-failure.html").forward(request, response);
        }
    }
}
