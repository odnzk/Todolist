package listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jdbc.AppDataSource;
import mapper.ProjectItemMapper;
import mapper.ProjectMapper;
import mapper.UserMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import repository.impl.ProjectDaoImpl;
import repository.impl.ProjectItemDaoImpl;
import repository.impl.UserDaoImpl;
import services.AuthService;
import util.PasswordEncoder;


@WebListener
public class InitListener implements ServletContextListener {
    public static final String KEY_AUTH_SERVICE = "authService";
    public static final String KEY_USER_DAO = "userDao";
    public static final String KEY_PROJECT_DAO = "projectDao";
    public static final String KEY_PROJECT_ITEM_DAO = "projectItemDao";


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
        UserMapper userMapper = new UserMapper();
        ProjectMapper projectMapper = new ProjectMapper();
        ProjectItemMapper projectItemMapper = new ProjectItemMapper();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(new AppDataSource().getInstance());

        UserDaoImpl userDao = new UserDaoImpl(userMapper, jdbcTemplate);
        ProjectDaoImpl projectDao = new ProjectDaoImpl(projectMapper, jdbcTemplate);
        ProjectItemDaoImpl projectItemDao = new ProjectItemDaoImpl(projectItemMapper, jdbcTemplate);
        PasswordEncoder passwordEncoder = new PasswordEncoder();

        sce.getServletContext().setAttribute(KEY_USER_DAO, userDao);
        sce.getServletContext().setAttribute(KEY_PROJECT_DAO, projectDao);
        sce.getServletContext().setAttribute(KEY_PROJECT_ITEM_DAO, projectItemDao);
        sce.getServletContext().setAttribute(KEY_AUTH_SERVICE, new AuthService(userDao, passwordEncoder));

    }
}
