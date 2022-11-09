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
import services.UserAchievementService;

import java.io.IOException;

@WebServlet("/updateProjectItem/*")
public class UpdateProjectItemServlet extends HttpServlet {
    private ProjectItemService projectItemService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        projectItemService = (ProjectItemService) getServletContext().getAttribute(InitListener.KEY_PROJECT_ITEM_SERVICE);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strProjectItemId = req.getPathInfo().replace('/', ' ').trim();
        try {
            Long projectItemId = Long.parseLong(strProjectItemId);
            projectItemService.update(projectItemId);
        } catch (NumberFormatException e) {
            resp.getWriter().println("Invalid data");
        }
        resp.setContentType("text/html;charset=UTF-8");
        resp.sendRedirect(req.getContextPath() + "/home");
    }

}
