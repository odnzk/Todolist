package servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import listener.InitListener;
import model.User;
import model.ui.UiProjectWithItems;
import services.AuthService;
import services.UiProjectService;

import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class MainPageServlet extends HttpServlet {
    private UiProjectService projectService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        projectService = (UiProjectService) getServletContext().getAttribute(InitListener.KEY_UI_PROJECT_SERVICE);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute(AuthService.USER_ATTRIBUTE);

        List<UiProjectWithItems> uiProjects = projectService.getAllUiProjects(user);

        req.setAttribute("isUiProjectsEmpty", uiProjects.isEmpty());
        req.setAttribute("uiProjects", uiProjects);
        req.setAttribute("context", getServletContext().getContextPath());

        resp.setContentType("text/html;charset=UTF-8");
        req.getRequestDispatcher("/WEB-INF/jsp/main_page.jsp").forward(req, resp);
    }
}
