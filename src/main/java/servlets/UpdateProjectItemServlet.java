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
import util.UserAchievementServiceHelper;
import validators.ErrorHandler;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/updateProjectItem/*")
public class UpdateProjectItemServlet extends HttpServlet {
    private ProjectItemService projectItemService;
    private UserAchievementServiceHelper userAchievementServiceHelper;
    private ErrorHandler errorHandler;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        projectItemService = (ProjectItemService) getServletContext().getAttribute(InitListener.KEY_PROJECT_ITEM_SERVICE);
        userAchievementServiceHelper = (UserAchievementServiceHelper) getServletContext().getAttribute(InitListener.KEY_USER_ACHIEVEMENT_SERVICE_HELPER);
        errorHandler = (ErrorHandler) getServletContext().getAttribute(InitListener.KEY_ERROR_HANDLER);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute(AuthService.USER_ATTRIBUTE);
        String strProjectItemId = req.getParameter("id");
        try {
            Long projectItemId = Long.parseLong(strProjectItemId);
            projectItemService.update(projectItemId);


            // check if project is complete -> unlock achiv else skip
            // update project even if it is not completed
            Optional<List<ProjectItem>> list = projectItemService.findProjectItemsLinkedToProjectByProjectItem(projectItemId);
            if (list.isPresent()) {
                boolean allCompleted = list.get().stream().allMatch(ProjectItem::isDone);
                if (allCompleted) {
                    userAchievementServiceHelper.unlockProjectFinished(user);
                }
            }

        } catch (NumberFormatException e) {
            errorHandler.handle(resp, req, "Invalid data", HttpServletResponse.SC_BAD_REQUEST);
        }
        resp.setContentType("text/html;charset=UTF-8");
        resp.sendRedirect(req.getContextPath() + "/home");
    }

}
