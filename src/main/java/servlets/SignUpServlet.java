package servlets;

import exceptions.ConnectingDbException;
import exceptions.LoadingDbException;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import listener.InitListener;
import model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import repository.impl.UserDaoImpl;
import services.AuthService;
import services.UserAchievementService;
import validators.UserValidator;

import java.io.IOException;


@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
    private AuthService service;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        service = (AuthService) getServletContext().getAttribute(InitListener.KEY_AUTH_SERVICE);
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

        try {
            if (service.findUser(user.getUsername()).isPresent()) {
                resp.getWriter().println("User with this username already exist");
            }
        } catch (ConnectingDbException | LoadingDbException e) {
            e.printStackTrace();
        }
        if (new UserValidator().validate(user)) {
            try {
                service.auth(user, req);
                service.signup(user);

                resp.setContentType("text/html;charset=UTF-8");
                req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
            } catch (LoadingDbException e) {
                e.printStackTrace();
            }
        } else {
            resp.getWriter().println("Invalid data");
        }
    }

}


