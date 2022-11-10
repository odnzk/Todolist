package servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import listener.InitListener;
import model.Achievement;
import model.User;
import model.ui.UiUserAchievement;
import services.AuthService;
import services.UserAchievementService;
import util.UserAchievementServiceHelper;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@WebServlet("/achievements")
public class AchievementsServlet extends HttpServlet {
    private UserAchievementService userAchievementService;
    private AuthService service;
    private UserAchievementServiceHelper userAchievementServiceHelper;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userAchievementService = (UserAchievementService) getServletContext().getAttribute(InitListener.KEY_USER_ACHIEVEMENT_SERVICE);
        service = (AuthService) getServletContext().getAttribute(InitListener.KEY_AUTH_SERVICE);
        userAchievementServiceHelper = (UserAchievementServiceHelper) getServletContext().getAttribute(InitListener.KEY_USER_ACHIEVEMENT_SERVICE_HELPER);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = service.getCurrentUser(req);

        userAchievementServiceHelper.unlockTenProjectItemCreated(user);

        // get all achievements
        // if user have
        Optional<List<Achievement>> userAchiv = userAchievementService.findAllUserAchievements(user);
        Optional<List<Achievement>> allAchiv = userAchievementService.findAllAchievements();
        if (allAchiv.isPresent() && userAchiv.isPresent()) {
            List<Achievement> userAchivUi = userAchiv.get();
            List<UiUserAchievement> uiList = allAchiv
                    .get()
                    .stream()
                    .map(it -> new UiUserAchievement(it, contains(userAchivUi, it)))
                    .sorted((o1, o2) -> -o1.getUnlocked().compareTo(o2.getUnlocked()))
                    .collect(Collectors.toList());

            Set<String> categorySet = uiList.stream().map(it -> it.getAchievement().getCategory()).collect(Collectors.toSet());

            req.setAttribute("uiAchievements", uiList);
            req.setAttribute("categories", categorySet);
            resp.setContentType("text/html;charset=UTF-8");
            req.getRequestDispatcher("/WEB-INF/jsp/achievements.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    private boolean contains(List<Achievement> mainList, Achievement item) {
        for (Achievement a : mainList) {
            if (a.getId().equals(item.getId())) {
                return true;
            }
        }
        return false;
    }
}
