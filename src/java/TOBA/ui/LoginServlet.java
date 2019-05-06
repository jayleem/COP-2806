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
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        HttpSession session = request.getSession();
        
        //set default url
        String url = "/index.jsp";

        // get parameters from the request
        String password = request.getParameter("password");
        String username = request.getParameter("username");

        // hash and salt password
        String hashedPassword = "";
        String salt = "";
        String saltedAndHashedPassword = "";

        if (UserDB.userExists(username)) {
            User user = UserDB.selectUser(username);

            try {
                salt = user.getSalt();
                String saltedPass = password + salt;                
                saltedAndHashedPassword = PWUtil.hashPassword(saltedPass);               
                System.out.println(salt);
                System.out.println(saltedPass);
                System.out.println(saltedAndHashedPassword);
                
            } catch (NoSuchAlgorithmException ex) {
                System.out.println(ex.getMessage());
            }
            if (user.getPassword().equals(saltedAndHashedPassword)) {
                url = "/account-activity.jsp";
            } else {
                url = "/login-failure.jsp";
            }
            //Set session attribute
            session.setAttribute("user", user);

            //Set request attributes
            request.setAttribute("hashedPassword", hashedPassword);
            request.setAttribute("salt", salt);
            request.setAttribute("saltedAndHashedPassword", saltedAndHashedPassword);

        } else {
            url = "/login-failure.jsp";
            response.setStatus(400);
            session.invalidate();
        }

        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
    }
}
