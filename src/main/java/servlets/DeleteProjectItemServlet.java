package servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import listener.InitListener;
import services.ProjectItemService;
import validators.ErrorHandler;

import java.io.IOException;

@WebServlet("/deleteitem")
public class DeleteProjectItemServlet extends HttpServlet {
    private ProjectItemService projectItemService;
    private ErrorHandler errorHandler;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        projectItemService = (ProjectItemService) getServletContext().getAttribute(InitListener.KEY_PROJECT_ITEM_SERVICE);
        errorHandler = (ErrorHandler) getServletContext().getAttribute(InitListener.KEY_ERROR_HANDLER);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strProjectId = req.getParameter("id");
        try {
            Long projectId = Long.parseLong(strProjectId);
            projectItemService.delete(projectId);
        } catch (NumberFormatException e) {
            errorHandler.handle(resp, req, "Invalid data", HttpServletResponse.SC_BAD_REQUEST);
        }
        resp.setContentType("text/html;charset=UTF-8");
        resp.sendRedirect(req.getContextPath() + "/home");
    }
}
