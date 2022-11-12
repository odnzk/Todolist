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
import services.ProjectService;
import util.UserAchievementServiceHelper;
import util.ErrorHandler;

import java.io.IOException;

@WebServlet("/delete")
public class DeleteProjectServlet extends HttpServlet {
    private ProjectService projectService;
    private UserAchievementServiceHelper userAchievementServiceHelper;
    private ErrorHandler errorHandler;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        projectService = (ProjectService) getServletContext().getAttribute(InitListener.KEY_PROJECT_SERVICE);
        userAchievementServiceHelper = (UserAchievementServiceHelper) getServletContext().getAttribute(InitListener.KEY_USER_ACHIEVEMENT_SERVICE_HELPER);
        errorHandler = (ErrorHandler) getServletContext().getAttribute(InitListener.KEY_ERROR_HANDLER);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute(AuthService.USER_ATTRIBUTE);
        String strProjectId = req.getParameter("id");
        try {
            Long projectId = Long.parseLong(strProjectId);
            projectService.delete(projectId);
            userAchievementServiceHelper.unlockDeleteProject(user);
        } catch (NumberFormatException e) {
            errorHandler.handle(resp, req, "Invalid data", HttpServletResponse.SC_BAD_REQUEST);
        }
        resp.setContentType("text/html;charset=UTF-8");
        resp.sendRedirect(req.getContextPath() + "/home");
    }
}
