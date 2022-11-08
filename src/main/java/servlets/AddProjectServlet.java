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

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@WebServlet("/add")
public class AddProjectServlet extends HttpServlet {
    private static final String DATE_PATTERN = "yyyy-MM-dd";
    private ProjectService projectService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        projectService = (ProjectService) getServletContext().getAttribute(InitListener.KEY_PROJECT_SERVICE);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute(AuthService.USER_ATTRIBUTE);

        String title = req.getParameter("title");
        String startDate = req.getParameter("startDate");
        String finishDate = req.getParameter("finishDate");
        try {
            Project project = new Project(user.getId(), title, convertToDate(startDate), convertToDate(finishDate));
            projectService.create(project);
        } catch (ParseException e) {
            req.setAttribute("message", "Invalid date");
        }

        resp.setContentType("text/html;charset=UTF-8");
        resp.sendRedirect(req.getContextPath() + "/home");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    private Date convertToDate(String str) throws ParseException {
        DateFormat format = new SimpleDateFormat(DATE_PATTERN, Locale.ENGLISH);
        return format.parse(str);
    }
}
