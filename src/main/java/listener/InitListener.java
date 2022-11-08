package listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.springframework.jdbc.core.JdbcTemplate;
import repository.impl.*;
import services.*;
import util.PasswordEncoder;
import util.jdbc.AppDataSource;
import util.jdbc.mapper.*;


@WebListener
public class InitListener implements ServletContextListener {
    public static final String KEY_AUTH_SERVICE = "authService";
    //    public static final String KEY_USER_DAO = "userDao";
//    public static final String KEY_PROJECT_DAO = "projectDao";
//    public static final String KEY_PROJECT_ITEM_DAO = "projectItemDao";
//    public static final String KEY_ACHIEVEMENT_DAO = "achievementDao";
//    public static final String KEY_USER_ACHIEVEMENT_DAO = "userAchievementDao";
    public static final String KEY_UI_PROJECT_SERVICE = "ui-projectService";
    public static final String KEY_PROJECT_SERVICE = "projectService";
    public static final String KEY_ACHIEVEMENT_SERVICE = "achievementService";
    public static final String KEY_USER_ACHIEVEMENT_SERVICE = "userAchievementService";


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(new AppDataSource().getInstance());
        PasswordEncoder passwordEncoder = new PasswordEncoder();

        UserDaoImpl userDao = new UserDaoImpl(new UserMapper(), jdbcTemplate);
        ProjectDaoImpl projectDao = new ProjectDaoImpl(new ProjectMapper(), jdbcTemplate);
        ProjectItemDaoImpl projectItemDao = new ProjectItemDaoImpl(new ProjectItemMapper(), jdbcTemplate);
        AchievementsDaoImpl achievementsDao = new AchievementsDaoImpl(new AchievementsMapper(), jdbcTemplate);
        UserAchievementsDaoImpl userAchievementsDao = new UserAchievementsDaoImpl(new UserAchievementsMapper(), jdbcTemplate);

//        sce.getServletContext().setAttribute(KEY_USER_DAO, userDao);
//        sce.getServletContext().setAttribute(KEY_PROJECT_DAO, projectDao);
//        sce.getServletContext().setAttribute(KEY_PROJECT_ITEM_DAO, projectItemDao);
//        sce.getServletContext().setAttribute(KEY_ACHIEVEMENT_DAO, achievementsDao);
//        sce.getServletContext().setAttribute(KEY_USER_ACHIEVEMENT_DAO, userAchievementsDao);

        sce.getServletContext().setAttribute(KEY_AUTH_SERVICE, new AuthService(userDao, passwordEncoder));
        sce.getServletContext().setAttribute(KEY_UI_PROJECT_SERVICE, new UiProjectService(projectDao, projectItemDao));
        sce.getServletContext().setAttribute(KEY_ACHIEVEMENT_SERVICE, new AchievementService(achievementsDao));
        sce.getServletContext().setAttribute(KEY_USER_ACHIEVEMENT_SERVICE, new UserAchievementService(userAchievementsDao));
        sce.getServletContext().setAttribute(KEY_PROJECT_SERVICE, new ProjectService(projectDao));

    }
}
