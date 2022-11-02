package servlets;

import exceptions.ConnectingDbException;
import exceptions.LoadingDbException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import repository.impl.UserDaoImpl;
import services.SignUpService;
import validators.UserValidator;

import java.io.IOException;


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

        // 1) check is username unique -> if not show message
        // 2) check user validation -> if not show message
        // 3) sign up user and forward/redirect? to log in page

        SignUpService signUpService = new SignUpService();
        try {
            if (signUpService.userAlreadyExist(user)) {
                // todo show error message on edit text
                showErrorAlreadyExist();
            }
        } catch (ConnectingDbException|LoadingDbException e) {
            e.printStackTrace();
        }
        if (new UserValidator().validate(user)) {
            SignUpService service = new SignUpService();
            try {
                service.signUp(user);
            } catch (LoadingDbException e) {
                e.printStackTrace();
            }
            resp.setContentType("text/html;charset=UTF-8");
            req.setAttribute("username", username);
            req.getRequestDispatcher("main_page.jsp").forward(req, resp);
        } else {
            showErrorInvalidUser();
            // todo show error message on edit text
        }
    }

    private void showErrorInvalidUser() {

    }

    private void showErrorAlreadyExist() {
    }

}


