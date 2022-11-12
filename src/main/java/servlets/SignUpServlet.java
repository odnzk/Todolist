package servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import listener.InitListener;
import model.User;
import services.AuthService;
import util.ErrorHandler;
import validators.UserValidator;

import java.io.IOException;


@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
    private AuthService service;
    private UserValidator validator;
    private ErrorHandler errorHandler;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        service = (AuthService) getServletContext().getAttribute(InitListener.KEY_AUTH_SERVICE);
        validator = (UserValidator) getServletContext().getAttribute(InitListener.KEY_USER_VALIDATOR);
        errorHandler = (ErrorHandler) getServletContext().getAttribute(InitListener.KEY_ERROR_HANDLER);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/signup.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = new User(username, email, password);

        if (service.findUser(user.getUsername()).isPresent()) {
            errorHandler.handle(resp, req, "User with this username already exist", HttpServletResponse.SC_BAD_REQUEST);
        }
        if (validator.validate(user)) {
            service.auth(user, req);
            service.signup(user);

            resp.setContentType("text/html;charset=UTF-8");
            req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
        } else {
            errorHandler.handle(resp, req, "Invalid data", HttpServletResponse.SC_BAD_REQUEST);
        }
    }

}


