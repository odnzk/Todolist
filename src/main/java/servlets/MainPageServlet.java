package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import model.ui.UiProjectWithItems;
import services.UiProjectService;

import java.io.IOException;
import java.util.List;

@WebServlet("/mainPage")
public class MainPageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User("cewj", "dmwd", "xmew");// get User
        UiProjectService projectService = new UiProjectService(user);

        List<UiProjectWithItems> uiProjects = projectService.getAllUiProjects();
        // set to jsp

        resp.setContentType("text/html;charset=UTF-8");
        req.getRequestDispatcher("main_page.jsp").forward(req, resp);
    }
}
