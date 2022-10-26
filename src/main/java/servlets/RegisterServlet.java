package servlets;

import dao.impl.UserDaoImpl;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class RegisterServlet extends HttpServlet {
    private final UserDaoImpl userDaoImpl = new UserDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        String date = req.getParameter("date");
        String sex = req.getParameter("sex"); //
        String password = req.getParameter("password");

        if (UserValidator.isValid(username, email, country, date, sex, password)) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date parsedDate = format.parse(date);
                User user = new User(username, email, country, parsedDate, sex.equals("fem"), password);
                userDaoImpl.registerUser(user);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            resp.setContentType("text/html;charset=UTF-8");
            req.setAttribute("username", username);
            req.getRequestDispatcher("main_page.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}


