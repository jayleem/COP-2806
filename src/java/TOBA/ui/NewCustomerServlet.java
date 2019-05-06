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
        String password = "";

        //Variables for hashing/salting password
        String hashedPassword = "";
        String salt = "";
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
            User user = new User(firstName, lastName, telephone, address, city, state, zipcode, email, userName, password, salt); //new user object

            //Hash and salt the password before inserting into DB
            try {
                salt = PWUtil.getSalt();
                saltedAndHashedPassword = PWUtil.hashAndSaltPassword(password, salt);

            } catch (NoSuchAlgorithmException ex) {
                hashedPassword = ex.getMessage();
                saltedAndHashedPassword = ex.getMessage();
            }
            user.setUserName(firstName + zipcode);
            user.setPassword(saltedAndHashedPassword);
            user.setSalt(salt);            

            UserDB.insert(user);//insert user into database table
            
            session.setAttribute("user", user);
            
            user.setPassword("welcome1");
        }
        
        request.setAttribute("message", message);
        request.getRequestDispatcher(url).forward(request, response);
    }
}
