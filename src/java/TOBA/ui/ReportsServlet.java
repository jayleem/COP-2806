package TOBA.ui;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//Imports for writing the generated report to an excel file
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Jason
 *
 */
public class ReportsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String url = "/admin/reports.jsp";
        String action = request.getParameter("action");
        
        System.out.println("ReportsServlet 1122334455667788");

        if (action.equals("View Report")) {

            List<User> userList = selectUsers();
            session.setAttribute("userList", userList);

            if (userList == null || userList.isEmpty()) {
                url = "/admin/reports-error.jsp";
            } else {
                url = "/admin/reports.jsp";
            }
        }
        if (action.equals("Hide Report")) {

            List<User> userList = null;
            session.setAttribute("userList", userList);

            url = "/admin/reports.jsp";
        }
        if (action.equals("Export Report")) {
            List<User> userList = selectUsers();

            if (userList == null || userList.isEmpty()) {
                url = "/admin/reports-error.jsp";
            } else {

                //print reports to xml file for download.
                XSSFWorkbook workbook = new XSSFWorkbook();
                Sheet worksheet = workbook.createSheet("Registered users");
                Row row = worksheet.createRow((short) 0);
                row.createCell(0).setCellValue("UserID");
                row.createCell(1).setCellValue("Username");
                row.createCell(2).setCellValue("Date Registered");

                try {
                    int r = 1;
                    for (User user : userList) {
                        row = worksheet.createRow(r);
                        row.createCell(0).setCellValue(user.getUserId());
                        row.createCell(1).setCellValue(user.getUserName());
                        row.createCell(2).setCellValue(user.getDateRegistered().toString());
                        r++;
                    }
                } catch (Exception e) {
                    this.log(e.toString());
                }
                response.setHeader("content-disposition",
                        "attachment; filename=registered-users.xlsx");
                response.setHeader("cache-control", "no-cache");

                try (OutputStream out = response.getOutputStream()) {
                    workbook.write(out);
                } catch (Exception e) {
                    this.log(e.toString());
                }
            }
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
    //Select Users Method
    //I know this code will be required for selecting the correct data

    public static List<User> selectUsers() {

        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM User u ";
        TypedQuery<User> q = em.createQuery(qString, User.class);

        List<User> users;
        try {
            users = q.getResultList();
            if (users == null || users.isEmpty()) {
                users = null;
            }
        } finally {
            em.close();
        }
        return users;
    }
}
