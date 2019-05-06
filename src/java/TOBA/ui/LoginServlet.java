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
                //Code from ch_17_ex1 CheckPasswordServlet
                //Not sure if my edits are correct but
                /*
                THE PASSWORD USED TO TEST LOGGING IN WAS THE DEFAULT PASSWORD welcome1
                
                hashedPassword = PasswordUtil.hashPassword(password);
                salt = PasswordUtil.getSalt();
                saltedAndHashedPassword = PasswordUtil.hashAndSaltPassword(password);
                //I checked the values which were being crated as I kept being redirected to the login-failure.jsp with the code below
                System.out.println(salt); pemPRgTQheXCh1+O2q4V/lP6mvvcMZHW9KWP7MB5jWE=
                System.out.println(saltedPass); welcome1pemPRgTQheXCh1+O2q4V/lP6mvvcMZHW9KWP7MB5jWE=
                System.out.println(hashedPassword); 762c4023e537b455212ddfb101fad0766db4bad68dd50057727f86a54ac54389 <-- Value of the saltedAndHashedPassword stored in the user table
                System.out.println(saltedAndHashedPassword); cd3b2569562caeaca2aae92d0db39ef46a1b46865eecd7177e21fdd180cd79fe <-- I think the code before hashed it again which results in login failure as the password is not the same
                 */

                //Modified code from ch_17_ex1 CheckPasswordServlet
                salt = user.getSalt();
                String saltedPass = password + salt;
                saltedAndHashedPassword = PWUtil.hashPassword(saltedPass);
                System.out.println(salt); //pemPRgTQheXCh1+O2q4V/lP6mvvcMZHW9KWP7MB5jWE=
                System.out.println(saltedPass); //welcome1pemPRgTQheXCh1+O2q4V/lP6mvvcMZHW9KWP7MB5jWE=
                System.out.println(saltedAndHashedPassword); //762c4023e537b455212ddfb101fad0766db4bad68dd50057727f86a54ac54389 <-- Value of the saltedAndHashedPassword stored in the user table successful login with "welcome1" as password

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
