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
public class NewCustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Get/Create session
        HttpSession session = request.getSession();

        String url = "/new-customer.jsp";

        // read form fields
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String telephone = request.getParameter("phone");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zipcode = request.getParameter("zipcode");
        String email = request.getParameter("email");
        String userName = "";
        String password = "welcome1";//the default password

        //Variables for hashing/salting password
        String hashedPassword = "";
        String salt = PWUtil.getSalt();
        String saltedAndHashedPassword = "";

        //Validate parameters
        String message = "";

        if (firstName == null || lastName == null || telephone == null
                || address == null || city == null || state == null
                || zipcode == null || email == null
                || firstName.isEmpty() || lastName.isEmpty() || telephone.isEmpty()
                || address.isEmpty() || city.isEmpty() || state.isEmpty()
                || zipcode.isEmpty() || email.isEmpty()) {
            message = "Please fill out all the form data fields.";
            url = "/new-customer.jsp";
        } else {
            url = "/success.jsp";
            //Create new user and account objects
            User user = new User(firstName, lastName, telephone, address, city, state, zipcode, email, userName, password);
            Account account = new Account(user, 25.0);

            //Hash and salt the password before inserting into DB
            String saltedPass = user.getPassword() + salt;
            try {
                user.setPassword(PWUtil.hashPassword(saltedPass));
            } catch (NoSuchAlgorithmException ex) {
                hashedPassword = ex.getMessage();
                saltedAndHashedPassword = ex.getMessage();
            }

            //Set the users username
            user.setUserName(firstName + zipcode);
            user.setSalt(salt);

            //Insert the newly created user and account objects into their respective databases
            UserDB.insert(user);
            AccountDB.insert(account);

            //Set the current sessions user and account attributes
            session.setAttribute("user", user);
            session.setAttribute("account", account);
        }

        request.setAttribute("message", message);
        request.getRequestDispatcher(url).forward(request, response);
    }
}
