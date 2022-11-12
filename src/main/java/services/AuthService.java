package services;

import exceptions.UserNotAuthorizedException;
import jakarta.servlet.http.HttpServletRequest;
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

    public User getCurrentUser(HttpServletRequest req) throws UserNotAuthorizedException {
        if (isAuth(req)) {
            return (User) req.getSession().getAttribute(USER_ATTRIBUTE);
        } else {
           throw new UserNotAuthorizedException("Session user attribute is null");
        }
    }

    public Optional<User> findUser(String username) {
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

    public void signup(User user) {
        String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);
        userDao.insert(user);
    }

    public boolean login(String username, String password) {
        User user = userDao.findUserByUsername(username).get();
        return user.getPassword().equals(password);
    }

}
