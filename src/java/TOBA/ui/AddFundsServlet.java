/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TOBA.ui;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jason
 */
public class AddFundsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Get/Create session        
        HttpSession session = request.getSession();

        //Retrieve user object from session scope
        Account account = (Account) session.getAttribute("account");

        //Default redirect
        String url = "/add-funds.jsp";

        //Error message
        String message = "";

        //Validate funds
        String sBalance = request.getParameter("addFunds");
        Double value = Double.valueOf(sBalance);
        System.out.println("value: " + value);
        
        if (account == null) {
            message = "Not logged in.";
            url = "/login.jsp";
        } else {
            message = "";
            url = "/add-funds.jsp";
            //Add funds and set new balance
            account.credit(value);
            session.setAttribute("account", account);

            AccountDB.update(account);//update user password in database table
        }

        request.setAttribute("message", message);
        request.getRequestDispatcher(url).forward(request, response);
    }
}
