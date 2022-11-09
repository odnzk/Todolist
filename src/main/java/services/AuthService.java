package services;

import exceptions.ConnectingDbException;
import exceptions.LoadingDbException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import repository.impl.UserDaoImpl;
import util.PasswordEncoder;

import java.util.Optional;

public class AuthService {
    public final static String USER_ATTRIBUTE = "user";

    private final UserDaoImpl userDao;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserDaoImpl userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> findUser(String username) throws ConnectingDbException, LoadingDbException {
        return userDao.findUserByUsername(username);
    }

    public boolean isAuth(HttpServletRequest req) {
        return req.getSession().getAttribute(USER_ATTRIBUTE) != null;
    }

    public void auth(User user, HttpServletRequest req) {
        req.getSession().setAttribute(USER_ATTRIBUTE, user);
    }

    public void logout(HttpServletRequest req) {
        req.getSession().removeAttribute(USER_ATTRIBUTE);
    }

    public void signup(User user) throws LoadingDbException {
        String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);
        userDao.insert(user);
    }

    public boolean login(String username, String password) throws ConnectingDbException, LoadingDbException {
        User user = userDao.findUserByUsername(username).get();
        return user.getPassword().equals(password);
    }

}
