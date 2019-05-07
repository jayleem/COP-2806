package TOBA.ui;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
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

        //Variables for hashing/salting password
        String hashedPassword = "";
        String salt = PWUtil.getSalt();
        String saltedAndHashedPassword = "";

        if (PWUtil.validatePassword(password)) {
            message = "Please fill out all the form data fields.";
            url = "/password-reset.jsp";

        } else if (user == null) {
            message = "Not logged in.";
            url = "/password-reset.jsp";
        } else {
            message = "";
            url = "/account-activity.jsp";

            //Hash and salt the password before inserting into DB
            String saltedPass = password + salt;
            try {
                user.setPassword(PWUtil.hashPassword(saltedPass));
            } catch (NoSuchAlgorithmException ex) {
                hashedPassword = ex.getMessage();
                saltedAndHashedPassword = ex.getMessage();
            }

            //Set new password
            user.setSalt(salt);
            session.setAttribute("user", user);

            UserDB.update(user);//update user password in database table
        }

        request.setAttribute("message", message);
        request.getRequestDispatcher(url).forward(request, response);
    }
}
