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
public class NewCustomerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/new-customer.jsp";

        // read form fields
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zipcode = request.getParameter("zipcode");
        String email = request.getParameter("email");

        //Validate parameters
        String message;
        
        if (    firstName == null || lastName == null || phone == null ||
                address == null || city == null || state == null ||
                zipcode == null || email == null ||
                firstName.isEmpty() || lastName.isEmpty() || phone.isEmpty() ||
                address.isEmpty() || city.isEmpty() || state.isEmpty() ||
                zipcode.isEmpty() || email.isEmpty()) {
            message = "Please fill out all the form data fields.";
            url = "/new-customer.jsp";
        } else {
            message = "";
            url = "/success.html";
        }
        request.setAttribute("message", message);
        request.getRequestDispatcher(url).forward(request, response);
        return;
    }
}
