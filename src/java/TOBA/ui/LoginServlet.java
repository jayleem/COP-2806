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

        String url = "/index.jsp";
        HttpSession session = request.getSession();

        String password = request.getParameter("password");
        String username = request.getParameter("username");

        String saltedAndHashedPassword = "";

        if (UserDB.userExists(username)) {
            User user = UserDB.selectUser(username);

            try {
                String salt = user.getSalt();
                saltedAndHashedPassword = PWUtil.hashAndSaltPassword(password, salt);
            } catch (NoSuchAlgorithmException ex) {
                System.out.println(ex.getMessage());
            }
            if (user.getPassword().equals(saltedAndHashedPassword)) {
                url = "/account-activity.jsp";
            } else {
                url = "/login-failure.jsp";
            }
            session.setAttribute("user", user);
            
        } else {
            url = "/login-failure.jsp";
            response.setStatus(400);
            session.invalidate();
        }

        getServletContext()
                .getRequestDispatcher(url).forward(request, response);
    }
}
