package servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import listener.InitListener;
import model.Project;
import model.ProjectItem;
import model.User;
import services.AuthService;
import services.ProjectItemService;
import services.ProjectService;
import util.UserAchievementServiceHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Optional;

// todo update project
@WebServlet("/updateProjectItem/*")
public class UpdateProjectItemServlet extends HttpServlet {
    private ProjectItemService projectItemService;
    private ProjectService projectService;
    private UserAchievementServiceHelper userAchievementServiceHelper;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        projectService = (ProjectService) getServletContext().getAttribute(InitListener.KEY_PROJECT_SERVICE);
        projectItemService = (ProjectItemService) getServletContext().getAttribute(InitListener.KEY_PROJECT_ITEM_SERVICE);
        userAchievementServiceHelper = (UserAchievementServiceHelper) getServletContext().getAttribute(InitListener.KEY_USER_ACHIEVEMENT_SERVICE_HELPER);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute(AuthService.USER_ATTRIBUTE);
        String strProjectItemId = req.getPathInfo().replace('/', ' ').trim();
        try {
            Long projectItemId = Long.parseLong(strProjectItemId);
            projectItemService.update(projectItemId);

//            Socket s = new Socket(InetAddress.getByName("localhost"), 80);
//            PrintWriter out = new PrintWriter(s.getOutputStream());
//            out.println("GET / HTTP:1.1");
//            out.println("HOST: localhost");
//            out.println("USER-AGENT: some browser");
//            out.println();
//            out.flush();
//
//            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
//            String line = null;
//            while((line = in.readLine()) != null){
//                out.println(line);
//            }
//            s.close();
            // http server файовый сервер
            // написать и куда-то там замаппить
            // если файлик есть в директории, то отдаем файлик,
            // если нет, но генерируем страничку с 404 статус
            // норм сервер не должен отдавать файлы все сайта (с .. аккуратнее)
            // надо работать с файловой системой и генерировать html

            // 2 из запроса берем get параметра и генерируем файлик с их суммой

            ServerSocket serverSocket = new ServerSocket(8080);
            Socket s = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String line = null;
            while((line = in.readLine()) != null){
                System.out.println(line);
            }
            PrintWriter out = new PrintWriter(s.getOutputStream());
            out.println("HTTP 1.1. 200 OK\r\n");


            // check if project is complete -> unlock achiv else skip
            // update project even if it is not completed
            Optional<List<ProjectItem>> list = projectItemService.findProjectItemsLinkedToProjectByProjectItem(projectItemId);
            if (list.isPresent()) {
                boolean allCompleted = list.get().stream().allMatch(ProjectItem::isDone);
                if (allCompleted) {
                    userAchievementServiceHelper.unlockProjectFinished(user);
                }
//                projectService.update(new User(req.getParameter("username"),
//                        req.getParameter("email"),
//                        req.getParameter("password")));
            }

        } catch (NumberFormatException e) {
            resp.getWriter().println("Invalid data");
        }
        resp.setContentType("text/html;charset=UTF-8");
        resp.sendRedirect(req.getContextPath() + "/home");
    }

}
