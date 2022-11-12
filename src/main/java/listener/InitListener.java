package listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.springframework.jdbc.core.JdbcTemplate;
import repository.impl.ProjectDaoImpl;
import repository.impl.ProjectItemDaoImpl;
import repository.impl.UserAchievementsDaoImpl;
import repository.impl.UserDaoImpl;
import services.*;
import util.PasswordEncoder;
import util.UserAchievementServiceHelper;
import util.jdbc.AppDataSource;
import util.jdbc.mapper.AchievementsMapper;
import util.jdbc.mapper.ProjectItemMapper;
import util.jdbc.mapper.ProjectMapper;
import util.jdbc.mapper.UserMapper;
import validators.ErrorHandler;
import validators.UserValidator;


@WebListener
public class InitListener implements ServletContextListener {
    public static final String KEY_AUTH_SERVICE = "authService";
    public static final String KEY_UI_PROJECT_SERVICE = "ui-projectService";
    public static final String KEY_PROJECT_SERVICE = "projectService";
    public static final String KEY_PROJECT_ITEM_SERVICE = "projectItemService";
    public static final String KEY_USER_ACHIEVEMENT_SERVICE = "userAchievementService";
    public static final String KEY_USER_ACHIEVEMENT_SERVICE_HELPER = "userAchievementServiceHelper";
    public static final String KEY_USER_SERVICE = "userService";
    public static final String KEY_ERROR_HANDLER = "errorHandler";
    public static final String KEY_USER_VALIDATOR = "userValidator";


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(new AppDataSource().getInstance());
        PasswordEncoder passwordEncoder = new PasswordEncoder();

        UserDaoImpl userDao = new UserDaoImpl(new UserMapper(), jdbcTemplate);
        ProjectDaoImpl projectDao = new ProjectDaoImpl(new ProjectMapper(), jdbcTemplate);
        ProjectItemDaoImpl projectItemDao = new ProjectItemDaoImpl(new ProjectItemMapper(), jdbcTemplate);
        UserAchievementsDaoImpl userAchievementsDao = new UserAchievementsDaoImpl(new AchievementsMapper(), jdbcTemplate);


        sce.getServletContext().setAttribute(KEY_AUTH_SERVICE, new AuthService(userDao, passwordEncoder));
        sce.getServletContext().setAttribute(KEY_UI_PROJECT_SERVICE, new UiProjectService(projectDao, projectItemDao));
        ProjectItemService projectItemService = new ProjectItemService(projectItemDao);
        UserAchievementService userAchievementService = new UserAchievementService(userAchievementsDao);
        sce.getServletContext().setAttribute(KEY_USER_ACHIEVEMENT_SERVICE, userAchievementService);
        sce.getServletContext().setAttribute(KEY_PROJECT_SERVICE, new ProjectService(projectDao));
        sce.getServletContext().setAttribute(KEY_PROJECT_ITEM_SERVICE, projectItemService);
        sce.getServletContext()
                .setAttribute(KEY_USER_ACHIEVEMENT_SERVICE_HELPER,
                        new UserAchievementServiceHelper(projectItemService,
                                userAchievementService));
        sce.getServletContext().setAttribute(KEY_USER_SERVICE, new UserService(userDao));
        sce.getServletContext().setAttribute(KEY_USER_VALIDATOR, new UserValidator());
        sce.getServletContext().setAttribute(KEY_ERROR_HANDLER, new ErrorHandler());

    }
}
