package servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import listener.InitListener;
import model.User;
import services.UserService;
import util.UserAchievementServiceHelper;
import validators.UserValidator;

import java.io.IOException;

@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet {
    private UserService userService;
    private UserAchievementServiceHelper userAchievementServiceHelper;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userService = (UserService) getServletContext().getAttribute(InitListener.KEY_USER_SERVICE);
        userAchievementServiceHelper = (UserAchievementServiceHelper) getServletContext().getAttribute(InitListener.KEY_USER_ACHIEVEMENT_SERVICE_HELPER);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User(req.getParameter("username"),
                req.getParameter("email"),
                req.getParameter("password"));
        if (new UserValidator().validate(user)) {
            userService.updateUser(user);
            userAchievementServiceHelper.unlockChangeProfile(user);
            resp.setContentType("text/html;charset=UTF-8");
            resp.sendRedirect(req.getContextPath() + "/home");
        } else {
            resp.getWriter().println("Invalid data");
        }
    }
}
