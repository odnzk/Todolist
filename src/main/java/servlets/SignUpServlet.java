package servlets;

import repository.impl.UserDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import services.SignUpService;
import validators.UserValidator;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;


@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {
    private final UserDaoImpl userDaoImpl = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // forwarding to jsp if user only ask
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/signup.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = new User(username, email, password);

        // 1) check is email and username are unique (in database there is no one else with these parameters)
        // -> if not show message
        // 2) check user validation -> if not show message
        // 3) sign up user and forward/redirect? to log in page

        SignUpService signUpService = new SignUpService();
        if(signUpService.userAlreadyExist(user)){

        }

        if (new UserValidator().validate(user)) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try {
//                User user = new User(username, email, country, parsedDate, sex.equals("fem"), password);
//                userDaoImpl.registerUser(user);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            resp.setContentType("text/html;charset=UTF-8");
            req.setAttribute("username", username);
            req.getRequestDispatcher("main_page.jsp").forward(req, resp);
        }
    }

}


