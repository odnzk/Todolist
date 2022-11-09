package servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import listener.InitListener;
import model.Project;
import model.User;
import services.AuthService;
import services.ProjectService;
import services.UserAchievementService;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@WebServlet("/delete/*")
public class DeleteProjectServlet extends HttpServlet {
    private ProjectService projectService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        projectService = (ProjectService) getServletContext().getAttribute(InitListener.KEY_PROJECT_SERVICE);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strProjectId = req.getPathInfo().replace('/', ' ').trim();
        try {
            Long projectId = Long.parseLong(strProjectId);
            projectService.delete(projectId);
        } catch (NumberFormatException e) {
            resp.getWriter().println("Invalid data");
        }
        resp.setContentType("text/html;charset=UTF-8");
        resp.sendRedirect(req.getContextPath() + "/home");
    }
}
