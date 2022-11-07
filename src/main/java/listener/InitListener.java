package listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import mapper.UserMapper;
import repository.UserDao;
import repository.impl.UserDaoImpl;
import services.AuthService;
import util.PasswordEncoder;
import util.SimpleJdbcTemplate;


@WebListener
public class InitListener implements ServletContextListener {
    public static final String KEY_AUTH_SERVICE = "authService";
    public static final String KEY_USER_DAO= "userDao";


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
        UserMapper userMapper = new UserMapper();
        SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate();
        UserDaoImpl userDao = new UserDaoImpl(userMapper, simpleJdbcTemplate);
        PasswordEncoder passwordEncoder = new PasswordEncoder();

        sce.getServletContext().setAttribute(KEY_USER_DAO, userDao);
        sce.getServletContext().setAttribute(KEY_AUTH_SERVICE, new AuthService(userDao, passwordEncoder));

    }
}
