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
public class PasswordResetServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Get/Create session
        HttpSession session = request.getSession();
        //Retrieve user object from session scope
        User user = (User) session.getAttribute("user");
        //Default redirect
        String url = "/password-reset.jsp";

        //Error message
        String message = "";

        //Validate password
        String password = request.getParameter("password");
        if (password == null || password.isEmpty()) {
            message = "Please fill out all the form data fields.";
            url = "/password-reset.jsp";

        } else if (user == null) {
            message = "Not logged in.";
            url = "/password-reset.jsp";
        } else {
            message = "";
            url = "/account-activity.jsp";
            //Set password
            user.setPassword(password);
            session.setAttribute("user", user);
        }

        request.setAttribute("message", message);
        request.getRequestDispatcher(url).forward(request, response);
    }
}
