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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String url = "/index.jsp";
		HttpSession session = request.getSession();

		String password = request.getParameter("password");
		String username = request.getParameter("username");

		System.out.println("User Exists: " + UserDB.userExists(username));
		if (UserDB.userExists(username)) {
			User user = UserDB.selectUser(username);
			session.setAttribute("user", user);
			if (password.equals(user.getPassword()) && username.equals(user.getUserName())) {
				url = "/account-activity.jsp";

			} else {
				url = "/login-failure.jsp";
				response.setStatus(400);
				session.invalidate();
			}
		}else{
			response.setStatus(400);
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
}