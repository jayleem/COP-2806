package TOBA.ui;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jason
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Get/Create session
        HttpSession session = request.getSession();

        String url = "/index.jsp";

        // read form fields
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //check username and password against database
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // loads driver
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tobadb", "root", "abbypi88"); // gets a new connection

            PreparedStatement statement = con.prepareStatement("SELECT FirstName, LastName, Phone, Address, City, State, ZipCode, Email, UserName, Password FROM users where UserName=? and Password=?");
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                
                User user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
                session.setAttribute("user", user);

                Account account = new Account(user, 25.00);  //new account object 
                session.setAttribute("account", account);

                request.getRequestDispatcher("/account-activity.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/login-failure.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
