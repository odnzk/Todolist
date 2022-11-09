package servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import listener.InitListener;
import model.ProjectItem;
import model.User;
import services.AuthService;
import services.ProjectItemService;
import services.UserAchievementServiceHelper;

import java.io.IOException;

@WebServlet("/addItem")
public class AddProjectItemServlet extends HttpServlet {
    private ProjectItemService projectItemService;
    private UserAchievementServiceHelper userAchievementServiceHelper;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        projectItemService = (ProjectItemService) getServletContext().getAttribute(InitListener.KEY_PROJECT_ITEM_SERVICE);
        userAchievementServiceHelper = (UserAchievementServiceHelper) getServletContext().getAttribute(InitListener.KEY_USER_ACHIEVEMENT_SERVICE_HELPER);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute(AuthService.USER_ATTRIBUTE);
        try {
            String title = req.getParameter("projectItemTitle");
            Long projectId = Long.parseLong(req.getParameter("projectId"));
            projectItemService.add(new ProjectItem(projectId, title));

            userAchievementServiceHelper.unlockFirstProjectItemCreated(user);
        } catch (NumberFormatException e) {
            req.setAttribute("message", "Invalid project id");
        }
        resp.setContentType("text/html;charset=UTF-8");
        resp.sendRedirect(req.getContextPath() + "/home");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}
