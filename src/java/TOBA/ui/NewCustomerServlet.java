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
            User user = new User(firstName, lastName, telephone, address, city, state, zipcode, email, userName, password); //new user object
            //Set username and password
            user.setUserName(firstName+zipcode);
            user.setPassword("welcome1");
            
            session.setAttribute("user", user);
            
            UserDB.insert(user);//insert user into database table
            
            Account account = new Account(user, 25.00);  //new account object 
            session.setAttribute("account", account);
            
            AccountDB.insert(account);//insert user into database table
        }
        
        request.setAttribute("message", message);
        request.getRequestDispatcher(url).forward(request, response);
    }
}
