package TOBA.ui;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mysql.jdbc.Driver;

/**
 *
 * @author Jason
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/index.jsp";

        // read form fields
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("username: " + username);
        System.out.println("password: " + password);

        if (username.equals("jsmith") && password.equals("letmein")) {
            //forward to account activity page
            request.getRequestDispatcher("/account-activity.jsp").forward(request, response);
        } else {
            //forward to failure page
            request.getRequestDispatcher("/login-failure.jsp").forward(request, response);
        }
    }
}
